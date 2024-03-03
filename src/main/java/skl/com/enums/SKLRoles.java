package skl.com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import skl.com.constant.SKLRoleConst;

/**
 * c'est l'exemple type de ce que vous
 * devriez adapter à vos besoins
 *
 * enumére les Roles pour que votre API
 * puisse en controler l'existence dans la Base de données
 *
 * si l'un des élèments énuméré ici n'existe pas en base de données
 * votre API est censé :
 *
 * - soit l'ajouter
 * - soit écrire dans le log avant d'arrêter l'execution
 *
 * Notez les écart d'identifiant important
 * celà permet l'ajout de roles intermédiaires.
 * @author VincentProuchet
 */
@AllArgsConstructor
@Getter
public enum SKLRoles {
	/**
	 * le role propriètaire
	 * role ayant tous les pouvoirs
	 * critique pour l'administration fonctionnement de l'api
	 */
	OWNER(SKLRoleConst.OWNER)
	/**
	 * les admins font ce que les admin doivent
	 * comme bloquer des comptes utilisateurs
	 */
	,ADMIN(SKLRoleConst.ADMIN)
	/**
	 * role de base des utilisateurs connectés
	 */
	,USER(SKLRoleConst.USER)
	;
	private String role;
}
