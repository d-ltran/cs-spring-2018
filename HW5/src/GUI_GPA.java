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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_GPA extends JFrame{
	//	private JLabel instructions;
	private JButton enter;
	private JLabel title;
	private JLabel lcredithrs;
	private JLabel lgrade;
	private JLabel lcourse;
	private JLabel lgpa;
	private JTextField texthours;
	private JTextField textgrade;
	private JTextField textcourse;
	private JPanel paneltitle;
	private JPanel panelcourses;
	private BoxLayout container;
	private Container pane;

	public GUI_GPA() {
		super("GUI GPA CALCULATOR");
//		initializing all my fields
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.setSize(width/2, height/2);
		paneltitle=new JPanel();
		panelcourses= new JPanel();
		
		
		paneltitle.setLayout(new BoxLayout(paneltitle, BoxLayout.Y_AXIS));
		panelcourses.setLayout(new BoxLayout(panelcourses, BoxLayout.Y_AXIS));
		
		title= new JLabel("GPA Calculator");
		title.setFont(new Font("Arial",Font.BOLD, 20) );
		
		lcredithrs= new JLabel("Credit Hours:");
		lcredithrs.setLocation(width/20, height/20);
		lgrade= new JLabel("Letter Grade:");
		lcourse= new JLabel("Course Name:");
		enter= new JButton("ENTER");
		

		paneltitle.add(title);
		panelcourses.add(lcredithrs);
		panelcourses.add(lgrade);
		panelcourses.add(lcourse);
		panelcourses.add(enter);
		paneltitle.setVisible(true);
		panelcourses.setVisible(true);
		this.getContentPane().add(paneltitle);
		this.getContentPane().add(panelcourses);
		this.setVisible(true);
	}
	public static void main(String args[]) {
		new GUI_GPA();
	}
}
