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
 *
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

	public static final String ANON ="ANON";

	public static final String OWNER ="OWNER";

	public static final String ADMIN ="ADMINISTRATOR";

	public static final String USER ="USER";

}
