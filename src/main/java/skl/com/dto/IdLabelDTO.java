package skl.com.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * un DTO pour transmettre tous les types de données
 * ayant simplement un couple id-label
 */
@Getter
@Setter
@EqualsAndHashCode
public class IdLabelDTO {

	private int id = 0;
	private String label;
}
