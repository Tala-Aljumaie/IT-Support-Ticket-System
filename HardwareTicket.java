import java.io.*;

// Hardware ticket class that inherits from Ticket
public class HardwareTicket extends Ticket implements Serializable {

	// repair cost for the hardware issue
	private double repairCost;

	// Constructor
	public HardwareTicket(int id, String description, double baseFee, double repairCost) {
		super(id, description, baseFee); // call parent constructor
		this.repairCost = repairCost; // set repair cost
	}

	// Override the abstract method from Ticket
	// Calculates total fee = base fee + repair cost
	@Override
	public double calculateFee() {
		return baseFee + repairCost;
	}

	// Displays the ticket information including the repair cost
	@Override
	public String toString() {

	    return super.toString() +
	           "\nRepair Cost: " + repairCost +
	           "\nTotal Fee: " + calculateFee();
	}
}
