package GameXepGach;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StatusPane extends JPanel implements ActionListener{
	Application myApp;
	OptionPane option;
	private static BufferedReader br;
	private List<String[]> leaderboard = new ArrayList<String[]>();
	JLabel score;
	public StatusPane(Application app)
	{
		myApp = app;
		setPreferredSize(new Dimension(120, 460));
		setBorder(null);
		initializeComponents();
	}
	private void initializeComponents() {
		
		option = new OptionPane(myApp);
		JButton butStart = new JButton("New Game");
		butStart.setBounds(2, 11, 116, 39);
		butStart.setPreferredSize(new Dimension(100, 40));
		butStart.addActionListener(this);
		setLayout(null);
		this.add(butStart);
		JButton butOption = new JButton("Setting");
		butOption.setBounds(2, 61, 116, 39);
		butOption.setPreferredSize(new Dimension(100, 40));
		butOption.addActionListener(this);
		this.add(butOption);
		score = new JLabel("Score: 0");
		score.setFont(new Font("Tahoma", Font.PLAIN, 15));
		score.setBounds(2, 111, 116, 39);
		this.add(score);
		
		JButton btnNewButton = new JButton("LeaderBoard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReadLeaderBoard();
				new LeaderBoard(leaderboard).setVisible(true);
			}
		});
		btnNewButton.setBounds(2, 343, 116, 46);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("'m' is for music");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myApp.tetris.board.toogleSound();
			}
		});
		btnNewButton_1.setBounds(2, 400, 116, 46);
		add(btnNewButton_1);
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
	
	public void scored(int score)
	{
		this.score.setText("Score: "  +   Integer.toString(score));
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "New Game"){
			myApp.tetris.board.start();
		}
		else
		{
			myApp.tetris.board.stop();
			option.setVisible(true);
		}
	}
}
