package skl.com.exception;

public class BadRequestException extends SKL_Exception {

	/** serialVersionUID */
	private static final long serialVersionUID = -2265292283755400298L;

	public BadRequestException(String code, String... message) {
		super(code, message);
	}

}
