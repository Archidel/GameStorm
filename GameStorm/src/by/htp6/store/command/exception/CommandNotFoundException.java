package by.htp6.store.command.exception;

public class CommandNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public CommandNotFoundException() {
		super();
	}
	
	public CommandNotFoundException(String message) {
		super(message);
	}
	
	public CommandNotFoundException(Exception e) {
		super(e);
	}
	
	public CommandNotFoundException(String message, Exception e) {
		super(message, e);
	}
}
