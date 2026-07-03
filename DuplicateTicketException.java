import java.io.*;

public class DuplicateTicketException extends Exception implements Serializable {

	DuplicateTicketException() {
		super();
	}

	DuplicateTicketException(String msg) {
		super(msg);
	}

}
