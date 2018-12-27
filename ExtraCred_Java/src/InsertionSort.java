import java.util.Arrays;
import java.util.Random;

/*
 * 
 * @author Daniel Tran
 * dlt2hc
 */
public class InsertionSort implements Runnable{
	private int[] insertionArray;
	
	public InsertionSort() {
		insertionArray= ArrayUtil.randomIntArray(30, 50); 
	}
	
	public static void sort(int[] a) {
		for ( int i=1; i< a.length; i++) {
			int next = a[i];
			int j= i;
			while(j>0 && a[j-1]>next) {
				System.out.println(Arrays.toString(a));
				ArrayUtil.swap(a, j-1, j);
				j--;
			}
			
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
