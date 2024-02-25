package skl.com.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends BaseAPIException {

	private static final long serialVersionUID = -8112148434593485542L;

	public AuthenticationException(String... message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, message);
	}

}
