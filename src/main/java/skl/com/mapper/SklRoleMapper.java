package skl.com.mapper;

import org.mapstruct.Mapper;

import skl.com.dao.Role;
import skl.com.enums.SKLRoles;

@Mapper
public interface SklRoleMapper {
	
	Role toEntity(SKLRoles roleEnum);
}
