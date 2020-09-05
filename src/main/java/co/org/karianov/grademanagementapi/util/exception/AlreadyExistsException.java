package co.org.karianov.grademanagementapi.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class AlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 5529879115162586035L;

	public AlreadyExistsException(String message) {
		super(message);
	}

}
