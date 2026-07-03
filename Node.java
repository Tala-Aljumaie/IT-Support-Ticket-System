// Node class used in the linked list
// Each node stores a ticket object and
// a reference to the next node
import java.io.*;

public class Node implements Serializable {
	public Ticket data;
	public Node next;

	public Node(Ticket data) {
		this.data = data;
		this.next = null;

	}
}
