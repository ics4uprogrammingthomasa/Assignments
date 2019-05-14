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
	boolean finished = false;

	// Declare JFrame objects
	private JFrame frame;	
	java.awt.List listGeneratedData = new java.awt.List();
	java.awt.List listSortedData = new java.awt.List();

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
		frame.setBounds(100, 100, 473, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		listGeneratedData.setFont(null);
		
		listGeneratedData.setBounds(114, 45, 110, 205);
		frame.getContentPane().add(listGeneratedData);
		
		JLabel lblGeneratedData = new JLabel("Generated Data");
		lblGeneratedData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGeneratedData.setBounds(125, 25, 91, 14);
		frame.getContentPane().add(lblGeneratedData);
		
		JButton btnGenerate = new JButton("Generate ");
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Call Generate Function
				Generate();
			}
		});
		btnGenerate.setBounds(10, 127, 89, 23);
		frame.getContentPane().add(btnGenerate);
		
		JLabel lblSortedData = new JLabel("Sorted Data");
		lblSortedData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSortedData.setBounds(364, 25, 65, 14);
		frame.getContentPane().add(lblSortedData);
		
		JButton btnSort = new JButton("Sort");
		btnSort.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Call Sort Function
				Sort();
			}
		});
		btnSort.setBounds(236, 127, 89, 23);
		frame.getContentPane().add(btnSort);
		
		listSortedData.setFont(null);
		listSortedData.setBounds(331, 45, 110, 205);
		frame.getContentPane().add(listSortedData);	
	}
	
	public void Generate() {
		
		// Declare random number generator
		Random rand = new Random();
		
		for (int i = 0; i < 250; i++) {
			data.add(rand.nextInt(250));
		}
		
		for (int i = 0; i < 250; i++) {
			listGeneratedData.add(Integer.toString(data.get(i)));
		}
				
		System.out.println(data);
	}
	
	public void Sort() {
		int count = 0;
		int moveValue;
		
		while(finished == false) {
			// Declare local variables
			count = 0;
			
			for (int currentIndex = 0; currentIndex < data.size()-2; currentIndex++) {
				moveValue = 0;
				
				if (data.get(currentIndex) > data.get(currentIndex+1)) {
					moveValue = data.get(currentIndex);
					
					data.remove(currentIndex);
					
					data.add(moveValue, currentIndex+1);
					
					count++;
				}
			}
					
			if (count == 0) {
				finished = true;
			}
		}
		
		for (int i = 0; i < 250; i++) {
			listSortedData.add(Integer.toString(data.get(i)));
		}
	}
}
