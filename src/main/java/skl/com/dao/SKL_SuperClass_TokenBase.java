package skl.com.dao;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *  Supper classe des classes de token
 *  les classes dérivée ayant la mêmle structure autant n'avoir
 *  à faire qu'une seule fois l'implémentation
 *
 */
@MappedSuperclass
@AllArgsConstructor
@Getter
@Setter
public class SKL_SuperClass_TokenBase {
	/**
	 * token généré pour l'utilisateur
	 * comme ils sont censés être uniques
	 * ben ce seront les clés primaires
	 */
	@Id
	private String token;
	/**
	 * utilisateur concerné par le token
	 * il ne doit exister q'un seul token par utilisateur
	 * la relation one to one se charge de cette contrainte
	 */
	@OneToOne(targetEntity = SKLUser.class)
	private SKLUser user;
	/**
	 * date de création du token
	 * non on ne stocke pas la date de pérenmption (non statique )
	 */
	@Column(nullable = false)
	private LocalDateTime creation;
	/**
	 * Constructeur special pour les sous-classes
	 * utilisé lors de la génération du token
	 * @param user
	 */
	public SKL_SuperClass_TokenBase(SKLUser user) {
		this.user = user;
		this.creation = LocalDateTime.now();
		this.token = UUID.randomUUID().toString();
	}

}
