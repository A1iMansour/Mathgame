package M;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * 
 *  Winner class
 *  
 * <p>
 * <b> Note: </b>
 * javadoc is used for documentation
 *
 */

public class Winner extends JPanel{


	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(0,0,1000,700);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.YELLOW);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 70));
		g2d.drawString("BEAST MODE", 300, 350);
		g2d.drawString("WINNER!", 300, 430);
		g2d.setColor(Color.red);
		g2d.fillRect(800,0,300,700);
	}
	
	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Math ");
		frame.setSize(1000, 700);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		Winner game = new Winner();
		frame.add(game);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
