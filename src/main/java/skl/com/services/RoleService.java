/**
 * 
 */
package skl.com.services;

import java.util.List;
import java.util.Set;

import skl.com.dao.Role;

/**
 * @author VincentProuchet
 */
public interface RoleService {
	
	public static Set<Role> roles = null;
	/** 
	 * @return tous les roles trouvés dans la persistance
	 */
	public List<Role>list();
	/**
	 * @param id
	 * @return un role par son identifiant
	 * @throws Exception
	 */
	public Role read(int id)throws Exception;
	/**
	 * @param label
	 * @return un role par son nom
	 * @throws Exception
	 */
	public Role read(String label)throws Exception;
	/**
	 * ajoute un role à la persistence
	 * @param role
	 * @return retourne le rôle ajouté
	 * @throws Exception
	 */
	public Role create(Role role);
	
}
