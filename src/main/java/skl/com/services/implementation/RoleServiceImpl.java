package skl.com.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import skl.com.dao.Role;
import skl.com.enums.SKLRoles;
import skl.com.exception.BadRequestException;
import skl.com.exception.BaseAPIException;
import skl.com.exception.DataNotFoundException;
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
	public Role read(String label) throws BaseAPIException {
		return repo.findByIgnoringCaseRoleName(label).orElseThrow(() -> new DataNotFoundException("Le role n'existe pas"));
	}

	@Override
	public Role create(Role role)throws BaseAPIException {
		
		if (role == null) {
			throw new DataNotFoundException(" role ne peux être null ");
		}
		if(role.getRoleName() == null) {
			throw new DataNotFoundException(" role ne peux être null ");
		}
		if(repo.findByIgnoringCaseRoleName(role.getRoleName()).isPresent()){
			throw new BadRequestException(" le role existe déjà ");
		}
		
		return repo.save(role);

	}

	@Override
	public Role read(SKLRoles role) throws BaseAPIException {
		return repo.findById(role.getRole()).orElseThrow(() ->  new DataNotFoundException("Le role n'existe pas"));
	}
}
