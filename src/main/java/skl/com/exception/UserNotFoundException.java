package skl.com.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class UserNotFoundException extends BaseAPIException {

	private static final long serialVersionUID = -3108782900666594405L;

	public UserNotFoundException(String... message) {
		super(HttpStatus.NOT_FOUND, message);
	}

}
