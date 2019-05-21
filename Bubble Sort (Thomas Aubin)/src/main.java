/*
 * Created by: Thomas Aubin
 * Created on: May 13, 2019
 * Created for: ICS4U Programming
 * Assignment #3 - Bubble Sort
 * This program generates numbers and sorts them
*/

import java.awt.EventQueue;
import javax.swing.JFrame;

//Add list libray
import java.util.ArrayList;
import java.util.List;
//Add number generator
import java.util.Random;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main {
	
	// Declare global variables
	List<Integer> data = new ArrayList<Integer>();

	// Declare JFrame objects
	private JFrame frmBubbleSort;	
	java.awt.List listGeneratedData = new java.awt.List();
	java.awt.List listSortedData = new java.awt.List();
	JButton btnSort = new JButton("Sort");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frmBubbleSort.setVisible(true);
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
		frmBubbleSort = new JFrame();
		frmBubbleSort.setTitle("Bubble Sort - By Thomas Aubin");
		frmBubbleSort.setBounds(100, 100, 473, 300);
		frmBubbleSort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBubbleSort.getContentPane().setLayout(null);
		listGeneratedData.setFont(null);
		
		listGeneratedData.setBounds(114, 45, 110, 205);
		frmBubbleSort.getContentPane().add(listGeneratedData);
		
		JLabel lblGeneratedData = new JLabel("Generated Data");
		lblGeneratedData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGeneratedData.setBounds(125, 25, 91, 14);
		frmBubbleSort.getContentPane().add(lblGeneratedData);
		
		JButton btnGenerate = new JButton("Generate ");
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Call Generate Function
				Generate();
			}
		});
		btnGenerate.setBounds(10, 127, 89, 23);
		frmBubbleSort.getContentPane().add(btnGenerate);
		
		JLabel lblSortedData = new JLabel("Sorted Data");
		lblSortedData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSortedData.setBounds(364, 25, 65, 14);
		frmBubbleSort.getContentPane().add(lblSortedData);
		btnSort.setEnabled(false);
		
		btnSort.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Call Sort Function
				Sort();
			}
		});
		btnSort.setBounds(236, 127, 89, 23);
		frmBubbleSort.getContentPane().add(btnSort);
		
		listSortedData.setFont(null);
		listSortedData.setBounds(331, 45, 110, 205);
		frmBubbleSort.getContentPane().add(listSortedData);	
	}
	
	// Generate random numbers function
	public void Generate() {
		// Clear data and generated list
		data.clear();
		listGeneratedData.removeAll();;
		
		// Declare random number generator
		Random rand = new Random();
		
		// Repeat for loop 250 times
		for (int i = 0; i < 250; i++) {
			// Add 250 random number to list
			data.add(rand.nextInt(250));
		}
		
		// Add random numbers to list on GUI
		for (int i = 0; i < 250; i++) {
			listGeneratedData.add(Integer.toString(data.get(i)));
		}
		
		// Enable sorting function after generating data
		btnSort.setEnabled(true);
	}
	
	// Sort random numbers function
	public void Sort() {
		// Declare local variables
		boolean finished = false;
		
		// Clear sort list
		listSortedData.removeAll();
		
		// Declare local variables
		int count = 0;
		int moveValue;
		
		// Repeat until set false in loop
		while(finished == false) {
			// Set count to zero
			count = 0;
			
			// Repeat for length of data
			for (int currentIndex = 0; currentIndex < data.size()-1; currentIndex++) {
				// Temporarily variable to store number being sorted
				moveValue = 0;
				
				// If current index is greater then next index
				if (data.get(currentIndex) > data.get(currentIndex+1)) {
					// Save current index value
					moveValue = data.get(currentIndex);
					
					// Remove current index
					data.remove(currentIndex);
					
					// Place stored current index and place it one index higher
					data.add(currentIndex+1, moveValue);
					
					// Increase count
					count++;
				}
			}
			
			// If count is zero (No longer sorting any numbers)
			if (count == 0) {
				// Set finished to true to end loop
				finished = true;
			}
		}
		
		// Repeat for 250 times
		for (int i = 0; i < 250; i++) {
			// Add data to sorted data list on GUI
			listSortedData.add(Integer.toString(data.get(i)));
		}
	}
}
