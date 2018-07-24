package GameXepGach;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
class Scorepanel extends JPanel{
	private BufferedImage img;
	public Scorepanel() {
		try {
			img = ImageIO.read(new File("bg.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g){ 
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        
    }
}

class boardOder implements Comparator<String[]>{
	@Override
    public int compare(String[] w1, String[] w2){
		int d1 = Integer.parseInt(w1[1]);
		int d2 = Integer.parseInt(w2[1]);
		if(d1 < d2) {
			return 1;
		}
		else if(d1 > d2) {
			return -1;
		}
        return 0;
    }
}


public class LeaderBoard extends JFrame {
	private JPanel contentPane;
	private List<String[]> list = new ArrayList<String[]>();
	JTextArea textArea;
	
	public LeaderBoard(List<String[]> leaderboard) {
		setResizable(false);
		setTitle("LeaderBoard");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new Scorepanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textArea.setBounds(107, 56, 219, 348);
		textArea.setOpaque(false);
		//textArea.setBackground(new Color(0, 0, 0));
		textArea.setForeground(Color.WHITE);
		JLabel lblLeaderboard = new JLabel("LeaderBoard");
		lblLeaderboard.setForeground(Color.WHITE);
		lblLeaderboard.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLeaderboard.setBounds(143, 11, 142, 34);
		contentPane.add(lblLeaderboard);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setLocation(0, 56);
		scrollPane.setSize(444, 415);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		this.list = leaderboard;
		Collections.sort(list, new boardOder());
		showLeaderBoard();
		contentPane.add(scrollPane);
	}
		public void showLeaderBoard() {
		for(int i = 0;i<list.size();i++) {
			String s = list.get(i)[0] + " - " + list.get(i)[1];
			textArea.append(s + "\n\n");
		}
	}
		
}