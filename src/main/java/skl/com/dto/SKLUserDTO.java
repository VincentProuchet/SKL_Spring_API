package skl.com.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skl.com.dao.Role;
import skl.com.dao.SKLUser;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class SKLUserDTO {
	/** id */
	private int id = 0;
	/** nom */
	private String lastName = "";
	/** prénom */
	private String firstName = "";
	/** email : identification mail address */
	private String email = "";
	/** nom d'utilisateur pour l'identification dans d'éventuels forum */
	private String username = "";
	/**
	 * date de creation du compte
	 */
	private LocalDateTime accountCreation = null;

	/**
	 * collection immutable/immutable
	 */
	private Collection<Role> authorities = new ArrayList<>();

	/**
	 * Constructeur
	 * conversion d'un SKLUser => SKLUserDTO
	 *
	 * @param user
	 */
	public SKLUserDTO(SKLUser user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.username = user.getUsername();
		this.accountCreation = user.getAccountCreation();
		this.authorities = user.getAuthorities();
	}
}
