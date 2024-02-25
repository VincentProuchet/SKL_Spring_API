package skl.com.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseAPIException {

	private static final long serialVersionUID = -2265292283755400298L;

	public BadRequestException( String... message) {
		super(HttpStatus.BAD_REQUEST, message);
	}

}
