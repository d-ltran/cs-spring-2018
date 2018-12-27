import java.util.Random;
public class ArrayUtil {
	private static Random generator= new Random();
	/**
	 * 
	 * @param length is the size of your desired random array
	 * @param x is the bounds from 1-x
	 * @return
	 */
	
	public static int[] randomIntArray(int length, int x) {
		int[]a= new int [length];
		for (int i=0; i<a.length; i++) {
			a[i]= generator.nextInt(x)+1;
		}
		return a;
	}
	
/* for swapping the entries of the array
 * 
 */
	/**
	 * 
	 * @param a the taken array
	 * @param i swapping index i with index j
	 * @param j swapping index j with index i in arra a
	 */
	public static void swap(int[] a , int i, int j) 
	{
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
}
