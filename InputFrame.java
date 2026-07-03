import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class InputFrame extends JFrame implements ActionListener {

	// Support system object
	private SupportSystem system;

	// Client fields
	private JTextField clientIdField;
	private JTextField clientNameField;
	private JTextField clientEmailField;

	// Ticket fields
	private JTextField ticketIdField;
	private JTextField descriptionField;
	private JTextField baseFeeField;
	private JTextField extraFeeField;

	// Combo box for ticket type
	private JComboBox<String> ticketTypeBox;

	// Buttons
	private JButton addClientBtn;
	private JButton addTicketBtn;
	private JButton clearBtn;
	private JButton openDisplayBtn;

	// Constructor
	public InputFrame(SupportSystem system) {

		this.system = system;

		setTitle("Input Frame");
		setSize(700, 600);
		setLayout(null);

		// ===== Client Section =====

		JLabel clientTitle = new JLabel("Add Client");

		clientTitle.setBounds(30, 20, 100, 30);

		add(clientTitle);

		JLabel clientIdLabel = new JLabel("Client ID:");

		clientIdLabel.setBounds(30, 60, 100, 25);

		add(clientIdLabel);

		clientIdField = new JTextField();

		clientIdField.setBounds(150, 60, 150, 25);

		add(clientIdField);

		JLabel clientNameLabel = new JLabel("Client Name:");

		clientNameLabel.setBounds(30, 100, 100, 25);

		add(clientNameLabel);

		clientNameField = new JTextField();

		clientNameField.setBounds(150, 100, 150, 25);

		add(clientNameField);

		JLabel clientEmailLabel = new JLabel("Client Email:");

		clientEmailLabel.setBounds(30, 140, 100, 25);

		add(clientEmailLabel);

		clientEmailField = new JTextField();

		clientEmailField.setBounds(150, 140, 150, 25);

		add(clientEmailField);

		addClientBtn = new JButton("Add Client");

		addClientBtn.setBounds(150, 190, 150, 30);

		addClientBtn.addActionListener(this);

		add(addClientBtn);

		// ===== Ticket Section =====

		JLabel ticketTitle = new JLabel("Add Ticket");

		ticketTitle.setBounds(30, 260, 100, 30);

		add(ticketTitle);

		JLabel typeLabel = new JLabel("Ticket Type:");

		typeLabel.setBounds(30, 300, 100, 25);

		add(typeLabel);

		String[] types = { "Software", "Hardware", "Urgent" };

		ticketTypeBox = new JComboBox<>(types);

		ticketTypeBox.setBounds(150, 300, 150, 25);

		add(ticketTypeBox);

		JLabel ticketIdLabel = new JLabel("Ticket ID:");

		ticketIdLabel.setBounds(30, 340, 100, 25);

		add(ticketIdLabel);

		ticketIdField = new JTextField();

		ticketIdField.setBounds(150, 340, 150, 25);

		add(ticketIdField);

		JLabel descriptionLabel = new JLabel("Description:");

		descriptionLabel.setBounds(30, 380, 100, 25);

		add(descriptionLabel);

		descriptionField = new JTextField();

		descriptionField.setBounds(150, 380, 150, 25);

		add(descriptionField);

		JLabel baseFeeLabel = new JLabel("Base Fee:");

		baseFeeLabel.setBounds(30, 420, 100, 25);

		add(baseFeeLabel);

		baseFeeField = new JTextField();

		baseFeeField.setBounds(150, 420, 150, 25);

		add(baseFeeField);

		JLabel extraFeeLabel = new JLabel("Extra Fee:");

		extraFeeLabel.setBounds(30, 460, 100, 25);

		add(extraFeeLabel);

		extraFeeField = new JTextField();

		extraFeeField.setBounds(150, 460, 150, 25);

		add(extraFeeField);

		addTicketBtn = new JButton("Add Ticket");

		addTicketBtn.setBounds(150, 510, 150, 30);

		addTicketBtn.addActionListener(this);

		add(addTicketBtn);

		clearBtn = new JButton("Clear");

		clearBtn.setBounds(330, 510, 120, 30);

		clearBtn.addActionListener(this);

		add(clearBtn);

		openDisplayBtn = new JButton("Open Display");

		openDisplayBtn.setBounds(480, 510, 150, 30);

		openDisplayBtn.addActionListener(this);

		add(openDisplayBtn);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				try {

					FileOutputStream FS1 = new FileOutputStream("system.ser");
					ObjectOutputStream OS1 = new ObjectOutputStream(FS1);
					OS1.writeObject(system);
					OS1.close();

				} catch (IOException ex) {

					JOptionPane.showMessageDialog(null, "Error saving data.");
				}
			}
		});

		setVisible(true);
	}

	// Handle button actions
	@Override
	public void actionPerformed(ActionEvent e) {

		// Add client
		if (e.getSource() == addClientBtn) {

			try {

				int id = Integer.parseInt(clientIdField.getText());

				String name = clientNameField.getText();

				String email = clientEmailField.getText();

				Client c = new Client(id, name, email);

				if (system.addClient(c)) {

					JOptionPane.showMessageDialog(this, "Client added successfully.");
				} else {

					JOptionPane.showMessageDialog(this, "Failed to add client.");
				}

			} catch (NumberFormatException ex) {

				JOptionPane.showMessageDialog(this, "Invalid input.");
			}
		}

		// Add ticket
		if (e.getSource() == addTicketBtn) {

			try {

				int type = ticketTypeBox.getSelectedIndex() + 1;

				int id = Integer.parseInt(ticketIdField.getText());

				String description = descriptionField.getText();

				double baseFee = Double.parseDouble(baseFeeField.getText());

				double extra = 0;

				if (!extraFeeField.getText().isEmpty()) {

					extra = Double.parseDouble(extraFeeField.getText());
				}

				if (system.addTicket(type, id, description, baseFee, extra)) {

					JOptionPane.showMessageDialog(this, "Ticket added successfully.");
				}

			} catch (DuplicateTicketException ex) {

				JOptionPane.showMessageDialog(this, "Duplicate Ticket ID.");
			} catch (NumberFormatException ex) {

				JOptionPane.showMessageDialog(this, "Invalid input.");
			}
		}

		// Clear fields
		if (e.getSource() == clearBtn) {

			clientIdField.setText("");
			clientNameField.setText("");
			clientEmailField.setText("");

			ticketIdField.setText("");
			descriptionField.setText("");
			baseFeeField.setText("");
			extraFeeField.setText("");
		}

		// Open display frame
		if (e.getSource() == openDisplayBtn) {

			new DisplayFrame(system);
		}
	}
}