package skl.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import skl.com.dao.SKLUser;
/**
 * @author VincentProuchet
 */
public interface SKLUserRepository extends JpaRepository<SKLUser, Integer> {

	Optional<SKLUser> findByUsername(String username);
	Optional<SKLUser> findByLogin(String login);
}
