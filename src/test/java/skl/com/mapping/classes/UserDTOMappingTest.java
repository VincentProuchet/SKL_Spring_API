package skl.com.mapping.classes;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOMappingTest {
	int id;
	String name;
	String firstname;
	LocalDate dateOfBirth;
}
