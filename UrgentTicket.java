import java.io.*;

public class UrgentTicket extends SoftwareTicket implements Serializable {

	// extra fee for urgent tickets
	private double urgentFee;

	// Constructor
	public UrgentTicket(int id, String description, double baseFee, double urgentFee) {
		super(id, description, baseFee); // call parent constructor
		this.urgentFee = urgentFee; // set urgent fee
	}

	// Override the calculateFee method
	// Returns the total fee (base fee + urgent fee)
	@Override
	public double calculateFee() {
		return baseFee + urgentFee;
	}

	// Displays the ticket information including the urgent fee
	@Override
	public String toString() {

	    return super.toString() +
	           "\nUrgent Fee: " + urgentFee +
	           "\nTotal Fee: " + calculateFee();
	}
}
