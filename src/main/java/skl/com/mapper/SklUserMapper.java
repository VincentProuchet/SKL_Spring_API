package skl.com.mapper;

import org.mapstruct.Mapper;

import skl.com.dao.SKLUser;
import skl.com.dto.SKLUserDTO;

@Mapper
public interface SklUserMapper {
	
	SKLUser toEntity(SKLUserDTO dto);
	
	SKLUserDTO toDto(SKLUser user);
}
