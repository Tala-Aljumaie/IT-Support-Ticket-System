import java.io.*;

public class ServiceCharge implements Payable, Serializable {

// attribute
	private Ticket ticket;

// constructor receives a ticket and assigns it
	public ServiceCharge(Ticket ticket) {
		this.ticket = ticket;
	}

// Override
// Polymorphism: calls calculateFee() depending on ticket type
	@Override
	public double getAmount() {
		return ticket.calculateFee();
	}

}
