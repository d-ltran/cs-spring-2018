/*
 * 
 * @author Daniel Tran
 * dlt2hc
 * 
 * QUESTIONS
 * 1. 
 *    	I have an array that is accessed by multiple threads in my case there is a 
 *   	thread that sorts the array and the other paints the rectangles accordingly. 
 * 		I used locks to make sure everything is synchronized when the multiple threads 
 * 		share the instance variable of the array.	
 * 2.
 *		Wait is a method that comes from the Object class and sleep is
 * 		a method that is called on a thread. When a thread sleeps it
 *  	does not release the lock while it is waiting. And a 
 *  	thread .awaits() it does release the lock.
 *  
 * 3.
 *		When a thread calls await(), it goes into a waiting state
 *		is looking for a signal. When there is no signal the thread 
 *		will be doing nothing and is inactive.
 *
 *
 *		Sources Used: Big Java Textbook and http://www.java2novice.com/ for algorithms
 */
import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;


public class Extra extends JFrame{
	private final int WIDTH=300;
	private final int HEIGHT=400;
	public Extra() {
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		final SelectionSorterGraphic component= new SelectionSorterGraphic();
		this.add(component, BorderLayout.CENTER);
		this.setVisible(true);
		component.startingMove();

		
	}
	public static void main(String[] args){     //Main Method
		
		
		Extra algo= new Extra();
		algo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		

		
		
	} 

	
	
}
