import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// Add graphic drawing library
import java.awt.Graphics;
// Add random number generator
import java.util.Random;
// Add draw color
import java.awt.Color;


public class draw extends JFrame {

	// Declare global variables
	int screenSizeX = 450;
	int screenSizeY = 300;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					draw frame = new draw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public draw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, screenSizeX, screenSizeY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public void paint(Graphics g) {
		
		int minX = 8;
		int minY = 31;
		int maxX = screenSizeX- 59;
		int maxY = screenSizeY - 59;
		
		//g.fillOval(8, 31, 100, 100);
		g.fillOval(maxX, maxY, 50, 50);
		
		for (int i = 0; i < 255; i++) {
			g.fillOval(100+i, 100+i, 2, 2);
			
			if (i < 50) {
				g.setColor(new Color(100+i, 0, 0));
			}
			else {
				g.setColor(new Color(255, 255, 255));
			}
			
		}
	}

}
