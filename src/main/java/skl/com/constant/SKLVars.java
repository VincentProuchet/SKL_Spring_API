package skl.com.constant;

/**
 * Centralise toutes les variables
 * Globales du Back-END 
 * vous avez besoins d'un variable int pour la durée de vos
 * cookies ? mettez la ici
 */
public abstract class SKLVars {

	public static final int TOKEN_LIFE = 36000; // ici 10H
	/** interval pour les tache planifiées */
	public static final long SHEDULED_INTERVAL = 7200000L;

	public static final String SESSION_SESSION_COOKIE_NAME = "JSESSIONID";
	/**
	 * LOGINPAGE chemin ver la page login dans le dossier ressources notez le fait
	 * que le dossier public est le dossier par défaut
	 */
	public static final String LOGINPAGE = "/login.html";
	public static final int MAX_AUTHORIZED_SESSION = 1;

	public static final String FRONT_END_URL = "http://localhost:4200";
	public static final String BACK_END_URL = "http://localhost:8080";


	public static final String CONTENT_TYPE_JSON = "application/json";

	public static final String CONTENT_TYPE = "Content-Type";

	public static final String CHARACTER_ENCODING = "UTF-8";

	/**
	 * - in replaceall will replace anything that is not a letter/number whithespace
	 * or a '-' - in mathes will say yes if found anything that is not a
	 * letter/number whithespace or a '-'
	 */
	public static final String REGEX_NAMES = "[^\\p{L}\\p{N}\s\\-]";


	/**
	 * city names can be up to 180 char
	 * with "' ", ' , -  or space in the name and as many as necessary
	 * but they can't be consecutives
	 * reject all other punctuations
	 * accept UPPERCASES
	 * */
	public static final String REGEX_CITY_NAMES = "^([\\p{L}\\d]{1,1}((?<appoSpace>' )|(?<appo>')|[\\s\\-]|[\\p{L}\\d]){0,1}[\\p{L}\\d]{1,2}){1,45}$";
	/**
	 * accept letters/numbers  and one -  or one space (ex : e-r or : e r)
	 * reject e- or -e
	 * must be 2 < lettersLong < 128
	 * reject uppercases
	 * reject punctuation
	 * reject over 128
	 *
	 */
		public static final String REGEX_VALIDATE_NAMES = "^[\\p{L}\\d]{1,32}{\\s\\-}{0,1}[\\p{L}\\d]{1,32}[\\\\p{L}\\\\d]{1,32}{\\\\s\\\\-}{0,1}[\\\\p{L}\\\\d]{1,32}$";
	/**
	 * Note that we accept digit for testing purpose
	 *
	 * - in matches will say yes if string contains nothing but letters,numbers,- or _
	 * 															and has 6 to 64 char
	 */
	public static final String REGEX_USERNAMES = "^([\\p{L}\\d]{1,1}[_\\-]{0,1}[\\p{L}\\d]{1,2}){1,16}$";
	/**
	 *verification des nom de famille
	 *accepte les noms composé :
	 * dupond robert
	 * dupond-robert
	 * dupond--robert
	 * dupont-robert patrick
	 * dupont--robert patrick
	 * @TODO modifier car accepte aussi dupond  robert
	 * mais rejete
	 * 	dupond   robert
	 */
	public static final String REGEX_HUMANS_LAST_NAMES =  "^([\\p{L}]{2,30}(\\-{1,2}| {1})|(?:de (la )?){1})?[\\p{L}]{0,30}(?: \\p{L}{0,30})?$";
	/**
	 * Note that we accept digit for testing purpose
	 * the regex accept composed first names
	 * must have a min of 2 letters

	 */
	public static final String REGEX_HUMANS_FIRST_NAMES = "^[\\p{L}\\d]{1,32}\\-{0,1}[\\p{L}\\d]{1,32}$";

	/**
	 * pattern for e-mail validation
	 * accept up to 2 - or . but not consecutives (ex a-a-a@d.com)
	 * accept one - after the @
	 * reject UPPERCASES
	 * reject punctuation
	 *
	 */
	public static final String REGEX_EMAIL2 =  "^[\\p{Ll}\\d]{1,30}[\\-\\.]{0,1}[\\p{Ll}\\d]{1,30}[\\-\\.]{0,1}[\\p{Ll}\\d]{1,30}@[\\p{Ll}\\d]{1,30}\\-{0,1}[\\p{Ll}\\d]{1,30}\\.[a-z0-9]{2,6}$";

	/**
	 * - in replaceAll remove multiple spaces placed in succession "a b" will become
	 * "ab" - in matches say yes if String contains 2 consecutive spaces
	 */
	public static final String REGEX_STUPID_WHITSPACES = " {2,}";
	/**
	 * In replaceAll will replace multiple - placed in
	 * succession "r---------g" will become "rg" - in matches will say yes if the
	 * String contains 2 consecutive -
	 */
	public static final String REGEX_STUPID_MINUS = "-{2,}";
}
