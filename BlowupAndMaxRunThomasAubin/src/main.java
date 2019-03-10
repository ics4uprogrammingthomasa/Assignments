import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;




// Add file reading ability
import java.io.*;
import java.awt.Font;
import javax.swing.SwingConstants;


public class main {
	
	

	private JFrame frame;
	private JTextField textFieldFileLocation;
	private JTextField textFieldItemAmount;
	
	// Declare variables
	JLabel lblOutput;

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
				// Fetch data from text file
				GetData();
			}
		});
		btnGetData.setBounds(172, 115, 89, 23);
		frame.getContentPane().add(btnGetData);
		
		textFieldFileLocation = new JTextField();
		textFieldFileLocation.setBounds(258, 45, 118, 23);
		frame.getContentPane().add(textFieldFileLocation);
		textFieldFileLocation.setColumns(10);
		
		JLabel lblPleaseInputData = new JLabel("Please Input Data File Name Below");
		lblPleaseInputData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPleaseInputData.setBounds(236, 11, 188, 23);
		frame.getContentPane().add(lblPleaseInputData);
		
		JLabel lblPleaseInputItem = new JLabel("Please Input Item Amount");
		lblPleaseInputItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPleaseInputItem.setBounds(34, 15, 141, 19);
		frame.getContentPane().add(lblPleaseInputItem);
		
		textFieldItemAmount = new JTextField();
		textFieldItemAmount.setBounds(44, 46, 109, 20);
		frame.getContentPane().add(textFieldItemAmount);
		textFieldItemAmount.setColumns(10);
		
		lblOutput = new JLabel("");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOutput.setBounds(64, 169, 315, 14);
		frame.getContentPane().add(lblOutput);
	}
	
	// Once 'Get Data' button is pressed
	private void GetData() {
		// Declare variables
		String data[];
		String fileName;
		String fileLength ;
		int goodData = 1;
		
		fileName = textFieldFileLocation.getText() + ".txt";
		
		fileLength = textFieldItemAmount.getText();
		
		data = new String[Integer.parseInt(fileLength)];
		
		try {
			FileReader fileReader = new FileReader(fileName);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);	
			
			for(int x = 0; x < Integer.parseInt(fileLength); x++) {
				data[x] = bufferedReader.readLine();
            }  
			
			bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
			lblOutput.setText("File not found!");
			goodData = 0;
		}
		catch(IOException ex) {
			lblOutput.setText("There was an error reading the text document, this file may be corrupted");
			goodData = 0;
		}

		if (data[data.length-1] == null) {
			lblOutput.setText("You have too many items");
			goodData = 0;
		}
		
		//for(int y = 0; y < data.length; y++) {
			//System.out.println(data[y]);
		//}
		
		if (goodData == 1) {
			lblOutput.setText("Successfully loaded " + data.length + " data packs");
		}
	}
}
