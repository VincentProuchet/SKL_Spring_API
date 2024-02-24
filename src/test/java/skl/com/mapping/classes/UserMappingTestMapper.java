package skl.com.mapping.classes;

import org.mapstruct.Mapper;

@Mapper
public interface UserMappingTestMapper {
	UserEntityMappingTest toEntity(UserDTOMappingTest userDTO);

	UserDTOMappingTest toDTO(UserEntityMappingTest user);
}
