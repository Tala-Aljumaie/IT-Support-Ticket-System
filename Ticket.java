import java.io.*;
public abstract class Ticket implements Serializable {

	protected int id;
	protected String description;
	protected double baseFee;

	// Constructor to create a ticket
	public Ticket(int id, String description, double baseFee) {
		this.id = id;
		this.description = description;
		this.baseFee = baseFee;
	}

	// Returns the ticket ID
	public int getId() {
		return id;
	}

	// Returns the ticket description
	public String getDescription() {
		return description;
	}

	// Returns the ticket base fee
	public double getBaseFee() {
		return baseFee;
	}


	@Override
	public String toString() {

	    return "Ticket ID: " + id +
	           "\nDescription: " + description +
	           "\nBase Fee: " + baseFee;
	}

	// Abstract method to calculate the fee of each ticket based on its type
	// The method will be implemented in subclasses
	public abstract double calculateFee();

}
