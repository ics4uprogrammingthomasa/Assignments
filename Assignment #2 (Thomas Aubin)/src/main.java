/*
 * Created by: Thomas Aubin
 * Created on: April 8, 2019
 * Created for: ICS4U Programming
 * Assignment #2 - Pass or Fail, Willow's Wild Ride, Martian Time
 * This program solves three different problems above
*/

// Add librarys
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;

// Add list library
import java.util.*;
// Add text file management library
import java.io.*;




public class main {
	
	// Declare public variables
	List<String> data = new ArrayList<String>();
	String fileOutput = "Output.txt";
	
	// Declare Martian Time Print Lists
	List<Integer> printMarsDays = new ArrayList<Integer>();
	List<Integer> printMarsHours = new ArrayList<Integer>();
	List<Integer> printMarsMinutes = new ArrayList<Integer>();
	List<Integer> printMarsSeconds = new ArrayList<Integer>();
	
	// Declare Willow's Wild Ride Print Lists
	List<Integer> printDaysLate = new ArrayList<Integer>();
	List<Integer> printTotalTime = new ArrayList<Integer>();
	List<Integer> printTotalBoxes= new ArrayList<Integer>();
	List<Integer> printBoredCat= new ArrayList<Integer>();
	
	// Declare Pass Or Fail Print Lists
	List<Integer> printPassed = new ArrayList<Integer>();
	List<Integer> printClassAverge = new ArrayList<Integer>();
	List<Integer> printHonourRoll = new ArrayList<Integer>();
	
	// Declare Global labels
	JLabel lblOutput;
	private JFrame frame;
	private JTextField txtFileName;

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
	
