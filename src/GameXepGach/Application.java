package GameXepGach;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Application {
	Tetris tetris;
	public Application()
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException ex) {
			Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
			} catch (InstantiationException ex) {
			Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IllegalAccessException ex) {
			Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
			} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
			}
		tetris = new Tetris(this);
        tetris.setLocationRelativeTo(null);
	}
	
	 public static void main(String[] args) {
		 new HowtToPlay().setVisible(true);
		 new Application();
	 } 

}
