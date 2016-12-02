package by.htp6.store.command.exception;

public class IncorrentDataException extends Exception{
	private static final long serialVersionUID = 1L;

	public IncorrentDataException() {
		super();
	}
	
	public IncorrentDataException(String message) {
		super(message);
	}
	
	public IncorrentDataException(Exception e) {
		super(e);
	}
	
	public IncorrentDataException(String message, Exception e) {
		super(message, e);
	}
}
