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
	
	private int id = 0;
	
	private String lastName = "";
	
	private String firstName = "";
	
	private String email = "";
	
	private String username = "";
	
	private LocalDateTime accountCreation = null;
	
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
