package yame.Ideal.Ideal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainIdeal {


	
	private WomanIdeal page2;
	private ManIdeal page3;
	private JFrame frame;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainIdeal window = new MainIdeal();
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
	public MainIdeal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("»ﬁ∏’µ’±Ÿ«ÏµÂ∂Û¿Œ", Font.PLAIN, 14));
		frame.setTitle("\uC774 \uC0C1 \uD615 \uC6D4 \uB4DC \uCEF5");
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 605, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		page2 = new WomanIdeal();
		page3 = new ManIdeal();
		
		page2.setLocation(0, 0);
		page2.setSize(3000, 3000);
		page3.setLocation(0, 0);
		page3.setSize(3000, 3000);

		frame.getContentPane().add(page2);		
		frame.getContentPane().add(page3);
		panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 597, 464);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JButton Left = new JButton("M");
		Left.setFont(new Font("±º∏≤", Font.PLAIN, 45));
		Left.setBounds(12, 188, 278, 210);
		Left.setBackground(Color.CYAN);
		Left.setIcon(new ImageIcon("yame\\data\\ideal_m.jpg"));
		panel.add(Left);
		
		JButton Right = new JButton("W");
		Right.setFont(new Font("±º∏≤", Font.PLAIN, 45));
		Right.setBounds(311, 188, 278, 210);
		Right.setBackground(Color.MAGENTA);
		Right.setIcon(new ImageIcon("yame\\data\\ideal_g.jpg"));
		panel.add(Right);
		
		JLabel lblNewLabel = new JLabel("\uC774\uC0C1\uD615\uC6D4\uB4DC\uCEF5 \uD574\uBCFC\uAE4C\uC694? \uBFCC\uC789\uBFCC\uC789~\r\n");
		lblNewLabel.setBounds(27, 0, 562, 165);
		lblNewLabel.setFont(new Font("æÁ¿Áº“ΩΩ√ºS", Font.PLAIN, 17));
		lblNewLabel.setIcon(new ImageIcon("yame\\data\\ideal_iu.jpg"));
		lblNewLabel.setBackground(Color.BLACK);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\uC67C\uCABD\uBC84\uD2BC \uD074\uB9AD \uB0A8\uC790\uC0AC\uC9C4, \uC624\uB978\uCABD\uBC84\uD2BC \uD074\uB9AD \uC5EC\uC790\uC0AC\uC9C4. \uBC84\uD2BC\uC744 \uB204\uB974\uC138\uC694. \uAFB9~");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("HY∞ﬂ∞ÌµÒ", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 408, 577, 46);
		panel.add(lblNewLabel_1);
		
		Right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				page2.setVisible(true);
			}
		});
		Left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				page3.setVisible(true);
			
			}
		});
	}

}
