/**
 * 
 */
package skl.com.dao;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import skl.com.constant.SKLRoles;

/**
 * 
 */
@Entity
public class Role implements GrantedAuthority {
	/** serialVersionUID */
	private static final long serialVersionUID = -6560270968885240743L;
	private static final String AUTHORITY_PREFIX = SKLRoles.PREFIX;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;
	@Column(nullable = false,unique = true)
	private String label = "ANON";
	
	@Override
	public String getAuthority() {
		if (!this.label.startsWith(AUTHORITY_PREFIX)) {
			return new StringBuilder(AUTHORITY_PREFIX).append(this.label).toString();
		}
		return this.label;
	}

}
