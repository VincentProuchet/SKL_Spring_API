/**
 * 
 */
package skl.com.constant;

/**
 *  constantes des roles
 *  ce n'est pas une énumération
 *  c'est un déclaration des texte
 *  le but étant de ne pas ne pas avoir de chaine de caractére 
 *  qui traine dans le code
 */
public abstract class SKLRoleConst {
	/**
	 * Préfix des rôles
	 * son existance n'est pas un caprice de ma part
	 * mais une limitation voulue par les développeur de spring security 
	 * qui forcent l'ajout de ce préfix de manière asymétrique
	 * lors de la comparaison entre:
	 * 	- le grantedAuthority de l'utilisateur
	 *  - l'annotation @security du controleur ou méthode
	*/
	
	public static final String PREFIX = "ROLE_";
	/**
	 * role de base de toutes entités utilisateur
	 */
	public static final String ANON =SKLRoleConst.PREFIX +"ANON";
	
	/** 
	 * Propriètaire de l'API
	 * c'est le premier type de compte crée lors de l'initialization de l'api 
	 * Ils posséde le pouvoir de promouvoir/démettre les comptes admin
	 * c'est le seul type de compte pouvant promouvoir un compte au rang owner
	 */
	public static final String OWNER =SKLRoleConst.PREFIX + "OWNER";
	/** Administrateur de l'API */
	public static final String ADMIN =SKLRoleConst.PREFIX +"ADMINISTRATOR";
	
	/** utilisateur identifié de l'API */
	public static final String USER =SKLRoleConst.PREFIX +"USER";	
	
}
