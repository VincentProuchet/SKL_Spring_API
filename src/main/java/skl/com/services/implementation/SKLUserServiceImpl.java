package skl.com.services.implementation;

import java.util.List;

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
import skl.com.dao.Role;
import skl.com.dao.SKLUser;
import skl.com.repository.SKLUserRepository;
import skl.com.services.SKLUserService;

@Service
@AllArgsConstructor
@Transactional
public class SKLUserServiceImpl implements SKLUserService {

	/** repo */
	private SKLUserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
	}

	@Override
	public List<SKLUser> list() {

		return this.repo.findAll();
	}

	@Override
	public List<SKLUser> listByRole(Role... role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SKLUser create(SKLUser user) throws Exception {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public SKLUser read(int id) throws Exception {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> new Exception());
	}

	@Override
	public SKLUser read(String login) throws Exception {
		// TODO Auto-generated method stub
		return repo.findByLogin(login).orElseThrow(() -> new Exception());
	}

	@Override
	public SKLUser searchUser(String username) throws Exception {
		// TODO Auto-generated method stub
		return repo.findByUsername(username).orElseThrow(() -> new Exception());
	}

	@Override
	public SKLUser update(SKLUser user) throws Exception {
		SKLUser dbUser = this.read(user.getId());
		dbUser.setFirstName(user.getFirstName());
		dbUser.setLastName(user.getLastName());
		repo.save(dbUser);
		return user;
	}

	@Override
	public SKLUser delete(SKLUser user) throws Exception {
		SKLUser dbUser = this.read(user.getId());
		dbUser.setLocked(true);
		dbUser.setEnabled(false);

		repo.save(dbUser);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Secured({ SKLRoleConst.USER })
	public SKLUser getConnectedUser() throws Exception {
		SecurityContext context = SecurityContextHolder.getContext();// I left if well sequenced on purpose
		Authentication auth = context.getAuthentication();
		if (auth == null) {
			throw new Exception();
		}
		String username = (String) auth.getPrincipal();
		return repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Not found"));
	}

}
