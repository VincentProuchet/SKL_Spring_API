package skl.com.enums;



/**
 * status possibles de L'api
 * @author VincentProuchet
 */

public enum APIStatuses {
	/**
	 * l'API a trouvé tous les élèments necessaires à son fonctionnement
	 */
	ready
	/**
	 * le compte Owner en attente de validation
	 */
	,ownerValidationPending
	/**
	 * Aucun compte owner n'a été trouvé dans la base de données
	 */
	,ownerNotFound
	/**
	 * aucun role n'a été trouvé dans la base de donnée
	 * statut transitoire
	 * le système créeras les Roles de base
	 */
	,baseRolesNotSets
	/**
	 * le statut de l'api n'a pas été trouvé dans la base de donnée
	 * l'API n'est très certainement pas installée
	 */
	,noAPIStatus

	;
}
