/**
 *
 */
package skl.com.services;

import java.util.List;

import skl.com.dao.Role;
import skl.com.enums.SKLRoles;
import skl.com.exception.BaseAPIException;

/**
 * @author VincentProuchet
 */
public interface RoleService {

	/**
	 * @return tous les roles trouvés dans la persistance
	 */
	public List<Role>list();

	/**
	 * @param label
	 * @return un role par son nom
	 * @throws Exception
	 */
	public Role read(String label)throws BaseAPIException;
	/**
	 *
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public Role read(SKLRoles role)throws BaseAPIException;
	/**
	 * ajoute un role à la persistence
	 * @param role
	 * @return retourne le rôle ajouté
	 * @throws Exception
	 */
	public Role create(Role role)throws BaseAPIException;


}
