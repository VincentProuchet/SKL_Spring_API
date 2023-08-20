package skl.com.dao;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity which represents a Collaborator implement UserDetails from
 * SpringSecurity project Document the differentiation between different types
 * of user is made by the list of Roles who are also used by spring security for
 * userAccess
 *
 * @author Joseph
 */
@Entity(name = "API_User")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SKLUser implements UserDetails {

	/** serialVersionUID */
	private static final long serialVersionUID = -2542617641751124157L;
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	/** nom */
	@Column(name = "last_name")
	private String lastName ;
	/** prénom */
	@Column(name = "first_name")
	private String firstName;
	/** email : identification mail address */
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	/** nom d'utilisateur pour l'identification sur d'éventuels forum */
	@Column(nullable = false, unique = true)
	private String username;
	/** login utilisé pour la connexion peux être identique a l'email */
	@Column(nullable = false, unique = true)
	private String login;
	/** mot de passe */
	@Column(name = "password", nullable = false)
	private String password ;
	/**
	 * date de creation du mot de passe courant
	 */
	@Column(name = "password_creation", nullable = false)
	private LocalDateTime passwordCreationv = null;
	/**
	 * date de creation du compte
	 */
	@Column(name = "account_creation", nullable = false)
	private LocalDateTime accountCreation = null;
	/**
	 * si le compte utilisateur à une validité pérmimée
	 */
	@Column
	private boolean expired = false;
	/**
	 * si le compte a été bloqué
	 */
	@Column
	private boolean locked = false;
	/**
	 * si le mot de passe a expiré
	 */
	@Column(name = "credential_expired")
	private boolean credentialExpired = false;
	/**
	 *   si le compte est activé
	 *   souvent par le clic de utilisateur 
	 *   sur un lien qui lui est envoyé par email
	 */
	@Column
	private boolean enabled = false;

	/**
	 * authorities Roles implemente GrantedAuthority
	 */
	@ManyToMany
	@Fetch(FetchMode.JOIN)
	private Collection<Role> authorities;

	@Override
	public Collection<Role> getAuthorities() {
		return this.authorities;
	}

	/**
	 * This is to simplify the Authority attribution for Spring Security yhea it
	 * look complicated for what it does its due to the Collection being and
	 * immutable and we can't bypass that because of the UserDetail implementation
	 */
	public void setRoles(Role... authority) {
		Set<Role> construct = new HashSet<>();
		
		for (Role role : authority) {

			construct.add(role);
		}
		this.authorities = construct;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !this.expired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !this.locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !this.credentialExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	
	/**
	 * SETTER
	 * @param name
	 */
	public void setFirstName(String name) {
		name =name.strip();
		this.firstName = name;
	}
	/**
	 * SETTER
	 * @param name
	 */
	public void setLastName(String name) {
		name =name.strip();
		this.lastName = name;
	}
	/**
	 * SETTER
	 * @param name
	 */
	public void setUsername(String name) {
		name =name.strip();
		this.username = name;
	}

}
