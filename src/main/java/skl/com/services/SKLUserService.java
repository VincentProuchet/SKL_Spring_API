/**
 * 
 */
package skl.com.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import skl.com.dao.Role;
import skl.com.dao.SKLUser;

/**
 * ceci est une couche de liaison
 * toutes les méthodes déclarées ici devront :
 * 		être implémentés dans vos implémentation
 * en échange 
 * 		elles seront utilisables dans tous le reste de L'API
 * 
 * @author VincentProuchet
 */
public interface SKLUserService extends UserDetailsService {
	/**
	 * list tous les utilisateurs
	 * @return
	 */
	public List<SKLUser> list();
	/**
	 * liste les utilisateurs ayant un role spécifique
	 * @param role
	 * @return
	 */
	public List<SKLUser> listByRole(Role... role);
	
	/**
	 * 
	 * @param user
	 * @return SKLUser instance managed
	 * @throws Exception
	 */
	public SKLUser create(SKLUser user) throws Exception;
	/**
	 * 
	 * @param id
	 * @return SKLUser instance
	 * @throws Exception
	 */
	public SKLUser read(int id) throws Exception;
	/**
	 * utilisé pour la connexion de l'utilisateur
	 * @param login
	 * @return
	 * @throws Exception
	 */
	public SKLUser read(String login) throws Exception;
	/**
	 * utilisé pour la recherche
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public SKLUser searchUser(String username) throws Exception;
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public SKLUser update(SKLUser user) throws Exception;
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public SKLUser delete(SKLUser user) throws Exception;
	/**
	 * retourne l'instance de persistance 
	 * de l'utilisateur connecté
	 * et présent dans le contexte de securité
	 *
	 */
	public SKLUser getConnectedUser() throws Exception;
	
}
