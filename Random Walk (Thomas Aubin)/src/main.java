/*
 * Created by: Thomas Aubin
 * Created on: May 13, 2019	
 * Created for: ICS4U Programming
 * Assignment #3 - Random Walk
 * This program randomly generates a start and end point and randomly finds a path
*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class main {
	
	// Declare Global Variables
	int formWidth = 200;
	int formHeight = 200;
	int targetWidth = 20;
	int targetHeight = 20;
	
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
		
		JLabel lblFormWidth = new JLabel("Form Width    - - -");
		lblFormWidth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFormWidth.setBounds(29, 56, 88, 14);
		frame.getContentPane().add(lblFormWidth);
		
		JLabel lblFormHeight = new JLabel("Form Height   - - -");
		lblFormHeight.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFormHeight.setBounds(30, 91, 101, 14);
		frame.getContentPane().add(lblFormHeight);
		
		JLabel lblTargetWidth = new JLabel("Target Width   - - - ");
		lblTargetWidth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTargetWidth.setBounds(30, 153, 101, 14);
		frame.getContentPane().add(lblTargetWidth);
		
		JLabel lblTargetHeight = new JLabel("Target Height   - - -");
		lblTargetHeight.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTargetHeight.setBounds(30, 188, 101, 14);
		frame.getContentPane().add(lblTargetHeight);
		
		JLabel lblRandomWalkBy = new JLabel("Random Walk By Thomas Aubin");
		lblRandomWalkBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRandomWalkBy.setBounds(117, 0, 204, 34);
		frame.getContentPane().add(lblRandomWalkBy);
		
		JButton btnGenerate = new JButton("Generate!");
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGenerate.setBounds(265, 113, 89, 23);
		frame.getContentPane().add(btnGenerate);
		
		JSpinner nudFormWidth = new JSpinner();
		nudFormWidth.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				formWidth = (Integer)nudFormWidth.getValue();
				System.out.println(formWidth);
			}
		});
		nudFormWidth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nudFormWidth.setBackground(new Color(240, 240, 240));
		nudFormWidth.setModel(new SpinnerNumberModel(200, 200, 800, 100));
		nudFormWidth.setBounds(141, 53, 53, 20);
		frame.getContentPane().add(nudFormWidth);
		
		JSpinner nudFormHeight = new JSpinner();
		nudFormHeight.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				formHeight = (Integer)nudFormHeight.getValue();
			}
		});
		nudFormHeight.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nudFormHeight.setModel(new SpinnerNumberModel(200, 200, 800, 100));
		nudFormHeight.setBounds(141, 88, 53, 20);
		frame.getContentPane().add(nudFormHeight);
		
		JSpinner nudTargetWidth = new JSpinner();
		nudTargetWidth.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				targetWidth = (Integer)nudTargetWidth.getValue();
			}
		});
		nudTargetWidth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nudTargetWidth.setModel(new SpinnerNumberModel(20, 20, 100, 10));
		nudTargetWidth.setBounds(141, 150, 53, 20);
		frame.getContentPane().add(nudTargetWidth);
		
		JSpinner nudTargetHeight = new JSpinner();
		nudTargetHeight.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				targetHeight = (Integer)nudTargetHeight.getValue();
			}
		});
		nudTargetHeight.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nudTargetHeight.setModel(new SpinnerNumberModel(20, 20, 100, 10));
		nudTargetHeight.setBounds(141, 185, 53, 20);
		frame.getContentPane().add(nudTargetHeight);
	}
}
