package skl.com.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.util.Optionals;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skl.com.dao.id_class.SKLConnectFailId;

/**
 * permet de stocker les echecs de connection avec une rétention des données des
 * clients
 *
 */
@Entity
@IdClass(SKLConnectFailId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SKLConnectionFail {

	/**
	 * @TODO déplacer dans les constants
	 * 		 comme le nom l'indique ce sont les nom
	 *       possibles des header pour les addresses ip il semble qu'un seul
	 *       existe à la fois
	 */
	private static final List<String> IP_HEADER_CANDIDATES = new ArrayList<>();
	/**
	 * @TODO si possible ajouter plus de détail dans ce hash pour le moment une
	 *       simple adress IP
	 */
	@Id
	private int clientHash;
	@Id
	private LocalDateTime creation;
	@Column
	private String ip;
	
	{

		IP_HEADER_CANDIDATES.addAll(Arrays.asList("X-Forwarded-For",
				"Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_X_FORWARDED_FOR",
				"HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP",
				"HTTP_CLIENT_IP", "HTTP_FORWARDED_FOR", "HTTP_FORWARDED",
				"HTTP_VIA", "REMOTE_ADDR"));
	}

	public SKLConnectionFail(HttpServletRequest request) {
		creation = LocalDateTime.now();
		ip = SKLConnectionFail.getClientIpAddress();
		clientHash = ip.hashCode();
	}

	/**
	 * extrait l'IP du client si cela est possible contrôle qu'aucun proxy ne
	 * perturbe la récupération de l'adresse on ne voudrais pas bloquer un
	 * groupe d'utilisateur parce que un d'entre eux ne se souvient pas de son
	 * mot de passe
	 * 
	 * @return
	 */
	private static String getClientIpAddress() {
		String ip = "";
		HttpServletRequest request;
		// on vérifie si les attributs existent
		if (RequestContextHolder.getRequestAttributes() != null) {
			request = ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest();
		} else {
			return ip;
		}
		ip = Optional
				.ofNullable(
						IP_HEADER_CANDIDATES.stream().map(request::getHeader)
								/** @TODO remove magic string */
								.filter(h -> h != null && !h.isBlank()
										&& !"unknown".equalsIgnoreCase(h))
								.map(h -> h.split(",")[0])
								.reduce("", (h1, h2) -> h1 + ":" + h2))
				/**
				 * si null ->  aucun proxy n'existe dans le contexte 
				 * et que l'on peux sans risque recupérer celle-ci de
				 * getRemoteAddr()
				 */
				.orElse(request.getRemoteAddr());
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			// c'est une adresse locale
			ip = "127.0.0.1";
		}
		return ip;
	}
}
