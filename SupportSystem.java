import java.io.*;

public class SupportSystem implements Serializable {

	// Arrays to store tickets and clients
	private Node head;
	private Client[] clients;

	// Counters to track the number of stored tickets and clients
	private int ticketCount;
	private int clientCount;

	// Constructor to initialize the system with maximum capacity
	public SupportSystem(int maxClients) {
		head = null;
		clients = new Client[maxClients];
		ticketCount = 0;
		clientCount = 0;
	}

	// Adds a new ticket to the system
	// Returns true if the ticket is added successfully
	public boolean addTicket(int type, int id, String description, double baseFee, double extra)
			throws DuplicateTicketException {

		if (searchTicket(id) != null) {
			throw new DuplicateTicketException();
		}

		Ticket t = null;

		// Create ticket object
		if (type == 1) {
			t = new SoftwareTicket(id, description, baseFee);
		} else if (type == 2) {
			t = new HardwareTicket(id, description, baseFee, extra);
		} else if (type == 3) {
			t = new UrgentTicket(id, description, baseFee, extra);
		} else {
			return false;
		}

		// Create node
		Node newNode = new Node(t);

		// If list is empty
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			// Move to last node
			while (current.next != null) {
				current = current.next;
			}
			// Link new node
			current.next = newNode;
		}
		ticketCount++;
		return true;

	}

	// Removes a ticket using its ID
	// Returns true if the ticket is found and removed
	public boolean removeTicket(int id) {
		// Empty list
		if (head == null) {
			return false;
		}

		// Remove first node
		if (head.data.getId() == id) {
			head = head.next;
			ticketCount--;
			return true;
		}

		Node current = head;
		// Search for node before target
		while (current.next != null) {

			if (current.next.data.getId() == id) {
				current.next = current.next.next;
				ticketCount--;
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Searches for a ticket by its ID
	// Returns the ticket if found, otherwise returns null
	public Ticket searchTicket(int id) {
		Node current = head;

		// Traverse linked list
		while (current != null) {
			if (current.data.getId() == id) {
				return current.data;
			}
			current = current.next;
		}
		return null;
	}

	// Adds a client to the system
	// Returns true if the client is added successfully
	public boolean addClient(Client c) {
		if (clientCount < clients.length) {

			clients[clientCount] = c;
			clientCount++;
			return true;
		}

		// Array is full
		return false;
	}

	// Searches for a client by ID
	// Returns the client if found, otherwise null
	public Client searchClient(int id) {
		for (int i = 0; i < clientCount; i++) {

			if (clients[i].getId() == id) {
				return clients[i];
			}
		}

		return null;
	}

	// Recursive method to calculate the total revenue from all tickets
	public double totalRevenueRecursive(Node current) {

		// Base case
		if (current == null) {
			return 0;
		}
		// Recursive case
		return current.data.calculateFee() + totalRevenueRecursive(current.next);
	}

	// Displays all tickets stored in the system
	public String getAllTickets() {
	    if (head == null) {
	        return "No tickets found.";
	    }
	    String result = "";
	    Node current = head;
	    while (current != null) {
	        result += current.data.toString()
	                + "\n-------------------\n";

	        current = current.next;
	    }
	    return result;
	}
	
	
	public String getAllClients() {
	    if (clientCount == 0) {
	        return "No clients found.";
	    }
	    String result = "";
	    for (int i = 0; i < clientCount; i++) {
	        result += clients[i].toString()
	                + "\n-------------------\n";
	    }
	    return result;
	}

	
	// Getter for head
	public Node getHead() {
		return head;
	}
}
