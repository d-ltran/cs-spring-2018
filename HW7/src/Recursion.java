//Daniel Tran dlt2hc
import java.awt.Color;

public class Recursion {
//	#1    Reverse String
	public static String reverseString(String s) {
		if (s.length()==1) {
			return s;
		}
		else
			return reverseString(s.substring(s.length()-1,s.length()))+reverseString(s.substring(0,s.length()-1));

	}
//	#2 Count Ways to climb stairs
	public static int countWays(int numStairs) {
		if(numStairs==1||numStairs==2||numStairs==3) {
			return numStairs;
		}
		else return countWays(numStairs-1)+countWays(numStairs-2);
	}
//	#3   Ackermann *** user will never input negative numbers because that does not make sense
	public static int Ackermann(int m, int n) {
		if (m==0) {
			return n+1;
		}
		else if(m>0&& n==0) {
			return Ackermann(m-1,1);
		}
		
			return Ackermann(m-1,Ackermann(m, n-1));
			
		
	}
//	4 HandShakes
	public static int handShakes(int n) {
		if(n==2) {
			return 1;
		}
		
		else
			return handShakes(n-1)+(n-1);
	}
//5 Square Root Guess
	public static double squareRootGuess( double x, double g) {
		if(Math.abs(Math.pow(g, 2)-x)<=.0001) {
			return g;
		}
		else
			return squareRootGuess(x, ((g+x/g)/2));
	}
	public static double squareRoot(double x) {
		return squareRootGuess(x, 3);
	}
/*	6 Snowflake
 * 
 * 
 * 
 */
	public static void snowflake(Turtle t, int depth, double length) {
		if(depth == 0){
			t.forward(length);
			return;
		}
		else {
			snowflake(t, depth-1, length / 3);
			t.left(60);
			snowflake(t, depth-1, length / 3);
			t.right(120);
			snowflake(t, depth-1, length / 3);
			t.left(60);
			snowflake(t, depth-1, length / 3);

		}
		
		
		
	}
	public static void turningflake(Turtle t, int depth, double length) {
		snowflake(t, depth, length);
		t.right(120);
		snowflake(t, depth, length);
		t.right(120);
		snowflake(t, depth, length);

		
	}
	public static void main(String args[]) {
//		Outputs expecting: dlrowolleh  and leinaD
		System.out.println("Input( reverseString ): (helloworld) , "+"Output= "+reverseString("helloworld"));
		System.out.println("Input( reverseString ): (Daniel) , "+"Output= "+reverseString("Daniel"));
//		Outputs expecting: 8 and 5
		System.out.println("Input( countWays ): 5 , "+"Output= "+countWays(5));
		System.out.println("Input( countWays ): 4 , "+"Output= "+countWays(4));
//		Outputs expecting:3 and 3
		System.out.println("Input( Ackerman ): (1, 1) , "+"Output= "+Ackermann(1, 1));
		System.out.println("Input( Ackerman ): (0, 2) , "+"Output= "+Ackermann(2, 0));
//		Outputs expecting: 15 and 6
		System.out.println("Input( handShake ): 6 , "+"Output= "+handShakes(6));
		System.out.println("Input( handShake ): 4 , "+"Output= "+handShakes(4));
//		Outputs expecting: 4 and 7
		System.out.println("Input( SquareRootGuess  ): 16 , "+"Output= " +squareRoot(16));
		System.out.println("Input( SquareRootGuess  ): 49 , "+"Output= " +squareRoot(49));
//		Calling Turtle where turningflake is my method that calls the recursive method snowflake
		World myWorld = new World(900,900,Color.WHITE);
		Turtle bob = new Turtle(myWorld);
		bob.setDelay(0);
		bob.putPenDown();
		turningflake(bob, 4, 300);
//		turningflake(bob, 3, 200);
		
	}
}
