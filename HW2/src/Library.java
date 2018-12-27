//dlt2hc Daniel Tran 
//Credits to Google and Stackoverflow for Library latefee()
//Credits to TA Officers for helping Library checkOut()
import java.util.*;
import java.util.Calendar;
import java.text.*;
import java.text.ParseException;



public class Library {
	private ArrayList<Book> libraryBooks;
	private ArrayList<Person> patrons;
	private String name;
	private int numBooks;
	private int numPeople;
	private String currentDate;

	public Library(String name) {
		this.name=name;
		patrons= new ArrayList<Person>();
		libraryBooks= new ArrayList<Book>();
		this.currentDate = new SimpleDateFormat("dd MM yyyy").format(Calendar.getInstance().getTime());
		this.numBooks = libraryBooks.size();
		this.numPeople = patrons.size();
	}
	public ArrayList<Book> getLibraryBooks() {
		return libraryBooks;
	}

	public ArrayList<Person> getPatrons() {
		return patrons;
	}

	public String getName() {
		return name;
	}

	public int getNumBooks() {
		int numb= 0;
		for(int i = 0;i<libraryBooks.size();i++) {
			if (libraryBooks.get(i).isCheckedOut()==false) {
				numb++;
			}
		}
		return numb;
	}

	public int getNumPeople() {
		return numPeople;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setLibraryBooks(ArrayList<Book> libraryBooks) {
		this.libraryBooks = libraryBooks;
	}

	public void setPatrons(ArrayList<Person> patrons) {
		this.patrons = patrons;
		this.numPeople = patrons.size();
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public int checkNumCopies( String title, String author) {
		int numb=0;
		for(int i =0; i < this.libraryBooks.size(); i++) {
			Book here= (libraryBooks.get(i));
			if (here.getTitle().equals(title)&&here.getAuthor().equals(author)) {
				numb++;
			}
		}
		return numb;
	}
	public int totalNumBooks() {

		return libraryBooks.size();
	}
	public boolean checkOut(Person p, Book b, String dueDate) {
		if (patrons.contains(p)) {
			if (libraryBooks.contains(b)) {
				if (b.isCheckedOut() == false) {
					int a = this.libraryBooks.indexOf(b);
					boolean status = p.addBook(this.libraryBooks.get(a));
					this.libraryBooks.get(a).setDueDate(dueDate);
					this.libraryBooks.get(a).setCheckedOut(true);
					return status;
				}
			}
		}
		return false;
	}

	public ArrayList<Book> booksDueOnDate(String date){
		ArrayList<Book> numdue= new ArrayList<Book>();
		for (int i=0;i<libraryBooks.size();i++) {
			if(libraryBooks.get(i).getDueDate()==date) {
				numdue.add(libraryBooks.get(i));
			}
		}
		return numdue;
	}
	public double lateFee(Person p) {
		double totalFee = 0.0;
		ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
		checkedOutBooks = p.getCheckedOut();
		int daysOverdue = 0;

		Calendar cDate = new GregorianCalendar();
		Calendar dDate = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		Date date = new Date();
		try {
			date = sdf.parse(this.currentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cDate.setTime(date);

		for (int i = 0; i < checkedOutBooks.size(); i++) {
			try {
				date = sdf.parse(checkedOutBooks.get(i).getDueDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dDate.setTime(date);
			daysOverdue = daysBetween(dDate.getTime(), cDate.getTime());
			if (daysOverdue > 0) {
				totalFee += .01 * checkedOutBooks.get(i).getBookValue() * daysOverdue;
			}
		}
		return totalFee;
	}
	private int daysBetween(Date time, Date time2) {
		return (int)( (time2.getTime() - time.getTime()) / (1000 * 60 * 60 * 24));
	}


	public String toString() {
		return "Library: "+ this.name+" Patrons: "+this.patrons+ " Books: "+libraryBooks;
	}
	public static void main(String args[]) {
		Library lib= new Library("FFC");
		Book book1= new Book("Harry Potter", "Rowling", 2453, 19.99);
		Book book2= new Book("Prisoner of Azkaban", "Rowling",34444, 25.99);
		Book book3= new Book("Chamber", "Rowling",108898, 18.99);
		Book book4= new Book("Order", "Rowling", 8938762, 20.00);
		Book book5= new Book("Harry Potter", "Rowling", 2454, 19.99);
		Book book6= new Book("Harry Potter", "Rowling", 2455, 19.99);
		Book book7= new Book("Harry Potter", "Rowling", 2456, 19.99);
		Person personone=new Person("Bill", "Northwyck Ct.",123);
		Person persontwo=new Person("Friend","norht", 222);
		ArrayList<Person> customers= new ArrayList<Person>();
		customers.add(personone);
		lib.setPatrons(customers);
		ArrayList<Book> group= new ArrayList<Book>();
		group.add(book1);
		group.add(book2);
		group.add(book3);
		group.add(book4);
		group.add(book5);
		group.add(book6);
		group.add(book7);
		lib.setLibraryBooks(group);
		System.out.println(lib.checkOut(personone, book1, "13 02 2018"));
		System.out.println(lib.checkOut(persontwo, book1, "13 02 2018"));

		System.out.println(personone.getCheckedOut());
		System.out.println(persontwo.getCheckedOut());

	}
}
