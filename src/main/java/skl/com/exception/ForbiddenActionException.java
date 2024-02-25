package skl.com.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenActionException extends BaseAPIException {

	private static final long serialVersionUID = 8487643116123586344L;

	public ForbiddenActionException( String... message) {
		super(HttpStatus.FORBIDDEN, message);
	}

}
