/**
 * 
 */
package skl.com.constant;

/**
 * classe de constantes 
 * contient les constantes relatives aux role 
 * du squelette d'API spring security
 */
public abstract class SKLRoles {
	/**
	 * Préfix des rôles
	 * son existance n'est pas un caprice de ma part
	 * mais un limitation voulue par les développeur de spring security 
	 * qui forcent l'ajout de ce préfix de manière asymétrique
	 * lors de la comparaison entre:
	 * 	- le grantedAuthority de l'utilisateur
	 *  - l'annotation @security du controleur ou méthode
	*/
	public static final String PREFIX = "ROLE_";
	/**
	 * role de base de toutes entité utilisateur
	 */
	public static final String ANON ="ANON";
	
	
	
	
}
