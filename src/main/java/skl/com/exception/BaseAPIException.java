package skl.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;

/**
 * Vous devriez n'utiliser que des Exceptions étendant celle-ci - parce que
 * Spring va par défaut les retourner par la reponse http - parce qu'elle vous
 * permet de mettre un status à chaque type sans vous imposer de les chercher à
 * chaque fois - parce qu'elle utilise un stringbuilder, largement plus
 * performant que de la concaténation de String
 */
@Getter
public class BaseAPIException extends ResponseStatusException {

	private static final long serialVersionUID = 4968915439221191862L;

	public BaseAPIException(HttpStatus code, String message) {
		super(code, message);

	}

	/**
	 * simplifie la construction des messages d'erreurs en acceptant les chaines
	 * de caractère chainées
	 * 
	 * @param code
	 * @param message texte que vous pouvez passer indéfiniment
	 */
	public BaseAPIException(HttpStatus code, String... message) {
		super(code, constructMessage(message));

	}

	/**
	 * construit le message à partir de chaines de caractère chainées
	 */
	private static String constructMessage(String[] message) {
		StringBuilder texte = new StringBuilder();
		for (String string : message) {
			texte.append(string);
		}
		return texte.toString();
	}
}
