package skl.com.controlers;

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

import lombok.AllArgsConstructor;
import skl.com.constant.SKLRoleConst;
import skl.com.constant.SKLRoutes;
import skl.com.dao.SKLUser;
import skl.com.dto.SKLUserDTO;
import skl.com.services.SKLUserService;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/" + SKLRoutes.ACCOUNT, produces = MediaType.APPLICATION_JSON_VALUE)
public class SKLUserControler {

	private SKLUserService userSrv;

	@PostMapping(path = "/" + SKLRoutes.SIGNUP)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void create() {
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public SKLUserDTO read(@PathVariable int id) {
		return new SKLUserDTO();
	}

	@PostMapping()
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@Secured({ SKLRoleConst.USER })
	public SKLUserDTO update(@RequestBody SKLUser user) {
		return new SKLUserDTO(user);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@Secured({ SKLRoleConst.USER })
	public void delete() {

	}
}
