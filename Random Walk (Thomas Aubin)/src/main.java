import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class main {

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
		
		JLabel lblFormWidth = new JLabel("Form Width:");
		lblFormWidth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFormWidth.setBounds(56, 74, 88, 14);
		frame.getContentPane().add(lblFormWidth);
		
		JLabel lblFormHeight = new JLabel("Form Height:");
		lblFormHeight.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFormHeight.setBounds(56, 92, 101, 14);
		frame.getContentPane().add(lblFormHeight);
		
		JLabel lblTargetWidth = new JLabel("Target Width");
		lblTargetWidth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTargetWidth.setBounds(56, 148, 88, 14);
		frame.getContentPane().add(lblTargetWidth);
		
		JLabel lblTargetHeight = new JLabel("Target Height:");
		lblTargetHeight.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTargetHeight.setBounds(56, 166, 76, 14);
		frame.getContentPane().add(lblTargetHeight);
		
		JLabel lblRandomWalkBy = new JLabel("Random Walk By Thomas Aubin");
		lblRandomWalkBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRandomWalkBy.setBounds(117, 11, 204, 34);
		frame.getContentPane().add(lblRandomWalkBy);
		
		JButton btnGenerate = new JButton("Generate!");
		btnGenerate.setBounds(161, 227, 89, 23);
		frame.getContentPane().add(btnGenerate);
	}
}
