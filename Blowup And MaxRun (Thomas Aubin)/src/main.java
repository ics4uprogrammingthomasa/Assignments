import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Add file reading
import java.io.*;

public class main {

	private JFrame frame;
	private JTextField textField;
	
	// Create public variables
	int program = 9;

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
		
		JLabel lblBlowupAndMax = new JLabel("Blowup and Max Run");
		lblBlowupAndMax.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBlowupAndMax.setBounds(120, 11, 177, 22);
		frame.getContentPane().add(lblBlowupAndMax);
		
		textField = new JTextField();
		textField.setBounds(135, 69, 142, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFileName = new JLabel("File Name:");
		lblFileName.setBounds(60, 72, 65, 14);
		frame.getContentPane().add(lblFileName);
		
		
		
		JButton btnMaxRun = new JButton("Max Run");
		btnMaxRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				program = 2;
				FetchData();		
			}
		});
		btnMaxRun.setBounds(289, 157, 89, 23);
		frame.getContentPane().add(btnMaxRun);
		
		JButton btnBlowup = new JButton("Blowup");
		btnBlowup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				program = 1;
				FetchData();	
			}
		});
		btnBlowup.setBounds(29, 157, 89, 23);
		frame.getContentPane().add(btnBlowup);
	}
	
	private void Blowup(String data) {	
		char[] chars = data.toCharArray();
		String dataOutput = "";
		
		for (int i = 0; i < chars.length; i++) {
			String singleLetter = Character.toString(chars[i]);
			
			if (singleLetter.matches("[1234567890]")) {
				try {
					for(int b = 0; b < Character.getNumericValue(chars[i]); b++) {
						dataOutput = dataOutput + chars[i+1];
					}
				}
				catch(Exception e) {
				}
			}
			else {
				dataOutput = dataOutput + chars[i];
			}
		}
		
		System.out.println(dataOutput);
	}
	
	private void MaxRun(String data) {
		char[] chars = data.toCharArray();
		char[] wordCount = new char[0];
		int[] valueCount = new int[0];
		
		for (int i = 0; i < chars.length-1; i++){
			if (chars[i] == chars[i+1]) {
				valueCount[valueCount.length+1] = i;
				wordCount[wordCount.length+1] = chars[i];
			}
		}
		
	}
	
	private void FetchData() {		
        String fileName = "DataMaxRun.txt";

        String line = null;

        try {
            FileReader fileReader =  new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                if (program == 1) {
                	Blowup(line);
                }
                if (program == 2) {
                	MaxRun(line);
                }
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
        }
	}
}
