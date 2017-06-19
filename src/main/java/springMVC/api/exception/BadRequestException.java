package springMVC.api.exception;

public class BadRequestException extends RuntimeException {

	public BadRequestException(String msg) {
		super(msg);
	}
	
	
	public BadRequestException(String message, Throwable cause) {
		super(message,cause);
	}
}
