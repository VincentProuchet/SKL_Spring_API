/**
 * 
 */
package skl.com.dao;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skl.com.constant.SKLRoleConst;
import skl.com.enums.SKLRoles;

/**
 * @author VincentProuchet
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Role implements GrantedAuthority {
	/** serialVersionUID */
	private static final long serialVersionUID = -6560270968885240743L;
	private static final String AUTHORITY_PREFIX = SKLRoleConst.PREFIX;
	/**
	 * notez qu'ici l'id n'est pas une valeur généré
	 * vous pouvez le changer
	 * mais sachez que les ajouts de nouveau rôles en cours d'exploitation 
	 * de la base de données peuvent poser des problèmes
	 */
	@Id	
	private int id = 0;
	/**
	 * nom du role de préférence autodescriptif
	 */
	@Column(nullable = false,unique = true)
	private String label = SKLRoleConst.ANON ;
		
	@Override
	public String getAuthority() {
		// controle de l'existence du préfixe imposé par SPring Sécurity
		if (!this.label.startsWith(AUTHORITY_PREFIX)) {
			// si absent le préfixe est ajouter avant le retour
			return new StringBuilder(AUTHORITY_PREFIX).append(this.label).toString();
		}
		return this.label;
	}
	/**
	 * Constructeur
	 * de conversion SKLRole --> Role
	 * @param role
	 */
	public Role(SKLRoles role) {
		this.id = role.getId();
		this.label = role.getRole();
	}
	
}
