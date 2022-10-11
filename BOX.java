package M;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * BOX class
 * notice that 50% of the times in division  a number n is divided by itself, thats because numbers that are divisible by n from 50-99 is n itself
 * <p>
 * <b> Note: </b>
 * javadoc is used for documentation
 * 
 * 
 * @version 1.0
 *
 */
public class BOX extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x;
	int y=0;
	int speed;
	static int answer;
	static int  playerslevel;
	static int score=0;
	static String e;
	static String input="";
	
	/**
	 * 
	 * 
	 * @param speed
	 * @param l
	 * @param s
	 */

	public BOX(int speed,int l,int s) {
		this.speed=speed;
		score=s;
		Random rand= new Random();
		EquationGenerator c= new EquationGenerator(playerslevel);
		e=c.getexp();
		answer=c.getans();
		x=rand.nextInt(800-e.length()*6*e.length());/*Generates random positions for the equation, why -e.length()*2*e.length()?
		because it worked :)
		*/
	}
	
	/**
	 * moves the box by the desired speed
	 * 
	 */

	private void moveBox() {
		y+=speed;
		}
	
	/**
	 * 
	 * setting the colors and fonts
	 * 
	 */

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.fillRect(0,0,800,700);
		g2d.setColor(Color.white);//for the rectangle that will contain input button
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 70));
		g2d.drawString(e, x, y);
		g2d.setColor(Color.GRAY);
		g2d.fillRect(800,0,300,700);
		g2d.setColor(Color.blue);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g2d.drawString("level: "+Integer.toString(playerslevel), 820, 100);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g2d.drawString("Score: "+Integer.toString(score), 820, 200);//draws string
		g2d.setColor(Color.white);
		g2d.drawString("Input", 820, 570);
		g2d.fillRect(820,580,100,50);
		g2d.setColor(Color.blue);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g2d.drawString(input, 830, 620);
		
		
	}
	
	/**
	 * 
	 * determining levels
	 * 
	 * @param l
	 * @param speed
	 * @param scor
	 * @throws Exception 
	 */
	

	public static void m(int l,int speed,int scor) throws Exception {
		playerslevel=l;
		int score =scor;
		JFrame frame = new JFrame("Math ");
		frame.setSize(1000, 700);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);//window will appear in the middle
		JTextField txtNum1 = new JTextField();
		txtNum1.setBounds(820,600,20,20);
		txtNum1.setForeground(Color.white);
		frame.add(txtNum1);
		
		while(true) {
			input="";

			if(score==60) {//finished level 3;
				Winner w= new Winner();
				frame.add(w);
				frame.setVisible(true);
				break;
			}
			if (score ==30||score==60) {
				playerslevel++;
				///////////////////////////////////////////////////////
				music.playlvl();
			}
			BOX game = new BOX(speed,playerslevel,score);
			frame.add(game);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
			while (true) {
				input = txtNum1.getText();
				int y=1;
				String input2=input;
				boolean forwhile=true;
			if(input.length()!=0&&input.charAt(0)=='-') {
				forwhile=isInteger(input.substring(1));
			}
			else if(input.length()!=0&&!isInteger(input)) {
				forwhile=false;
			}
			if(forwhile) {
				if(input.length()!=0&&input.charAt(0)=='-') {
						y=-1;
						input2=input.substring(1);		
					}
				if((input.compareToIgnoreCase("")!=0)&&(input.length()>1||input.compareToIgnoreCase("-")!=0)&&Integer.parseInt(input2)*y==answer) {
						score++;
						game.repaint();
						Thread.sleep(50);
						txtNum1.setText("");
						///////////////////////////
						music.playwin();
						break;
				}
			}
				game.moveBox() ;
				game.repaint();//calls paint
				Thread.sleep(10);//to stop the movement for some time
				if(game.y>=700) {//string reached the end
					music.playloss();
					txtNum1.setText("");
					break;
				}
			}
		}
	}
	
	/**
	 * Making sure the input is an integer
	 * 
	 * @throws Exception
	 * @param input
	 * @return boolean true or false
	 */
	public static boolean isInteger( String input ) throws Exception {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
	
}
