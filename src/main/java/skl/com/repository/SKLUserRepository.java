package skl.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import skl.com.dao.SKLUser;
import java.util.Optional;
/**
 * @author VincentProuchet
 */
public interface SKLUserRepository extends JpaRepository<SKLUser, Integer> {

	Optional<SKLUser> findByUsername(String username);
	Optional<SKLUser> findByLogin(String login);
}
