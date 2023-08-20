package skl.com.enums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Les status possibles de L'api
 * certains seront stockées dans la base de données
 */
@Entity
@Getter
@AllArgsConstructor
public enum API_statuses {
	/**
	 * l'API a trouvé tous les élèments necessaires à son fonctionnement 
	 */
	instaled(1,"instaled")
	/**
	 * le compte Owner initial n'a pas été validé
	 */
	,ownerNotValidated(0,"")
	/**
	 * Auncun compte Owner n'a été crée dans la base de donnée
	 */
	,ownerNotCreated(0,"")
	/**
	 * Aucun compte owner n'a été trouvé dans la base de données
	 * status transitoire qui méneras à l'enregistrement du status 
	 * OwnerNotCreated
	 */
	,ownerNotFound(0,"")
	/**
	 * aucun role n'a été trouvé dans la base de donnée
	 * statut transitoire
	 * le système créeras les Roles de base
	 */
	,rolesNotSets(0,"")
	/**
	 * le statut de l'api n'a pas été trouvé dans la base de donnée
	 * l'API n'est très certainement pas installée
	 */
	,noAPIStatus(0,"")
	;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	@Column
	private String label;
}
