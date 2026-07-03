import java.io.*;

// Software ticket class that inherits from Ticket
public class SoftwareTicket extends Ticket implements Serializable {

	// Constructor to create a software ticket
	public SoftwareTicket(int id, String description, double baseFee) {
		super(id, description, baseFee); // call parent constructor
	}

	// Override the abstract method from Ticket
	// Calculates the fee for a software ticket
	@Override
	public double calculateFee() {
		return baseFee;
	}
}
