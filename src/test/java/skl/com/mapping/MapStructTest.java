package skl.com.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import skl.com.mapping.classes.UserDTOMappingTest;
import skl.com.mapping.classes.UserEntityMappingTest;
import skl.com.mapping.classes.UserMappingTestMapper;

/**
 * ces test ne servent qu'a controler les régression sur la librairie MapStruct
 * on controle juste pour s'assurer que tout fonctionne comme il le devrait
 * Notez que c'est tests n'ont pas besoins d'être exhautifs seulement de couvrir
 * suffisement pour les fonctionnalitées que vous utiliserez de la librairie
 */
@SpringBootTest
class MapStructTest {
	@Autowired
	private UserMappingTestMapper userMapper;

	@Test
	void testToEntity() {
		UserDTOMappingTest dto = new UserDTOMappingTest(1, "patrick", "swayze",
				LocalDate.of(2032, 06, 10));
		UserEntityMappingTest entity = userMapper.toEntity(dto);

		assertEquals(dto.id, entity.getId());
		assertEquals(dto.firstname, entity.getFirstname());
		assertEquals(dto.name, entity.getName());

	}

	@Test
	void testToDTO() {
		UserEntityMappingTest entity = new UserEntityMappingTest(1, "patrick",
				"swayze");
		UserDTOMappingTest dto = userMapper.toDTO(entity);

		assertEquals(entity.getId(), dto.id);
		assertEquals(entity.getFirstname(), dto.firstname);
		assertEquals(entity.getName(), dto.name);
		assertEquals(null, dto.dateOfBirth);

	}
}
