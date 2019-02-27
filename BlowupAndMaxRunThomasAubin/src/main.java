import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class main {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Create 'Get Data' button and button listener
		JButton btnGetData = new JButton("Get Data");
		btnGetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Start Main Program
				GetData();
			}
		});
		btnGetData.setBounds(173, 96, 89, 23);
		frame.getContentPane().add(btnGetData);
		
		textField = new JTextField();
		textField.setBounds(157, 48, 118, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPleaseInputData = new JLabel("Please Input Data File Name Below");
		lblPleaseInputData.setBounds(137, 11, 188, 23);
		frame.getContentPane().add(lblPleaseInputData);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(60, 175, 37, 15);
		frame.getContentPane().add(btnNewButton);
	}
	
	// Once 'Get Data' button is pressed
	private void GetData() {
		
	}
}
