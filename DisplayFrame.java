import javax.swing.*;
import java.awt.event.*;

public class DisplayFrame extends JFrame implements ActionListener {

	// Support system object
	private SupportSystem system;

	// Text area
	private JTextArea area;

	// Text fields
	private JTextField searchField;
	private JTextField removeField;

	// Buttons
	private JButton searchBtn;
	private JButton removeBtn;
	private JButton displayTicketsBtn;
	private JButton displayClientsBtn;
	private JButton revenueBtn;
	private JButton searchClientBtn;
	private JTextField searchClientField;

	// Constructor
	public DisplayFrame(SupportSystem system) {

		this.system = system;

		setTitle("Display Frame");
		setSize(700, 500);
		setLayout(null);

		// Search label
		JLabel searchLabel = new JLabel("Search Ticket ID:");

		searchLabel.setBounds(20, 20, 120, 25);

		add(searchLabel);

		// Search field
		searchField = new JTextField();

		searchField.setBounds(150, 20, 150, 25);

		add(searchField);

		// Search button
		searchBtn = new JButton("Search");

		searchBtn.setBounds(320, 20, 100, 25);

		searchBtn.addActionListener(this);

		add(searchBtn);

		// Search client label
		JLabel searchClientLabel = new JLabel("Search Client ID:");

		searchClientLabel.setBounds(450, 20, 120, 25);

		add(searchClientLabel);

		// Search client field
		searchClientField = new JTextField();

		searchClientField.setBounds(570, 20, 80, 25);

		add(searchClientField);

		// Search client button
		searchClientBtn = new JButton("Search Client");

		searchClientBtn.setBounds(450, 60, 200, 25);

		searchClientBtn.addActionListener(this);

		add(searchClientBtn);

		// Remove label
		JLabel removeLabel = new JLabel("Remove Ticket ID:");

		removeLabel.setBounds(20, 60, 120, 25);

		add(removeLabel);

		// Remove field
		removeField = new JTextField();

		removeField.setBounds(150, 60, 150, 25);

		add(removeField);

		// Remove button
		removeBtn = new JButton("Remove");

		removeBtn.setBounds(320, 60, 100, 25);

		removeBtn.addActionListener(this);

		add(removeBtn);

		// Text area
		area = new JTextArea();

		JScrollPane scroll = new JScrollPane(area);

		scroll.setBounds(20, 110, 640, 250);

		add(scroll);

		// Display tickets button
		displayTicketsBtn = new JButton("Display Tickets");

		displayTicketsBtn.setBounds(20, 390, 150, 30);

		displayTicketsBtn.addActionListener(this);

		add(displayTicketsBtn);

		// Display clients button
		displayClientsBtn = new JButton("Display Clients");

		displayClientsBtn.setBounds(190, 390, 150, 30);

		displayClientsBtn.addActionListener(this);

		add(displayClientsBtn);

		// Revenue button
		revenueBtn = new JButton("Show Revenue");

		revenueBtn.setBounds(360, 390, 150, 30);

		revenueBtn.addActionListener(this);

		add(revenueBtn);

		setVisible(true);
	}

	// Handle button actions
	@Override
	public void actionPerformed(ActionEvent e) {

		// Search ticket
		if (e.getSource() == searchBtn) {

			try {

				int id = Integer.parseInt(searchField.getText());

				Ticket t = system.searchTicket(id);

				if (t != null) {

					area.setText(t.toString());
				} else {

					area.setText("Ticket not found.");
				}

			} catch (Exception ex) {

				area.setText("Invalid input.");
			}
		}

		// Remove ticket
		if (e.getSource() == removeBtn) {

			try {

				int id = Integer.parseInt(removeField.getText());

				if (system.removeTicket(id)) {

					area.setText("Ticket removed successfully.");
				} else {

					area.setText("Ticket not found.");
				}

			} catch (Exception ex) {

				area.setText("Invalid input.");
			}
		}

		// Display all tickets
		if (e.getSource() == displayTicketsBtn) {

			area.setText(system.getAllTickets());
		}

		// Display all clients
		if (e.getSource() == displayClientsBtn) {

			area.setText(system.getAllClients());
		}

		// Show total revenue
		if (e.getSource() == revenueBtn) {

			double total = system.totalRevenueRecursive(system.getHead());

			area.setText("Total Revenue = " + total);
		}
		// Search client
		if (e.getSource() == searchClientBtn) {

			try {

				int id = Integer.parseInt(searchClientField.getText());
				Client c = system.searchClient(id);

				if (c != null) {

					area.setText(c.toString());
				} else {

					area.setText("Client not found.");
				}
			}

			catch (NumberFormatException ex) {

				area.setText("Please enter valid numbers.");
			}
		}
	}

}