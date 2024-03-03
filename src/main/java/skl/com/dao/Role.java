/**
 *
 */
package skl.com.dao;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skl.com.constant.SKLRoleConst;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = -6560270968885240743L;
	private static final String AUTHORITY_PREFIX = SKLRoleConst.PREFIX;

	@Id
	private String roleName = SKLRoleConst.ANON;

	@Override
	public String getAuthority() {
		// controle de l'existence du préfixe imposé par Spring Sécurity
		if (!this.roleName.startsWith(AUTHORITY_PREFIX)) {
			// si absent le préfixe est ajouté
			return new StringBuilder(AUTHORITY_PREFIX).append(this.roleName)
					.toString();
		}
		return this.roleName;
	}
}
