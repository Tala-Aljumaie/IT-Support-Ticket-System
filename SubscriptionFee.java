import java.io.*;

public class SubscriptionFee implements Payable, Serializable {

	private Client client;
	private double monthlyFee;

	// Constructor to create a new Subscription Fee
	public SubscriptionFee(Client client, double monthlyFee) {
		this.client = client;
		this.monthlyFee = monthlyFee;
	}

	// Implements the getAmount method from Payable
	// Returns the amount to be paid
	public double getAmount() {
		return monthlyFee;
	}

}
