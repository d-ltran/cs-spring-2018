/*
 * 
 * @author Daniel Tran
 * dlt2hc
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

public class SelectionSort implements Runnable{
	private JComponent comp;
	// This array is being sorted 
	private int[] a;   // These instance variables are needed for drawing
	private int current = -1;  
	private int previous = -1;
	private Lock sortLock;
	private static final int DELAY= 5;

	public SelectionSort(int[] anArray, JComponent component) 
	{      
		a = anArray;
		sortLock = new ReentrantLock();  
		comp = component;  
	} 


	public void sort() throws InterruptedException{
		for (int i=0; i<a.length-1;i++) {
			int minPosition= minimumPos(i);
			sortLock.lock();
			try {
				ArrayUtil.swap(a, minPosition, i);
				previous=i;
				//			System.out.println(Arrays.toString(a));
			}
			finally {
				sortLock.unlock();
			}
			pause(2);
		}
	}
	public int minimumPos(int from) throws InterruptedException{
		int minimumpos=from;
		for (int i= from+1; i<a.length;	i++) {
			sortLock.lock();
			try {
				if (a[i] < a[minimumpos]) {
					minimumpos=i;
				}
			}
			finally {
				sortLock.unlock();
			}
			pause(2);

		}
		return minimumpos;
	}
	public void draw(Graphics g) {
		sortLock.lock();
		try {
			int dist= comp.getWidth()/ a.length;
			for (int i=0; i<a.length; i++) {
				if (i== current) {
					g.setColor(Color.RED);
				}
				else if (i <= previous) {
					g.setColor(Color.BLUE);
				}
				else {
					g.setColor(Color.BLACK);
				}
				g.drawRect(50, i*dist, dist/2* a[i], 10);
			}
		}
		finally {
			sortLock.unlock();
		}
		
	}
	public void pause(int steps) throws InterruptedException {  
		comp.repaint();  
		Thread.sleep(steps * DELAY); 
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}