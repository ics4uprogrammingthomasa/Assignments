/*
 * Created by: Thomas Aubin
 * Created on: April 8, 2019
 * Created for: ICS4U Programming
 * Assignment #2 - Pass or Fail, Willow's Wild Ride, Martian Time
 * This program solves three different problems above
*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

// Add list library
import java.util.*;

public class main {
	
	// Declare public variables
	List<String> data = new ArrayList<String>();

	private JFrame frame;

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
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fetchData();
			}
		});
		btnLoadData.setBounds(163, 49, 89, 23);
		frame.getContentPane().add(btnLoadData);
		
		JButton btnPassOrFail = new JButton("Pass Or Fail");
		btnPassOrFail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassOrFail();
			}
		});
		btnPassOrFail.setBounds(10, 166, 89, 23);
		frame.getContentPane().add(btnPassOrFail);
		
		JButton btnWillowsWildRide = new JButton("Willow's Wild Ride");
		btnWillowsWildRide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WillowsWildRide();
			}
		});
		btnWillowsWildRide.setBounds(153, 166, 122, 23);
		frame.getContentPane().add(btnWillowsWildRide);
		
		JButton btnMartianTime = new JButton("Martian Time");
		btnMartianTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MartianTime();
			}
		});
		btnMartianTime.setBounds(316, 166, 108, 23);
		frame.getContentPane().add(btnMartianTime);
	}
	
	private void fetchData() {
		String fileName = "Martian Time.txt";

        String line = null;
        data.clear();

        try {
            FileReader fileReader =  new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	data.add(line);
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
	
	private void PassOrFail() {
		// Declare local variables
		List<String> grading = new ArrayList<String>();
		int students = 0;
		List<String> studentMarks = new ArrayList<String>();
		List<String> currentStudent = new ArrayList<String>();
		double currentMark = 0;
		int passed = 0;
		
		// If data has nothing in it
		if (data.size() == 0) {
			// Tell user to load data first
			System.out.println("Please load data first");
		}
		// Else, run Pass Or Fail
		else {
			// Load first line, grading, and split by spaces
			grading = Arrays.asList(data.get(0).split(" "));
			// Load second line, students, as integer
			students = Integer.parseInt(data.get(1));
			
			for(int i = 0; i < students; i++) {
				studentMarks.add(data.get(i+2));
			}
			
			for (int i = 0; i < studentMarks.size(); i++) {
				currentStudent = Arrays.asList(studentMarks.get(i).split(" "));
				
				currentMark += Integer.parseInt(currentStudent.get(0)) * (Double.parseDouble(grading.get(0)) / 100);
				currentMark += Integer.parseInt(currentStudent.get(1)) * (Double.parseDouble(grading.get(1)) / 100);
				currentMark += Integer.parseInt(currentStudent.get(2)) * (Double.parseDouble(grading.get(2)) / 100);
				currentMark += Integer.parseInt(currentStudent.get(3)) * (Double.parseDouble(grading.get(3)) / 100);
				
				if (currentMark > 50) {
					passed++;
				}
				
				currentMark = 0;
			}
			
			System.out.println(passed);
		}
		
		data.subList(0, students+2).clear();
		if (data.size() > 0) {
			PassOrFail();
		}
	}
	
	private void WillowsWildRide() {
		// Declare local variables
		List<String> firstLine = new ArrayList<String>();
		int playDays = 0;
		int dueDate = 0;
		List<String> days = new ArrayList<String>();
		int boxes = 0;
		int counter = 0;
		int daysLate = 0;
		
		// If data has nothing in it
		if (data.size() == 0) {
			// Tell user to load data first
			System.out.println("Please load data first");
		}
		// Else, run Willow's Wild Ride
		else {
			firstLine = Arrays.asList(data.get(0).split(" "));
			
			playDays = Integer.parseInt(firstLine.get(0));
			dueDate = Integer.parseInt(firstLine.get(1));
			
			for (int i = 0; i < dueDate; i++) {
				days.add(data.get(i+1));
			}
			
			for(int currentDay = 0; currentDay < dueDate; currentDay++) {
				if (days.get(currentDay).charAt(0) == 'B') {
					boxes++;
				}
				if (boxes > 0) {
					counter++;
				}
				if (counter == playDays) {
					counter = 0;
					boxes--;
				}
			}
			
			if (boxes == 0 && counter == 0) {
				daysLate = 0;
			}
			else {
				daysLate = playDays - counter;
				boxes--;
				daysLate += playDays * boxes;
			}
			
			System.out.println(daysLate);
			
			data.subList(0, dueDate+1).clear();
			if (data.size() > 0) {
				WillowsWildRide();
			}
		}
	}
	
	private void MartianTime() {
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
			System.out.println("Please load data first");
		}
		// Else, run Willow's Wild Ride
		else {
			earth = Arrays.asList(data.get(0).split(" "));
			
			earthTime = Double.parseDouble(earth.get(2));
			earthTime /= 60;
			
			earthTime += Double.parseDouble(earth.get(1));
			earthTime /= 24;
			
			earthTime += Double.parseDouble(earth.get(0));
			
			earthTime -= 1;
			
			
			marsTime = earthTime * EARTHTOMARS;
			
			marsDays = (int)marsTime;
			marsTime -= marsDays;
			marsDays += 1;
			
			marsTime *= 24;
			marsHours = (int)marsTime;
			marsTime -= marsHours;
			
			marsTime *= 60;
			marsMinutes = (int)marsTime;
			marsTime -= marsMinutes;
			
			marsTime *= 60;
			marsSeconds = (int)marsTime;
			
			//System.out.println(marsTime);
			if (marsHours < 10) {
				System.out.println("Day: " + marsDays + ", 0" + marsHours + ":" + marsMinutes + "." + marsSeconds);
			}
			else if (marsMinutes < 10) {
				System.out.println("Day: " + marsDays + ", " + marsHours + ":0" + marsMinutes + "." + marsSeconds);
			}
			else {
				System.out.println("Day: " + marsDays + ", " + marsHours + ":" + marsMinutes + "." + marsSeconds);
			}
			
			data.remove(0);
			if (data.size() > 0) {
				MartianTime();
			}
		}
	}
}
