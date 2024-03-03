package skl.com.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import skl.com.dao.Role;
import skl.com.enums.SKLRoles;
import skl.com.repository.SKLRoleRepository;
import skl.com.services.RoleService;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RoleServiceImpl implements RoleService {

	@Autowired
	SKLRoleRepository repo;

	@Override
	public List<Role> list() {
		return repo.findAll();
	}

	@Override
	public Role read(int id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception());
	}

	@Override
	public Role read(String label) throws Exception {
		return repo.findByLabel(label).orElseThrow(() -> new Exception());
	}

	@Override
	public Role create(Role role)throws Exception {
		
		if ((role.getId()==0) || repo.existsById(role.getId()) || (repo.findByLabel(role.getLabel()).isPresent())) {
			throw new Exception();
		}
		return repo.save(role);

	}

	@Override
	public Role read(SKLRoles role) throws Exception {
		return repo.findById(role.getId()).orElseThrow(() -> new Exception());
	}
}
