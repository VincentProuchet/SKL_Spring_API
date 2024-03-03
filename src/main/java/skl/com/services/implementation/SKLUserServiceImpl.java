package skl.com.services.implementation;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import skl.com.constant.SKLRoleConst;
import skl.com.dao.SKLUser;
import skl.com.dto.SKLUserDTO;
import skl.com.exception.AuthenticationException;
import skl.com.exception.BaseAPIException;
import skl.com.exception.UserNotFoundException;
import skl.com.mapper.SklUserMapper;
import skl.com.repository.SKLUserRepository;
import skl.com.services.SKLUserService;

@Service
@AllArgsConstructor
@Transactional
public class SKLUserServiceImpl implements SKLUserService {

	@Autowired
	private SKLUserRepository repo;

	private SklUserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		return repo.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException(username + " not found"));
	}

	@Override
	@Secured({ SKLRoleConst.USER })
	public SKLUser getConnectedUser() throws BaseAPIException {
		SecurityContext context = SecurityContextHolder.getContext();

		Authentication auth = context.getAuthentication();
		if (auth == null) {
			throw new AuthenticationException(" vous n'êtes pas authentifié ");
		}
		String username = (String) auth.getPrincipal();
		return repo.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException(" pas d'utilisateur  "));
	}

	@Override
	public List<SKLUserDTO> getAll() {
		return repo.findAll().stream().map(userMapper::toDto).toList();
	}

	@Override
	public SKLUserDTO create(SKLUserDTO user) throws BaseAPIException {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public SKLUserDTO findById(int id) throws BaseAPIException {
		SKLUser user = repo.findById(id)
				.orElseThrow(() -> new UserNotFoundException(
						" pas d'utilisateur trouvé avec l'id ",
						Integer.toString(id)));
		
		return userMapper.toDto(user);
	}

	@Override
	public SKLUserDTO findByLogin(String login) throws BaseAPIException {
		SKLUser user = repo.findByLogin(login)
				.orElseThrow(() -> new UserNotFoundException(
						" pas d'utilisateur trouvé avec login ",
						login));		
		return userMapper.toDto(user);
	}

	@Override
	public Set<SKLUserDTO> searchUser(SKLUserDTO user) throws BaseAPIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SKLUserDTO update(SKLUserDTO user) throws BaseAPIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SKLUserDTO delete(SKLUserDTO user) throws BaseAPIException {
		// TODO Auto-generated method stub
		return null;
	}

}
