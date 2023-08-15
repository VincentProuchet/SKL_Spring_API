package skl.com.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	@Column(name = "email")
	private String email;
	/** userName */
	@Column(nullable = false, unique = true)
	private String username;
	/** password : remember to add security */
	@Column(name = "password", nullable = false)
	private String password ;
	/** isActive */
	@Column(name = "is_active")
	private boolean isActive = false;

	/**
	 * authorities Roles implements GrantedAuthority
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
	 * this take authorities already the user already have and add it the one passed
	 * as parameters * @param Roles authority
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
		return isActive;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isActive;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isActive;
	}

	@Override
	public boolean isEnabled() {
		return isActive;
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
