import java.util.Arrays;
import java.util.Random;

/*
 * 
 * @author Daniel Tran
 * dlt2hc
 */
public class BubbleSort implements Runnable{
	private int[] bubbleArray;
	public BubbleSort() {
		bubbleArray= ArrayUtil.randomIntArray(30, 50);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public static void sort(int[] array) {
		int restArray= array.length;
		while (restArray>1) {
			int j=0;
			while(j<restArray-1) {
				System.out.println(Arrays.toString(array));
				if ( array[j]> array[j+1]) {
					ArrayUtil.swap(array, j, j+1);
				}
				j++;
			}
			restArray--;
		}
	}
	
}
