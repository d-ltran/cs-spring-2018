//Daniel Tran dlt2hc
	import java.lang.*;
	import java.util.Arrays;
	public class HW1 {
		public static void main(String arg[]) {
//			I tested pi: inputing 5 and 6 to see if they return to that many value places.

			System.out.println(pi(5));
			System.out.println(pi(6));
//			  I tested easter from the years 2001 and 2002.

			System.out.println(easter(2001));
			System.out.println(easter(2002));
//			  I tested the escape velocity of 3600.0 mph and 3000.0 mph

			System.out.println(escape(3600.0));
			System.out.println(escape(3000.0));
//			  I tested the random method with mostly prime numbers:2, 17, 111, 31, 111, 22, 97, 30

			System.out.println(Arrays.toString(random(2, 17, 111, 31)));
			System.out.println(Arrays.toString(random(111, 22, 97, 30)));

			 
		}
		public static double pi(int n) {
			int i=0;
			double pi=0;
			double adder;
			while(i <=100000000) {
				if (i%2==0) {
					adder=(1.0/(2*i+1));
				}
				else {
					adder=-(1.0/(2*i+1));		
				}
				pi+=adder;	
				i++;
			}
			pi=4*pi;
			pi=pi*Math.pow(10,n);
			pi=Math.floor(pi);
			pi=pi/Math.pow(10,n);
			return pi;	
		}
		public static String easter(int y) {
			int a=y%19;
			int b=y/100;
			int c=y%100;
			int d=b/4;
			int e =b%4;
			int g=((8*b)+13)/25;
			int h= ((19 * a) + b - d - g + 15)%30;
			int j= c/4;
			int k = c%4;
			int m = (a + (11 * h))/319;
			int r= ((2 * e) + (2 * j) - k - h + m + 32)%7;
			int n= (h-m+r+90)/25;
			int p= (h - m + r + n + 19)%32;
			if (n ==3)
				return "March "+p;
			else
				return "April "+p;
			
			
		}
		
		public static String escape(double v) {

			double g= 6.67E-11;
			double m= 1.3E22;
			double r= 1.153E6;
			double limvelocity=Math.sqrt((2*g*m)/r);
			v=(1609.34*v)/3600;
			if 	(v>limvelocity) {
				double mass=(Math.pow(v, 2.0)*r)/(2*g);
				return "You will not return to the surface. To do so, the mass of the comet has to be larger than "+ mass+ " kg.";
			}
			else
				return "You will return";
			
			
			
		}
		public static int[] random(int r, int a, int b, int m) {

			int[] values= new int[25];
			int rando= ((a*r)+b)%m;
			for (int i =0; i<25;i++) {
				values[i]=rando;
//				System.out.println(rando);
				rando=((a*rando)+b)%m;
				
				
			
			}
			return values;
		}
	}
	/* The outputs accordingly:
3.14159
3.141592
April 15
March 31
You will not return to the surface. To do so, the mass of the comet has to be larger than 2.2385618040830583E22 kg.
You will not return to the surface. To do so, the mass of the comet has to be larger than 1.5545568083910125E22 kg.
[21, 3, 7, 13, 22, 20, 17, 28, 29, 15, 25, 9, 16, 11, 19, 0, 18, 14, 8, 30, 1, 4, 24, 23, 6]
[19, 5, 27, 1, 29, 15, 7, 11, 9, 25, 17, 21, 19, 5, 27, 1, 29, 15, 7, 11, 9, 25, 17, 21, 19]
*/
