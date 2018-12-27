import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GpaCalc extends JFrame{
	// set form controls as instance variables
	private JButton actionButton;
	private JLabel infoLabel;
	// a layout object determines how controls are drawn on the panel
	private FlowLayout layout = new FlowLayout();
	
	// the main method invokes the createAndShowGUI method
	// using a runnable object
	public static void main(String[] args) {
		 javax.swing.SwingUtilities.invokeLater(new Runnable() { // ** ANONYMOUS CLASS **
	            public void run() {     // Runnable -> Interface! Needs: run()
	               createAndShowGUI();
	            }
	        });
	} // --- END main ---
	// createAndShowGUI creates an instance of the current
	// class and displays it
	 private static void createAndShowGUI() {
	        //Create and set up the window. 
	        GpaCalc frame = new GpaCalc();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //Set up the content pane.
	        frame.addComponentsToPane(frame.getContentPane());
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	private void addComponentsToPane(Container contentPane) {
		// TODO Auto-generated method stub
		
	}
}
