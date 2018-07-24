package GameXepGach;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HowtToPlay extends JFrame {

	private JPanel contentPane;
	private JLabel howtoplay;


	/**
	 * Create the frame.
	 */
	public HowtToPlay() {
		setResizable(false);
		setTitle("How to play");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 550, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("How to play");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(186, 11, 127, 39);
		contentPane.add(lblNewLabel);
		
		howtoplay = new JLabel(new ImageIcon("howtoplay.png"));
		howtoplay.setBounds(15, 61, 500, 500);
		contentPane.add(howtoplay);
	}
}
