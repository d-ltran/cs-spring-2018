import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class GPA_Calc_2 extends JFrame{
//	Pane
	private Container contents;
	
//	Panels
	private JPanel panelCenter;
	private JPanel panelEast;
	
//	Componenets
	private JButton buttonAdd;
//	JTable to add all of my courses to
	private JTable tableCoursesInfo;
	
//	Border
	private Border borderRegion= BorderFactory.createLineBorder(Color.black, 1);
	
//	Fonts
	private final Font fontBold= new Font(Font.DIALOG, Font.BOLD, 20);
	
//	Layouts
	private FlowLayout flowLayout= new FlowLayout();
	private BorderLayout borderLayout= new BorderLayout();
//	etc
	private String[] tableHeader= {"Credit Hours", "Letter Grade", "Course Name"};
//	private ArrayList<String> listOneCourseData;
	private ArrayList<String[]> listAllCourseData;
	private int gpa;
	
	public GPA_Calc_2(){
		super("GUI GPA Calculator");
		contents= getContentPane();
		
//		Title Area
		JLabel lblTitle= new JLabel("GPA Calculator", SwingConstants.CENTER);
		lblTitle.setFont(fontBold);
		
		contents.add(lblTitle, BorderLayout.NORTH);
		
//		Center Area
		panelCenter= new JPanel();
		panelCenter.setLayout(flowLayout);
		panelCenter.setBorder(borderRegion);
		panelEast= new JPanel();
		panelEast.setLayout(borderLayout);
		panelEast.setBorder(borderRegion);
//		Label+Textfields etc...
		JLabel lblcreditHrs= new JLabel("Credit Hours:");
		JTextField txtcreditHrs= new JTextField("", 15);
		JLabel lblgrade= new JLabel("Letter Grade:");
		JTextField txtgrade= new JTextField("", 15);
		JLabel lblcourseName= new JLabel("Course Name:");
		JTextField txtcourseName= new JTextField("", 15);
		
		buttonAdd= new JButton("Add Course");
		listAllCourseData= new ArrayList<String[]>(); 
		gpa=0;
		JLabel lblgpa= new JLabel("GPA= "+ gpa);

//		Table
		tableCoursesInfo= new JTable();
		DefaultTableModel model= new DefaultTableModel();
		model.setColumnIdentifiers(tableHeader);
		model.addRow(tableHeader);
		tableCoursesInfo.setModel(model);
		tableCoursesInfo.setRowHeight(20);
	
//		Handle Event when the Submit Button is Pressed
		
		String[] row= new String[3];
		buttonAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent add) {
				// TODO Auto-generated method stub
				row[0]=txtcreditHrs.getText();
				row[1]=txtgrade.getText();
				row[2]=txtcourseName.getText();
				model.addRow(row);
//				Adding this Array to an Arraylist that contains Array of Strings
				calculategpa();
				listAllCourseData.add(row);
				txtcreditHrs.setText("");
				txtgrade.setText("");
				txtcourseName.setText("");
				
			}

		});
			
		
		
		panelCenter.add(lblcreditHrs);
		panelCenter.add(txtcreditHrs);
		panelCenter.add(lblgrade);
		panelCenter.add(txtgrade);
		panelCenter.add(lblcourseName);
		panelCenter.add(txtcourseName);
		panelCenter.add(buttonAdd);
		panelEast.add(tableCoursesInfo, BorderLayout.NORTH);
		panelEast.add(lblgpa, BorderLayout.SOUTH);
		
		contents.add(panelCenter, BorderLayout.CENTER);
		contents.add(panelEast,BorderLayout.WEST);
		
//		Set Window Size etc..
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.setSize(width/2, height/2);
		setLocationRelativeTo(null); //Centers Window
		this.setVisible(true);	
	}
	public static void main(String args[]) {
		GPA_Calc_2 gui = new GPA_Calc_2();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	public void calculategpa() {
		this.gpa+=1;
	}
	
	
}
