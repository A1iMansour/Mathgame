package M;


import java.util.Random;
/**
 * 
 * 
 * EquationGenerator class
 * 
 * <p>this part generates random numbers and equations that are shown on the window</p>
 * <b> Note: </b>
 * javadoc is used for documentation
 * this part generates random numbers and equations that are shown on the window
 *
 */

public class EquationGenerator {
	private static double ans;
	private static String exp;
	int lvl;
	
	/**
	 * parametrized constructor
	 * @param lvl
	 */
	public EquationGenerator(int lvl) {
		this.lvl=lvl;
	}
	/**
	 * 
	 * levels :1,2,3.
	 * @return exp 
	 */
	public String getexp() {
		int[] timesdivide= {1,-1};//1 for * 0 for /
		String[] pm= {"+","-"};
		Random r=new Random();
		int l1=r.nextInt(11);//Generates random number b/w 0 and 10
		int l2=r.nextInt(11);//Generates random number b/w 0 and 10
		int l3=r.nextInt(90)+10;//Generates random number b/w 10 and 99
		int l4=r.nextInt(100);//Generates random number b/w 0 and 99
		if(lvl==1) {
			int r1=r.nextInt(2);
			double x=+Math.pow(-1,r1)*l2;//if r1=0 then + else -
			exp=""+l1+" "+pm[r1]+' '+l2;
			ans=l1 +x;
			return exp;
		}
		else if(lvl==2) {
			int r1=r.nextInt(2);
			double x=+Math.pow(-1,r1)*l4;//if r1=0 then + else -
			exp=""+l3+" "+pm[r1]+' '+l4;
			ans=l3 +x;
			return exp;
		}
		else {
			int l5=r.nextInt(100);
			int l6=r.nextInt(100);
			int r1=r.nextInt(2);
			
			int r2=r.nextInt(2);
			if (r2==1) {
				int i = 0;
				while(i<4&&l4>49) {//decrease n/n to about 3%
					l4=r.nextInt(100);
					i++;
				}
				l6=nominator(l4);
			}
			double x=+Math.pow(-1,r1)*l6;
			double x2=x*Math.pow(l4,timesdivide[r2]);//if r2=-1 then divide by l4
			System.out.println("l6: "+l6+" l4 "+l4+" l5 "+l5);
			ans=l5+x2;
			System.out.println(ans);
			char o='/';
			if(r2==0)
				o='x';
			exp=""+l5+" "+pm[r1]+' '+l6+o+l4;
			return exp;
			
		}
		
	}
	/**
	 * 
	 * generates nominator that is divisible by l4
	 * @param x
	 * @return x
	 */
	public int nominator(int x) {
		Random r=new Random();
		int []choice= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49};
		if(x==1) {
			return  r.nextInt(x+1);
		}
		else if(x>49) {
			return x;
		}
		else if(x<34&&x>24) {
			int c=r.nextInt(4);//0,1,2,3,else number will be above 100 but we want 2 digits
			return x*choice[c];
		}
		else if(x<25&&x>19) {
			int c=r.nextInt(5);
			return x*choice[c];
		}
		else if(x<20&&x>16) {
			int c=r.nextInt(6);
			return x*choice[c];
		}
		else if(x<13&&x>7) {
			int y=13-8+x;//from 8 to 12 m=nominator is x*(12+8-x),i.e the multiple increases by 1 each time
			int c=r.nextInt(y);
			return x*choice[c];
		}
		else if(x<50&&x>33) {
			int c=r.nextInt(3);
			return x*choice[c];
		}
		else if(x>1&&x<8) {
			int f=50-(x/(3+x/4))*(x+1)*5+(x/3)*5-(x/4)*5-3*(x/6)+3*(x/7);
			int c=r.nextInt(f);
			return x*choice[c];
		}
		else if(x==15||x==16) {
			int c=r.nextInt(7);
			return x*choice[c];
		}
		else  {//if(x==14||x==13)
			int c=r.nextInt(8);
			return x*choice[c];
		}
		
	}
	
	/**
	 * 
	 * 
	 * @return ans
	 */
	public int getans() {
		return (int) ans;
	}
}
