package skl.com.dao.id_class;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * clef composé pour les classes de token
 * pour faire simple cela permet d'avoir des clés composées dans les classes
 */
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class SKLConnectFailId implements Serializable {


	/** serialVersionUID */
	private static final long serialVersionUID = 1318095923294866365L;

	private int clientHash;

	private LocalDateTime creation;

}
