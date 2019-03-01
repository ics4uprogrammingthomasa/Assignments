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


public class main {

	private JFrame frame;
	private JTextField textFieldFileLocation;
	private JTextField textFieldItemAmount;

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
		lblPleaseInputData.setBounds(236, 11, 188, 23);
		frame.getContentPane().add(lblPleaseInputData);
		
		JLabel lblPleaseInputItem = new JLabel("Please Input Item Amount");
		lblPleaseInputItem.setBounds(34, 15, 135, 14);
		frame.getContentPane().add(lblPleaseInputItem);
		
		textFieldItemAmount = new JTextField();
		textFieldItemAmount.setBounds(44, 46, 109, 20);
		frame.getContentPane().add(textFieldItemAmount);
		textFieldItemAmount.setColumns(10);
	}
	
	// Once 'Get Data' button is pressed
	private void GetData() {
		String fileName;
		String[] line = new String[10];
		
		fileName = textFieldFileLocation.getText() + ".txt";
		
		try {
			FileReader fileReader = new FileReader(fileName);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);	
			
			int x = 0;
			while((line[x] = bufferedReader.readLine()) != null) {
                x++;
            }  
			
			bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("Please input a proper text file name");
		}
		catch(IOException ex) {
			System.out.println("There was an error reading the text document, this file may be corrupted");
		}
		
		for(int y = 0; y < 10; y++) {
			System.out.println(line[y]);
		}
	}
}
