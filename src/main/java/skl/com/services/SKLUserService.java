/**
 *
 */
package skl.com.services;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;

import skl.com.dao.SKLUser;
import skl.com.dto.SKLUserDTO;
import skl.com.exception.BaseAPIException;

public interface SKLUserService extends UserDetailsService {
	
	public List<SKLUserDTO> getAll();
	
	public SKLUserDTO create(SKLUserDTO user) throws BaseAPIException;
	
	public SKLUserDTO findById(int id) throws BaseAPIException;
	
	public SKLUserDTO findByLogin(String login) throws BaseAPIException;
	
	public Set<SKLUserDTO> searchUser(SKLUserDTO user) throws BaseAPIException;
	
	public SKLUserDTO update(SKLUserDTO user) throws BaseAPIException;
	
	public SKLUserDTO delete(SKLUserDTO user) throws BaseAPIException;
	
	/**
	 * retourne l'instance de persistance
	 * de l'utilisateur connecté
	 * présent dans le contexte de securité
	 */
	public SKLUser getConnectedUser() throws BaseAPIException;

}
