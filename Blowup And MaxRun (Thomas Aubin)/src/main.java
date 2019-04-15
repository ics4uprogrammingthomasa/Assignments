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
//Add list library
import java.util.*;
import javax.swing.SwingConstants;

public class main {

	private JFrame frame;
	private JTextField txtInputFile;
	
	// Declare public variables
	int program = 9;
	String line;
	JLabel lblOutput;
	
	// Declare Blowup print lists
	List<String> printBlowup = new ArrayList<String>();
	
	// Declare MaxRun print lists
	List<Integer> printMaxRun = new ArrayList<Integer>();

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
		
		txtInputFile = new JTextField();
		txtInputFile.setBounds(135, 69, 142, 20);
		frame.getContentPane().add(txtInputFile);
		txtInputFile.setColumns(10);
		
		JLabel lblFileName = new JLabel("File Name:");
		lblFileName.setBounds(60, 72, 65, 14);
		frame.getContentPane().add(lblFileName);
		
		// If Max Run button is pressed
		JButton btnMaxRun = new JButton("Max Run");
		btnMaxRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Select second program
				program = 2;
				// Call Fetch Data function
				FetchData();		
			}
		});
		btnMaxRun.setBounds(289, 157, 89, 23);
		frame.getContentPane().add(btnMaxRun);
		
		// If Blowup button is pressed
		JButton btnBlowup = new JButton("Blowup");
		btnBlowup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Select first program
				program = 1;
				// Call Fetch Data function
				FetchData();	
			}
		});
		btnBlowup.setBounds(29, 157, 89, 23);
		frame.getContentPane().add(btnBlowup);
		
		lblOutput = new JLabel("Enter text file name and press program");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(70, 236, 293, 14);
		frame.getContentPane().add(lblOutput);
	}
	
	// Blowup function, passes data
	private void Blowup(String data) {
		// Turn current string into char array
		char[] chars = data.toCharArray();
		// Declare string to output
		String dataOutput = "";
		
		// For each index in char
		for (int i = 0; i < chars.length; i++) {
			// Convert current char into string
			String singleLetter = Character.toString(chars[i]);
			
			// If current letter is a number
			if (singleLetter.matches("[1234567890]")) {
				// Try..
				try {
					// Repeat for the value of current char
					for(int b = 0; b < Character.getNumericValue(chars[i]); b++) {
						// Add an extra letter to string
						dataOutput = dataOutput + chars[i+1];
					}
				}
				// If there is an error, do nothing and move on
				catch(Exception e) {
				}
			}
			// If it is not a number
			else {
				// Just add the single letter
				dataOutput = dataOutput + chars[i];
			}
		}
		
		// Add current Blowup to list
		printBlowup.add(dataOutput);
	}
	
	// Max Run function, passes data
	private void MaxRun(String data) {
		
		// Convert string into string array
		char[] chars = data.toCharArray();
		
		// Make list to hold counts
		List<Integer> count = new ArrayList<Integer>();
		
		// Declare currentCount and set to zero
		int currentCount = 1;
		
		// For each index in chars
		for (int i = 0; i < chars.length; i++) {
			// Try...
			try {
				// If the current index is equal to the next index
				if (chars[i] == chars[i+1]) {
					// Increase current count
					currentCount++;
				}
				// If the next char is different
				else {
					// Add current count
					count.add(currentCount);
					
					// Reset count to one
					currentCount = 1;
				}
			}
			// If there is an error, at the end of each string
			catch(Exception e) {
				// Add current count to list
				count.add(currentCount);
				
				// Reset current count
				currentCount = 1;
			}
		}
		
		// Find max count in list
		int maxCount = Collections.max(count);

		// Add current Blowup to list
		printMaxRun.add(maxCount);
	}
	
	private void PrintBlowup() {
		try {
			// Create a text file writer object and location
            FileWriter fileWriter = new FileWriter("BlowUpOutput.txt");
            
            // Create data output writer
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // For each class
            for (int i = 0; i < printBlowup.size(); i++) {
            	bufferedWriter.write(printBlowup.get(i));
	            
            	// Create a new line for the next class
            	bufferedWriter.newLine();          	
            	
            }
            
            // Close text file writer
            bufferedWriter.close();
            
            lblOutput.setText("Blow Up Succesfully Exucuted");
		}
		// If there was an error writing
        catch(IOException ex) {
        	lblOutput.setText("Error writing text file");
        }
	}
	
	private void PrintMaxRun() {
		try {
			// Create a text file writer object and location
            FileWriter fileWriter = new FileWriter("MaxRunOutput.txt");
            
            // Create data output writer
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // For each class
            for (int i = 0; i < printMaxRun.size(); i++) {
            	bufferedWriter.write(String.valueOf(printMaxRun.get(i)));
	            
            	// Create a new line for the next class
            	bufferedWriter.newLine();          	
            	
            }
            
            // Close text file writer
            bufferedWriter.close();
            
            lblOutput.setText("Max Run Succesfully Exucuted");
		}
		// If there was an error writing
        catch(IOException ex) {
        	lblOutput.setText("Error writing text file");
        }
	}
	
	// Fetch data function
	private void FetchData() {
		// Fetch file name from text file
        String fileName = txtInputFile.getText();
        
        // Clear output data
        printMaxRun.clear();
        printBlowup.clear();
        
        if (fileName.length() == 0) {
        	lblOutput.setText("Please input text file name");
        }
        else {
            // Add .txt to end of file name
            fileName = fileName + ".txt";
            
            // Set line to null
            line = null;

            // Try..
            try {
            	// Create a text file reader object
                FileReader fileReader =  new FileReader(fileName);
                
                // Create variable to hold current data
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                
                // While the current line has text, load that line
                while((line = bufferedReader.readLine()) != null) {
                	// If program 1 is selected
                    if (program == 1) {
                    	// Pass current line to blowup function
                    	Blowup(line);
                    }
                    // If program 2 is selected
                    if (program == 2) {
                    	// Pass current line to max run function
                    	MaxRun(line);
                    }
                }   
                
                // Close text file reader
                bufferedReader.close();  
                
                if (program == 1) {
                	PrintBlowup();
                }
                else {
                	PrintMaxRun();
                }
            }
            // If the text file cannot be found
            catch(FileNotFoundException ex) {
            	// Tell user text file cannot be found
            	lblOutput.setText("Unable to open file");         
            }
            // If there was a general error
            catch(IOException ex) {
            	// Tell user there was an error reading text file
            	lblOutput.setText("Error reading file");                  
            }
        }
	}
}
