//Daniel Tran dlt2hc
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//My Assumptions:
//        - A TA at office hours said that a blank credit could be counted towards the gpa. I going under the assumption that if a student were
//          to add a course unassociated with a grade, it would count as an F.
//        - My user will always input a credit hour that is an integer
//		  - My user will always put in either a valid letter grade or nothing
//        	
public class GPA_Calc_1 extends JFrame{
	//	Pane************************************************
	private Container contents;

	//	Panels************************************************
	private JPanel panelCenter;
	private JPanel panelEast;

	//	Componenets************************************************
	private JButton buttonAdd;
	private JButton buttonRemove;
	private JButton btnRefresh;
	private JButton btnAddCredits;//for adding 15 blank credits( Adding 5 courses with no grades assuming that they each are worth 3 credits)
	private JButton btnEnterTarget;
	private JTextField txttarget;
	private JLabel lbltargetlbl;
	private JLabel lblrequiredgpa;
	private JLabel lblgpa;
	private JTextArea txtareaHighRequired;
	private JTextArea txtareaLowRequired;
	;
	//	JTable to add all of my courses to************************************************
	private JTable tableCoursesInfo;
	private DefaultTableModel model;

	//	Border
	private Border borderRegion= BorderFactory.createLineBorder(Color.black, 1);

	//	Fonts
	private final Font fontBold= new Font(Font.DIALOG, Font.BOLD, 20);

	//	Layouts************************************************
	private FlowLayout flowLayout= new FlowLayout();
	//	etc
	private String[] tableHeader= {"Credit Hours", "Letter Grade", "Course"};
	//	private ArrayList<String> listOneCourseData;************************************************
	private double gpa;
	private double requiredGpa;
	private int currentCredits;
	private int untakenCredits;


//		Constructor for GUI8**************************************************
	public GPA_Calc_1(){
		super("GUI GPA Calculator");
		contents= getContentPane();

		//		Title Area
		JLabel lblTitle= new JLabel("GPA Calculator", SwingConstants.CENTER);
		lblTitle.setFont(fontBold);

		contents.add(lblTitle, BorderLayout.NORTH);

		//		Center Area************************************************
		panelCenter= new JPanel();
		panelCenter.setLayout(flowLayout);
		panelCenter.setBorder(borderRegion);
		panelEast= new JPanel();
		panelEast.setLayout(flowLayout);
		panelEast.setBorder(borderRegion);
		//		Label+Textfields etc...************************************************
		JLabel lblcreditHrs= new JLabel("Credit Hours:");
		JTextField txtcreditHrs= new JTextField("", 12);
		JLabel lblgrade= new JLabel("Letter Grade:");
		JTextField txtgrade= new JTextField("", 12);
		JLabel lblcourseName= new JLabel("Course Name:");
		JTextField txtcourseName= new JTextField("", 12);
		lbltargetlbl = new JLabel("Target GPA: ");
		txttarget= new JTextField("",12);
		lblrequiredgpa= new JLabel("Required GPA: "+requiredGpa);
		txtareaHighRequired= new JTextArea();
		txtareaLowRequired= new JTextArea();
		//		Buttons************************************************
		buttonAdd= new JButton("Add Course");
		buttonRemove= new JButton("Remove By Selection");
		btnRefresh= new JButton("Remove All");
		btnAddCredits= new JButton("Add 15 Blank Credits");
		btnEnterTarget= new JButton("Enter Target GPA");
		// GPA labels and stuff
		gpa=0.0;
		lblgpa= new JLabel("GPA= "+ gpa);
		//		Table and setup
		tableCoursesInfo= new JTable();
		tableCoursesInfo.setOpaque(false);
//		tableCoursesInfo.setForeground(Color.white);
		tableCoursesInfo.setBackground(new Color(186, 239, 252));
		tableCoursesInfo.setGridColor(Color.black);
		model= new DefaultTableModel();
		model.setColumnIdentifiers(tableHeader);
		model.addRow(tableHeader);
		tableCoursesInfo.setModel(model);
		tableCoursesInfo.setRowHeight(20);
		tableCoursesInfo.setBorder(borderRegion);
		String[] row= new String[3];


//************************************************************************************************************************************************************
//		Event Handlers BELOW:*************************************************

//			Adding a Course**********************
		buttonAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent add) {
				// Handling Addcourse
				lblrequiredgpa.setText("Required GPA: 0.0");
				txtareaHighRequired.setText("");
				txtareaLowRequired.setText("");
				row[0]=txtcreditHrs.getText().trim();
				row[1]=txtgrade.getText().trim();
				row[2]=txtcourseName.getText().trim();
				model.addRow(row);
				//				Adding this Array to an Arraylist that contains Array of Strings
				//				listAllCourseData.add(row);
				//				System.out.println(listAllCourseData.get(0)[1]);
				calculategpa();
				txtcreditHrs.setText("");
				txtgrade.setText("");
				txtcourseName.setText("");

			}

		});
