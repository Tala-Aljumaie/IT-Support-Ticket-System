// Main class used to run the GUI system
// and load saved data from the file

import java.io.*;

public class Main {

	public static void main(String[] args) {

		// Support system object
		SupportSystem system;

		try {

			// Open the saved file
			FileInputStream FS1 = new FileInputStream("system.ser");

			// Read objects from the file
			ObjectInputStream OS1 = new ObjectInputStream(FS1);

			// Convert the object back to SupportSystem
			system = (SupportSystem) OS1.readObject();

			// Close stream
			OS1.close();
		}

		// Handle file reading errors
		catch (IOException e) {

			// Create new system if file not found
			system = new SupportSystem(100);
		}

		// Handle class conversion errors
		catch (ClassNotFoundException e) {

			// Create new system
			system = new SupportSystem(100);
		}

		// Open GUI frame
		new InputFrame(system);
	}
}