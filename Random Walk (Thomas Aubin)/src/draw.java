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
// Add delay
import java.util.concurrent.TimeUnit;


public class draw extends JFrame {

	// Declare global variables
	int screenSizeX = 450;
	int screenSizeY = 300;
	
	// Declare number generator
	Random randX = new Random();
	Random randY = new Random();
	
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
		
		// Declare local variables
		int minX = 8;
		int minY = 31;
		int maxX = screenSizeX - 59;
		int maxY = screenSizeY - 59;
		int randomX = 0;
		int randomY = 0;
		int currentX = 50;
	    int currentY = 100;
		
		while (true) {
			randomX = randX.nextInt(3);
			randomY = randY.nextInt(3);
			
			if (randomX == 1) {
				currentX += 1;
			}
			if (randomX == 2) {
				currentX -= 1;
			}
			
			if (randomY == 1) {
				currentY += 1;
			}
			if (randomY == 2) {
				currentY -= 1;
			}
			
			if (currentX > maxX) {
				currentX = maxX;
			}
			if (currentX < minX) {
				currentX = minX;
			}
			
			if (currentY > maxY) {
				currentY = maxY;
			}
			if (currentY < minY) {
				currentY = minY;
			}
			
			g.fillOval(currentX, currentY, 2, 2);
			/*
			try
			{
			    Thread.sleep(1);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
			*/
		}
		
	    /*
		
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
		*/
	}

}
