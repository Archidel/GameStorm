package by.htp6.store.dao.exception;

public class ConnectionPoolException extends Exception{
	private static final long serialVersionUID = 566442633398697897L;
	
	public ConnectionPoolException() {
		super();
	}
	public ConnectionPoolException(String message) {
		super(message);
	}
	public ConnectionPoolException(Exception e) {
		super(e);
	}
	public ConnectionPoolException(String message, Exception e) {
		super(message, e);
	}
}