//			Removing a single course by selection********************************************
		buttonRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent remove) {
				// Handling Remove One Course
				lblrequiredgpa.setText("Required GPA: 0.0");
				txtareaHighRequired.setText("");
				txtareaLowRequired.setText("");
				int i = tableCoursesInfo.getSelectedRow();
				if (i>=0) {
					model.removeRow(i);
					calculategpa();
				}
				else {
					System.out.println("Delete Error");
				}


			}

		});
//		Refreshing the Course Page**********************************************************

		btnRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent removeAll) {
				// While loop to Remove all Data
				lblrequiredgpa.setText("Required GPA: 0.0");
				txtareaHighRequired.setText("");
				txtareaLowRequired.setText("");
				while(model.getRowCount()>1) {
					int size= model.getRowCount();
					model.removeRow(size-1);
				}

				lblgpa.setText("GPA: "+0.0);
			}

		});
//		Add 15 Credits************************************************************************
		btnAddCredits.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent addblankcourses) {
				// Adding 15 blank credits 
				lblrequiredgpa.setText("Required GPA: 0.0");
				txtareaHighRequired.setText("");
				txtareaLowRequired.setText("");
				int i = 0;
				String[] blankCredits= {"3","",""};
				while(i<5) {
					model.addRow(blankCredits);
					i++;
				}
				calculategpa();
			}

		});
//		Handles Enter Target GPA to Required GPA***********************************************

		btnEnterTarget.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent targetGPA) {
				txtareaHighRequired.setText("");
				txtareaLowRequired.setText("");
				// Calculates the Target GPA
				int totalcredits=0;
				double targetgpa= Double.parseDouble(txttarget.getText().trim());
				for (int i =1; i < model.getRowCount();i++) {
					totalcredits+=Integer.parseInt((String)model.getValueAt(i, 0));
				}
				requiredGpa=((targetgpa*totalcredits)-(gpa*currentCredits))/(untakenCredits);
				lblrequiredgpa.setText("Required GPA: "+(Math.round(requiredGpa*100.0)/100.0));
				if (requiredGpa>4.0) {
					txtareaHighRequired.setText("The required GPA you would have to \nachieve for these credits is over 4.0. \nTry adding more credits and recalculating");
				}
				else if (requiredGpa<2.0){
					txtareaLowRequired.setText("Your requied GPA is less than 2.0.\n You can take fewer credit hours if you \nwish and still reach your target GPA.");
				}
				txttarget.setText("");
			}

		});
