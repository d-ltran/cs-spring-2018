import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Simpletest {
	private Person joe;
	private Person dan;
	private Library lib;
	private ArrayList<Book> group;
	private Book book1;
	private Book book2;
	private Book book3;
	private ArrayList<Person> customers;
	public void setUp()
	{
		lib= new Library("FFC");
		book1= new Book("Harry Potter", "Rowling", 2453, 19.99);
		book2= new Book("Harry Potter", "Rowling",34444, 25.99);
		book3= new Book("Chamber", "Rowling",108898, 18.99);
		group= new ArrayList<Book>();
		group.add(book1);
		group.add(book2);
		group.add(book3);
		joe= new Person("Joe", "MetFevre", 22342);
		dan= new Person("Dan", "Metfevre", 22345);
		customers.add(joe);
		customers.add(dan);
		lib.setPatrons(customers);
		lib.setLibraryBooks(group);
	}
	@Test
	public void testCheckNumCopies() {

		assertEquals(2, lib.checkNumCopies("Harry Potter", "Rowling"));

	}

}
