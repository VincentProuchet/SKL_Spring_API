/**
 *
 */
package skl.com.services;

import java.util.List;

import skl.com.dao.Role;
import skl.com.enums.SKLRoles;

/**
 * @author VincentProuchet
 */
public interface RoleService {

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
	 *
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public Role read(SKLRoles role)throws Exception;
	/**
	 * ajoute un role à la persistence
	 * @param role
	 * @return retourne le rôle ajouté
	 * @throws Exception
	 */
	public Role create(Role role)throws Exception;


}
