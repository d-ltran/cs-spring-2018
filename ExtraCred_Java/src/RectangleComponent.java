import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
public class RectangleComponent  extends JComponent {
	// Recover Graphics2D
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g; 
		// Construct a rectangle and draw it 
		Rectangle box = new Rectangle(5, 10, 20, 30);
		g2.draw(box); 
		// Move rectangle 15 units to the right and 25 units down 21
		box.translate(15, 25);       // Draw moved rectangle
		g2.draw(box); 
	}
}
