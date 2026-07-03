import java.io.*;

public class Client implements Serializable {
	private int id;
	private String name;
	private String email;

	// Constructor to create a new client
	public Client(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	// Returns the client ID
	public int getId() {
		return id;
	}

	// Returns the client name
	public String getName() {
		return name;
	}

	// Returns the client email
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {

	    return "Client ID: " + id +
	           "\nName: " + name +
	           "\nEmail: " + email;
	}
}
