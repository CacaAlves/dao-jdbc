package db;

public class DbIntregityException extends RuntimeException {

	private static final long serialVersionUID = 1L;	

	public DbIntregityException(String msg) {
		super(msg);
	}
}
