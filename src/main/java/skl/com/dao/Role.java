/**
 * 
 */
package skl.com.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import skl.com.constant.SKLRoleConst;

/**
 * 
 */
@Entity
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

}
