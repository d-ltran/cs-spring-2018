import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class SelectionSorterGraphic extends JComponent{
	private SelectionSort thesorter;
	
	public SelectionSorterGraphic() {
		int[] array= ArrayUtil.randomIntArray(30, 50);
		thesorter= new SelectionSort(array, this);
	}
	
	public void paintComponent(Graphics g) {
		thesorter.draw(g);
//		Graphics2D g2 = (Graphics2D) g;
//		g2.fill(sorter);
	}
	public void startingMove() {
		class AnimationRun implements Runnable{
			public void run() {
				try {
					thesorter.sort();
				}
				catch(InterruptedException exception) {
					
				}
			}
			
		}
		Runnable runner= new AnimationRun();
		Thread tread= new Thread(runner);
		tread.start();
	}
}