	// Function to declare all frame objects
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLoadData = new JButton("Load Data");
		// If fetch data button is pressed
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Call fetch data function
				fetchData();
			}
		});
		btnLoadData.setBounds(250, 35, 108, 23);
		frame.getContentPane().add(btnLoadData);
		
		JButton btnPassOrFail = new JButton("Pass Or Fail");
		// If PassOrFail button is pressed
		btnPassOrFail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Call Pass Or Fail program
				PassOrFail();
			}
		});
		btnPassOrFail.setBounds(10, 93, 133, 23);
		frame.getContentPane().add(btnPassOrFail);
		
		JButton btnWillowsWildRide = new JButton("Willow's Wild Ride");
		// If Willow's Wild Ride button is pressed 
		btnWillowsWildRide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Call Willow's Wild ride program
				WillowsWildRide();
			}
		});
		btnWillowsWildRide.setBounds(10, 138, 152, 23);
		frame.getContentPane().add(btnWillowsWildRide);
		
		JButton btnMartianTime = new JButton("Martian Time");
		// If Martian Time button is pressed
		btnMartianTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Call Martian time program
				MartianTime();
			}
		});
		btnMartianTime.setBounds(10, 184, 108, 23);
		frame.getContentPane().add(btnMartianTime);
		
		lblOutput = new JLabel("Please Load Data And Press Program");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(171, 94, 263, 111);
		frame.getContentPane().add(lblOutput);
		
		txtFileName = new JTextField();
		txtFileName.setBounds(10, 36, 146, 20);
		frame.getContentPane().add(txtFileName);
		txtFileName.setColumns(10);
		
		JLabel lblFileName = new JLabel("File Name:");
		lblFileName.setBounds(10, 11, 78, 14);
		frame.getContentPane().add(lblFileName);
	}
	
	// Function to fetch data for program
	private void fetchData() {
		// Declare local variables
		String fileName;
		String line = null;
		
		// Fetch file name from text box
		fileName = txtFileName.getText();

        // clear data for second load time
        data.clear();
        
        // Run normal code
        try {
        	// Declare text file object and load location
            FileReader fileReader =  new FileReader(fileName + ".txt");
            
            // Fetch data in text file
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // For each line until the end of the text file
            while((line = bufferedReader.readLine()) != null) {
            	// Add line to data list
            	data.add(line);
            }   
            
            // Close the file reading object
            bufferedReader.close();   
            
            // Tell user text file has been loaded
            lblOutput.setText("Loaded '" + fileName + "'");
        }
        // If text file cannot be found
        catch(FileNotFoundException ex) {
        	// If the name was nothing
        	if (fileName.length() == 0) {
        		// Tell user the file could not opened
        		lblOutput.setText("Unable to open file");
        		
        	}
        	// If the file name was wrong
        	else {
        		// Tell user you the set file could not be opened
        		lblOutput.setText("Unable to open file '" + fileName + "'");
        	}
        }
        // If the text file is corrupted
        catch(IOException ex) {
        	// Tell user there was an error reading the text file
        	lblOutput.setText("Error reading file '" + fileName + "'");                  
        }
        
	}
	
	// Pass Or Fail program
	private void PassOrFail() {
		// Run main program
		try {
			// Declare local variables
			List<String> grading = new ArrayList<String>();
			int students = 0;
			List<String> studentMarks = new ArrayList<String>();
			List<String> currentStudent = new ArrayList<String>();
			double currentMark = 0;
			int passed = 0;
			int classAverage = 0;
			int honourRoll = 0;
			
			// If data has nothing in it
			if (data.size() == 0) {
				// Tell user to load data first
				lblOutput.setText("Please load data first");
			}
			// Else, run Pass Or Fail
			else {
				// Load first line, grading, and split by spaces
				grading = Arrays.asList(data.get(0).split(" "));
				// Load second line, students, as integer
				students = Integer.parseInt(data.get(1));
				
				// For each student
				for(int i = 0; i < students; i++) {
					// Load student from data and store in list
					studentMarks.add(data.get(i+2));
				}
				
				// For each student loaded and their marks
				for (int i = 0; i < studentMarks.size(); i++) {
					// Split current student's marks
					currentStudent = Arrays.asList(studentMarks.get(i).split(" "));
					
					// Calculate first to four test with the weight divided by 100 for percentage
					currentMark += Integer.parseInt(currentStudent.get(0)) * (Double.parseDouble(grading.get(0)) / 100);
					currentMark += Integer.parseInt(currentStudent.get(1)) * (Double.parseDouble(grading.get(1)) / 100);
					currentMark += Integer.parseInt(currentStudent.get(2)) * (Double.parseDouble(grading.get(2)) / 100);
					currentMark += Integer.parseInt(currentStudent.get(3)) * (Double.parseDouble(grading.get(3)) / 100);
					
					// If their mark is greater than 50
					if (currentMark > 50) {
						// Increment passed
						passed++;
					}
					
					// If their marks is greater than 80
					if (currentMark > 80) {
						// Increment honourRoll
						honourRoll++;
					}
					
					// Add current marks to class mark
					classAverage += currentMark;
					
					// Reset current marks for next student in class
					currentMark = 0;
				}
				
				// Find the class average
				classAverage /= students;
				
				// Add class average to list
				printClassAverge.add(classAverage);
				// Add class passed to list
				printPassed.add(passed);
				// Add class honour roll to list
				printHonourRoll.add(honourRoll);
				
				// Remove current class from data
				data.subList(0, students+2).clear();
				
				// If there is still data, a class
				if (data.size() > 0) {
					// Call Pass Or Fail again
					PassOrFail();
				}
				// If there is no more data
				else {
					// Write data output
					try {
						// Create a text file writer object and location
			            FileWriter fileWriter = new FileWriter(fileOutput);
			            
			            // Create data output writer
			            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			            // For each class
			            for (int i = 0; i < printPassed.size(); i++) {
			            	// Output how many students passed in class
			            	bufferedWriter.write("Students Passed: ");
			            	bufferedWriter.write(String.valueOf(printPassed.get(i)));
			            	// Output the class average
			            	bufferedWriter.write(" --- Class Average: ");
			            	bufferedWriter.write(String.valueOf(printClassAverge.get(i)));
			            	// Output how many students got on the honour roll
			            	bufferedWriter.write(" --- Honour Roll: ");
			            	bufferedWriter.write(String.valueOf(printHonourRoll.get(i)));
				            
			            	// Create a new line for the next class
			            	bufferedWriter.newLine();          	
			            	
			            }
			            
			            // Close text file writer
			            bufferedWriter.close();
			            
			            // Tell user the program executed and data is ready
			            lblOutput.setText("Successfully Executed And Outputed Pass Or Fail");
					}
					// If there was an error writing
			        catch(IOException ex) {
			        	// Tell user there was an error writing
			        	lblOutput.setText("Error writing to file '" + fileOutput + "'");
			        }
			  }
			}
		}
		// If there was a error with the main program
		catch(Exception e) {
			// Tell user that the data set and program were not the same
			lblOutput.setText("Incorrect Data Or Program");
		}
}
	
	// Willow's Wild Ride function
	private void WillowsWildRide() {
		// Run main program
		try {
			// Declare local variables
			List<String> firstLine = new ArrayList<String>();
			int playDays = 0;
			int dueDate = 0;
			List<String> days = new ArrayList<String>();
			int boxes = 0;
			int counter = 0;
			int daysLate = 0;
			int totalTime = 0;
			int totalBoxes = 0;
			int boredCat = 0;
			
			
			// If data has nothing in it
			if (data.size() == 0) {
				// Tell user to load data first
				lblOutput.setText("Please load data first");
			}
			// Else, run Willow's Wild Ride
			else {
				// Fetch first line in data
				firstLine = Arrays.asList(data.get(0).split(" "));
				
				// Grab play days for first line
				playDays = Integer.parseInt(firstLine.get(0));
				// Grab due date from first line
				dueDate = Integer.parseInt(firstLine.get(1));
				
				// For how many days, fetch from data
				for (int i = 0; i < dueDate; i++) {
					days.add(data.get(i+1));
				}
				
				// For each day until due date
				for(int currentDay = 0; currentDay < dueDate; currentDay++) {
					// If there is a box on the set day
					if (days.get(currentDay).charAt(0) == 'B') {
						// Increment boxes
						boxes++;
						// Increment total boxes
						totalBoxes++;
					}
					// If there is a box
					if (boxes > 0) {
						// Increment counter for cat playing
						counter++;
					}
					// If the counter is equal to zero, then the cat has nothing to do
					if (counter == 0) {
						// Increment boredCat
						boredCat++;
					}
					// If the counter is equal to playDays, the cat is finished with the box
					if (counter == playDays) {
						// Set counter back to zero
						counter = 0;
						// Remove a box
						boxes--;
					}
				}
				
				// At the due date, if there are no boxes left and the cat is no longer playing
				if (boxes == 0 && counter == 0) {
					// Willow has all the boxes
					daysLate = 0;
				}
				// If the cat is still playing
				else {
					// Add days late for current play time regarding how many days the cat has played
					daysLate = playDays - counter;
					// Remove one box from playing
					boxes--;
					// Add the multiple of how many days it takes to play with how many boxes are left
					daysLate += playDays * boxes;
				}
				
				// The total time to complete the project is the due date with any extra days
				totalTime = dueDate + daysLate;
				
				// Add days late to list for print
				printDaysLate.add(daysLate);
				// Add total time to list for print
				printTotalTime.add(totalTime);
				// Add total boxes to list for print
				printTotalBoxes.add(totalBoxes);
				// Add bored cat days to list for print
				printBoredCat.add(boredCat);
				
				// Remove first line in data for the next day
				data.subList(0, dueDate+1).clear();
				
				// If there is data left
				if (data.size() > 0) {
					// Rerun Willow's Wild Ride
					WillowsWildRide();
				}
				// If there is no data left
				else {	
					// Try to print data
					try {
						// Create text file object with file name
			            FileWriter fileWriter = new FileWriter(fileOutput);
			            
			            // Create data holder
			            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			            // For each project Willow did
			            for (int i = 0; i < printDaysLate.size(); i++) {
			            	// Output how many days late
			            	bufferedWriter.write("Days Late: ");
			            	bufferedWriter.write(String.valueOf(printDaysLate.get(i)));
			            	// Output how many days to complete project
			            	bufferedWriter.write(" --- Total Days: ");
			            	bufferedWriter.write(String.valueOf(printTotalTime.get(i)));
			            	// Output how many boxes Willow got at the end
			            	bufferedWriter.write(" --- You Ended With Set Boxes: ");
			            	bufferedWriter.write(String.valueOf(printTotalBoxes.get(i)));
			            	// output how many days the cat was bored
			            	bufferedWriter.write(" --- The Cat Was Bored For Set Days: ");
			            	bufferedWriter.write(String.valueOf(printBoredCat.get(i)));
				            
			            	// Create a new line for the next project
			            	bufferedWriter.newLine();          	
			            	
			            }
			            
			            // Close the text file writer
			            bufferedWriter.close();
			            
			            // Tell user the project executed and the output is available
			            lblOutput.setText("Successfully Executed And Outputed");
			        }
					// If the was a problem writing text file
			        catch(IOException ex) {
			        	// Tell user there was an error writing text file
			        	lblOutput.setText("Error writing to file '" + fileOutput + "'");
			        }
			  }
			}
		}
		// If there was an error with the program
		catch(Exception e) {
			// Tell user the data and program were the wrong match
			lblOutput.setText("Incorrect Data Or Program");
		}
}
	
	// Martian Time program
	private void MartianTime() {
		// Run main program
		try {
			// Declare private variables
			List<String> earth = new ArrayList<String>();
			double EARTHTOMARS = 86400/88642.663;
			double earthTime = 0;
			double marsTime = 0;
			int marsDays = 0;
			int marsHours = 0;
			int marsMinutes = 0;
			int marsSeconds = 0;
			
			// If data has nothing in it
			if (data.size() == 0) {
				// Tell user to load data first
				lblOutput.setText("Please load data first");
			}
			// Else, run Willow's Wild Ride
			else {
				// Fetch first line from earth, all time
				earth = Arrays.asList(data.get(0).split(" "));
				
				// Fetch minutes from earth time
				earthTime = Double.parseDouble(earth.get(2));
				// Turn minutes into hours
				earthTime /= 60;
				
				// Fetch hours from earth time and add to current earth time
				earthTime += Double.parseDouble(earth.get(1));
				// Turn hours into days
				earthTime /= 24;
				
				// Fetch days from earth time and add to current earth time
				earthTime += Double.parseDouble(earth.get(0));
				
				// Remove 1 earth day to start at day 0
				earthTime -= 1;
				
				// Find marsTime by using earth to marsTime ratio
				marsTime = earthTime * EARTHTOMARS;
				
				// Grab only the int value of mars time, this will be whole days
				marsDays = (int)marsTime;
				// Remove whole days from mars time
				marsTime -= marsDays;
				// Add one day back
				marsDays += 1;
				
				// Turn mars time into hours
				marsTime *= 24;
				// Grab only int value of mars time, this will be whole hours
				marsHours = (int)marsTime;
				// Remove whole hours from mars time
				marsTime -= marsHours;
				
				// Turn mars time into minutes
				marsTime *= 60;
				// Grab only whole minutes from only int value
				marsMinutes = (int)marsTime;
				// Remove whole minutes from mars time
				marsTime -= marsMinutes;
				
				// Turn mars time into seconds
				marsTime *= 60;
				// Grab only whole seconds
				marsSeconds = (int)marsTime;
				
				// Add mars days to list for output
				printMarsDays.add(marsDays);
				// Add mars hours to list for output
				printMarsHours.add(marsHours);
				// Add mars minutes to list for output
				printMarsMinutes.add(marsMinutes);
				// Add mars seconds to list for output
				printMarsSeconds.add(marsSeconds);
				
				// Remove current day from data
				data.remove(0);
				// If there is still data
				if (data.size() > 0) {
					// Recall Martian Time
					MartianTime();
				}
				// If there is no data left
				else {	
					// Try to write text file
					try {
						// Create text file object with file name
			            FileWriter fileWriter = new FileWriter(fileOutput);
			            
			            // Create data holder for text file
			            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			            // For each time calculated
			            for (int i = 0; i < printMarsDays.size(); i++) {
			            	// If mars hours and mars minutes are less then 10
			            	if (printMarsHours.get(i) < 10 && printMarsMinutes.get(i) < 10) {
			            		// Print mars time with added zeros
				            	bufferedWriter.write("Day: " + printMarsDays.get(i) + ", 0" + printMarsHours.get(i) + ":0" + printMarsMinutes.get(i) + "." + printMarsSeconds.get(i));

							}
			            	// If only mars hours is less than 10
			            	else if (printMarsHours.get(i) < 10) {
			            		// Print mars time with added zeros
				            	bufferedWriter.write("Day: " + printMarsDays.get(i) + ", 0" + printMarsHours.get(i) + ":" + printMarsMinutes.get(i) + "." + printMarsSeconds.get(i));

							}
			            	// If only mars minutes is less than 10
							else if (printMarsMinutes.get(i) < 10) {
								// Print mars time with added zeros
								bufferedWriter.write("Day: " + printMarsDays.get(i) + ", " + printMarsHours.get(i) + ":0" + printMarsMinutes.get(i) + "." + printMarsSeconds.get(i));
							}
			            	// If all time is greater than 10
							else {
								// Print mars time
								bufferedWriter.write("Day: " + printMarsDays.get(i) + ", " + printMarsHours.get(i) + ":" + printMarsMinutes.get(i) + "." + printMarsSeconds.get(i));
							}
			            	
			            	// Create new line for the next day calculated
			            	bufferedWriter.newLine();
			            }
			            
			            // Close the text file writer
			            bufferedWriter.close();
			            
			            // Tell user the program executed and data is available
			            lblOutput.setText("Successfully Executed And Outputed");
			        }
					// If there was a problem writing text file
			        catch(IOException ex) {
			        	// Tell user there was an error writing text file
			        	lblOutput.setText("Error writing to file '" + fileOutput + "'");
			        }
				}
			}
		}
		// If there was an error running program
		catch(Exception e) {
			// Tell user that the data set and program were not the same
			lblOutput.setText("Incorrect Data Or Program");
		}
	}
}
