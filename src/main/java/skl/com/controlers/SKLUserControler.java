package skl.com.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import skl.com.constant.SKLRoleConst;
import skl.com.constant.SKLRoutes;
import skl.com.dao.SKLUser;
import skl.com.dto.SKLUserDTO;
import skl.com.mapper.SklUserMapper;
import skl.com.services.SKLUserService;

@RestController
@AllArgsConstructor
@ResponseStatus(value = HttpStatus.OK)
@RequestMapping(value = "/" + SKLRoutes.ACCOUNT)
public class SKLUserControler {

	@Autowired
	private SKLUserService userSrv;
	@Autowired
	private SklUserMapper userMapper;

	@PostMapping(path = "/" + SKLRoutes.SIGNUP)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void create(@RequestBody SKLUser user) {
		//TODO  faire le create
	}

	@GetMapping(path = "/{id}")
	public SKLUserDTO read(@PathVariable int id) {
		//TODO seulement codé pour avoir une réponse basique 
		return userMapper.toDto(new SKLUser());
	}

	@PostMapping()
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@Secured({ SKLRoleConst.USER })
	public SKLUserDTO update(@RequestBody SKLUser user) {
		//TODO seulement codé pour avoir une réponse basique
		return new SKLUserDTO(user);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@Secured({ SKLRoleConst.USER })
	public void delete() {
		// TODO faire le delete
	}
}
