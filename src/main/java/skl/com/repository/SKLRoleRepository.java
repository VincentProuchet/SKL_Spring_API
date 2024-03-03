package skl.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import skl.com.dao.Role;

public interface SKLRoleRepository extends JpaRepository<Role, String> {
	Optional<Role> findByIgnoringCaseRoleName(String roleName);
}
