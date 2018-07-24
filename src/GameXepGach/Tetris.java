package GameXepGach;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Tetris extends JFrame {

    JLabel statusbar;
    Board board;
    Application myApp;
    StatusPane statuspane;
    public Tetris(Application app) {
    	myApp = app;
        setSize(500, 600);
        setTitle("This is Tetris!!");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initializeComponents();
        setVisible(true);
   }

   private void initializeComponents() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu;
		JMenuItem menuitem;
		
		this.setJMenuBar(menubar);
		menu = new JMenu("Round 1");

		statuspane = new StatusPane(myApp);
		statusbar = new JLabel("Go and try hard. Go, go, go !!!!!!!!");
		board = new Board(myApp, this);
		this.add(statuspane, BorderLayout.EAST);
		this.add(board);
		this.add(statusbar, BorderLayout.SOUTH);
	}

   public JLabel getStatusBar() {
       return statusbar;
   }

}