/**
 *
 */
package skl.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import skl.com.dao.Role;


/**
 * @author VincentProuchet
 */
public interface SKLRoleRepository extends JpaRepository<Role,Integer> {
Optional<Role> findByLabel(String label);
}
