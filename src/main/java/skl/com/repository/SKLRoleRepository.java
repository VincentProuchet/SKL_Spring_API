/**
 * 
 */
package skl.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import skl.com.dao.Role;
import java.util.Optional;


/**
 * @author VincentProuchet
 */
public interface SKLRoleRepository extends JpaRepository<Role,Integer> {
Optional<Role> findByLabel(String label);
}
