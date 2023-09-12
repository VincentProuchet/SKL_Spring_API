package skl.com.enums;



/**
 * Les status possibles de L'api
 * certains seront stockées dans la base de données
 * @author VincentProuchet
 */

public enum API_statuses {
	/**
	 * l'API a trouvé tous les élèments necessaires à son fonctionnement
	 */
	ready
	/**
	 * le compte Owner en attente de validationinitial n'a pas été validé
	 */
	,ownerValidationPending
	/**
	 * Auncun compte Owner n'a été crée dans la base de donnée
	 */
	,ownerNotCreated
	/**
	 * Aucun compte owner n'a été trouvé dans la base de données
	 * status transitoire qui méneras à l'enregistrement du status
	 * OwnerNotCreated
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
