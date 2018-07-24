package GameXepGach;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameOver extends JFrame {

	private JPanel contentPane;
	private JTextField plname;
	private static BufferedReader br;
	private List<String[]> leaderboard = new ArrayList<String[]>();
	private int score;
	/**
	 * Create the frame.
	 */
	public GameOver(int score) {
		setVisible(true);
		setTitle("Game Over");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOkay = new JButton("Carve my name to the leaderboard !");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarveName();
			}
		});
		btnOkay.setBounds(104, 227, 214, 23);
		contentPane.add(btnOkay);
		
		JLabel lblText = new JLabel("Text");
		lblText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblText.setBounds(10, 30, 235, 23);
		contentPane.add(lblText);
		
		this.score = score;
		JLabel lblScore = new JLabel(String.valueOf(score));
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblScore.setBounds(255, 30, 169, 23);
		contentPane.add(lblScore);
		
		JLabel lblNewLabel = new JLabel("And your name is :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 81, 414, 23);
		contentPane.add(lblNewLabel);
		
		plname = new JTextField();
		plname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		plname.setBounds(10, 115, 414, 32);
		contentPane.add(plname);
		plname.setColumns(10);
		ReadLeaderBoard();
	}
	
	public BufferedReader readFileData(File file) {
		try {
			File in = file;
			br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(in), "UTF8"));
		}catch (Exception e) {
			System.out.println("Cannot read file!");
		}
		return br;
	}
	
	public void CarveName() {
		String name = plname.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "Please hold on! You haven't tell me your name!");
		}
		else {
			String[] plscore = {name,String.valueOf(score)};
			leaderboard.add(plscore);
			try {
				PrintWriter writer =  new PrintWriter(new File("leaderboard.txt"), "UTF-8"); 
				for(int i = 0;i<leaderboard.size();i++) {
					String line = leaderboard.get(i)[0] + " - " + leaderboard.get(i)[1];
					writer.println(line);
				}
				writer.close();
			}
			catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Sorry! I can't find the leaderboard. Maybe your name will be carved on it next time :( ");
			}
			this.dispose();
		}
		new LeaderBoard(leaderboard).setVisible(true);
	}
	
	public void ReadLeaderBoard() {
		BufferedReader buff = readFileData(new File("leaderboard.txt"));
		try {
			String line;
			while((line = buff.readLine())!=null) {
				String parts[] = line.split(" - ");
				leaderboard.add(parts);
			}
			buff.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