//		END OF EVENT HANDLERS****************************************************************************************************************************************************************************************************************************************
		//		Adding to Panel Center
		panelCenter.add(lblcreditHrs);
		panelCenter.add(txtcreditHrs);
		panelCenter.add(lblgrade);
		panelCenter.add(txtgrade);
		panelCenter.add(lblcourseName);
		panelCenter.add(txtcourseName);
		panelCenter.add(buttonAdd);
		panelCenter.add(buttonRemove);
		panelCenter.add(btnRefresh);
		panelCenter.add(btnAddCredits);
		panelCenter.add(lbltargetlbl);
		panelCenter.add(txttarget);
		panelCenter.add(btnEnterTarget);
		panelCenter.add(lblrequiredgpa);
		panelCenter.add(txtareaHighRequired);
		panelCenter.add(txtareaLowRequired);
		//		Adding to PanelEast
		panelEast.add(tableCoursesInfo, BorderLayout.SOUTH);
		panelEast.add(lblgpa);
		//		Adding to the Pane
		contents.add(panelCenter, BorderLayout.CENTER);
		contents.add(panelEast,BorderLayout.EAST);

		//		Set Window Size, set to visible,  etc..
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.setSize(width/2, height/2);
		setLocationRelativeTo(null); //Centers Window
		this.setVisible(true);	
	}
	public static void main(String args[]) {
		GPA_Calc_1 gui = new GPA_Calc_1();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
//	A Method for calculating GPA in my gui**********************************************************
	public void calculategpa() {
		//In calculating GPA, I assume that the use will always enter credit hours.
		double lettersum=0;
		double totalcredits=0;
		currentCredits=0;
		untakenCredits=0;
		
		//		A for loop to find the sum of (credit hours * LetterGradeConverted to GPA)
		for (int i =1; i < model.getRowCount();i++) {
			int courseCredit = Integer.parseInt((String)model.getValueAt(i,0));
			String lettergrade= (String) model.getValueAt(i, 1);			
			if (lettergrade.equals("A")||lettergrade.equals("A+")) {
				totalcredits+=courseCredit;
				lettersum+= 4*courseCredit;
				currentCredits+=courseCredit;
			}
			else if (lettergrade.equals("A-")) {
				totalcredits+=courseCredit;
				lettersum+= 3.7*courseCredit;
				currentCredits+=courseCredit;
			}
			else if (lettergrade.equals("B+")) {
				totalcredits+=courseCredit;
				lettersum+= 3.3*courseCredit;
				currentCredits+=courseCredit;
			}
			else if (lettergrade.equals("B")) {
				totalcredits+=courseCredit;
				lettersum+= 3.0*courseCredit;
				currentCredits+=courseCredit;
			}
			else if (lettergrade.equals("B-")) {
				totalcredits+=courseCredit;
				lettersum+= 2.7*courseCredit;
				currentCredits+=courseCredit;
			}
			else if (lettergrade.equals("C+")) {
				totalcredits+=courseCredit;
				lettersum+= 2.3*courseCredit;
				currentCredits+=courseCredit;
			}
			else if (lettergrade.equals("C")) {
				totalcredits+=courseCredit;
				lettersum+= 2.0*courseCredit;
				currentCredits+=courseCredit;
			}
			else if (lettergrade.equals("C-")) {
				totalcredits+=courseCredit;
				lettersum+= 1.7*courseCredit;
				currentCredits+=courseCredit;
			}
			else if (lettergrade.equals("D+")) {
				totalcredits+=courseCredit;
				currentCredits+=courseCredit;
				lettersum+= 1.3*courseCredit;
			}
			else if (lettergrade.equals("D")) {
				totalcredits+=courseCredit;
				lettersum+= 1.0*courseCredit;
				currentCredits+=courseCredit;
			}
			else if (lettergrade.equals("D-")) {
				totalcredits+=courseCredit;
				lettersum+= .7*courseCredit;
				currentCredits+=courseCredit;
			}
			else if (lettergrade.equals("F")) {
				totalcredits+=courseCredit;
				lettersum+= 0*courseCredit;
				currentCredits+=courseCredit;
			}
			else {
				untakenCredits+=courseCredit;
			}

		}

		this.gpa= lettersum/totalcredits;
		lblgpa.setText("GPA = "+(Math.round(gpa*100.0)/100.0));
	}


}
