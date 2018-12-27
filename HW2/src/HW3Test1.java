import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class HW3Test1 {
	@Test
	public void testCheckNumCopies() {
		Book book1= new Book("Harry Potter", "Rowling", 2453, 19.99);
		Book book5= new Book("Harry Potter", "Rowling", 2454, 19.99);
		Book book6= new Book("Harry Potter", "Rowling", 2455, 19.99);
		Book book7= new Book("Harry Potter", "Rowling", 2456, 19.99);
		Book book2= new Book("Prisoner of Azkaban", "Rowling",34444, 25.99);
		Book book3= new Book("Chamber", "Rowling",108898, 18.99);
		Book book4= new Book("Order", "Rowling", 8938762, 20.00);

		Library lib= new Library("FFC");
		ArrayList<Book> group= new ArrayList<Book>();
		group.add(book1);
		group.add(book2);
		group.add(book3);
		group.add(book4);
		group.add(book5);
		group.add(book6);
		group.add(book7);
		lib.setLibraryBooks(group);
		assertEquals(4, lib.checkNumCopies("Harry Potter", "Rowling"));
	}
	@Test
	public void testCheckNumCopieswhenzero() {
		Book book1= new Book("Harry Potter", "Rowling", 2453, 19.99);
		Book book2= new Book("Prisoner of Azkaban", "Rowling",34444, 25.99);
		Book book3= new Book("Chamber", "Rowling",108898, 18.99);
		Book book4= new Book("Order", "Rowling", 8938762, 20.00);
		Book book5= new Book("Harry Potter", "Rowling", 2454, 19.99);
		Book book6= new Book("Harry Potter", "Rowling", 2455, 19.99);
		Book book7= new Book("Harry Potter", "Rowling", 2456, 19.99);
		Library lib= new Library("FFC");
		ArrayList<Book> group= new ArrayList<Book>();
		group.add(book1);
		group.add(book2);
		group.add(book3);
		group.add(book4);
		group.add(book5);
		group.add(book6);
		group.add(book7);
		lib.setLibraryBooks(group);
		assertTrue(lib.checkNumCopies("Deathly Hollows", "Rowling")==0);
	}
	@Test
	public void testCheckOut() {
		Book book1= new Book("Harry Potter", "Rowling", 2453, 19.99);
		Book book2= new Book("Prisoner of Azkaban", "Rowling",34444, 25.99);
		Book book3= new Book("Chamber", "Rowling",108898, 18.99);
		Book book4= new Book("Order", "Rowling", 8938762, 20.00);
		Book book5= new Book("Harry Potter", "Rowling", 2454, 19.99);
		Book book6= new Book("Harry Potter", "Rowling", 2455, 19.99);
		Book book7= new Book("Harry Potter", "Rowling", 2456, 19.99);
		Library lib= new Library("FFC");
		Person personone=new Person("Bill", "Northwyck Ct.",123);
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
		assertEquals(true,lib.checkOut(personone, book1, "30 02 2018"));

	}
	@Test
	public void testCheckOutwhenNotPatron() {
		Book book1= new Book("Harry Potter", "Rowling", 2453, 19.99);
		Book book2= new Book("Prisoner of Azkaban", "Rowling",34444, 25.99);
		Book book3= new Book("Chamber", "Rowling",108898, 18.99);
		Book book4= new Book("Order", "Rowling", 8938762, 20.00);
		Book book5= new Book("Harry Potter", "Rowling", 2454, 19.99);
		Book book6= new Book("Harry Potter", "Rowling", 2455, 19.99);
		Book book7= new Book("Harry Potter", "Rowling", 2456, 19.99);
		Library lib= new Library("FFC");
		Person personone=new Person("Bill", "Northwyck Ct.",123);
		Person persontwo=new Person("Dan", "Hollywood",5429);
		ArrayList<Person> customers= new ArrayList<Person>();
		customers.add(persontwo);
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
		lib.checkOut(persontwo, book1, "30 02 2018");
		assertEquals(false,lib.checkOut(personone, book1, "30 02 2018"));

	}
	@Test
	public void bookDueOnDate() {
		Book book1= new Book("Harry Potter", "Rowling", 2453, 19.99);
		Book book2= new Book("Prisoner of Azkaban", "Rowling",34444, 25.99);
		Book book3= new Book("Chamber", "Rowling",108898, 18.99);
		Book book4= new Book("Order", "Rowling", 8938762, 20.00);
		Book book5= new Book("Harry Potter", "Rowling", 2454, 19.99);
		Book book6= new Book("Harry Potter", "Rowling", 2455, 19.99);
		Book book7= new Book("Harry Potter", "Rowling", 2456, 19.99);
		Library lib= new Library("FFC");
		book1.setDueDate("15 03 2018");
		book2.setDueDate("15 03 2018");
		book3.setDueDate("15 03 2018");
		ArrayList<Book> group= new ArrayList<Book>();
		group.add(book1);
		group.add(book2);
		group.add(book3);
		group.add(book4);
		group.add(book5);
		group.add(book6);
		group.add(book7);
		ArrayList<Book> realbooks= new ArrayList<Book>();
		realbooks.add(book1);
		realbooks.add(book2);
		realbooks.add(book3);
		lib.setLibraryBooks(group);
		assertEquals(realbooks, lib.booksDueOnDate("15 03 2018"));
	}
	@Test
	public void bookDueOnDateWhenDueDatenotequal() {
		Book book1= new Book("Harry Potter", "Rowling", 2453, 19.99);
		Book book2= new Book("Prisoner of Azkaban", "Rowling",34444, 25.99);
		Book book3= new Book("Chamber", "Rowling",108898, 18.99);
		Book book4= new Book("Order", "Rowling", 8938762, 20.00);
		Book book5= new Book("Harry Potter", "Rowling", 2454, 19.99);
		Book book6= new Book("Harry Potter", "Rowling", 2455, 19.99);
		Book book7= new Book("Harry Potter", "Rowling", 2456, 19.99);
		Library lib= new Library("FFC");
		book1.setDueDate("15 03 2018");
		book2.setDueDate("15 03 2018");
		book3.setDueDate("15 03 2018");
		ArrayList<Book> group= new ArrayList<Book>();
		ArrayList<Book> nonein= new ArrayList<Book>();
		group.add(book1);
		group.add(book2);
		group.add(book3);
		group.add(book4);
		group.add(book5);
		group.add(book6);
		group.add(book7);
		lib.setLibraryBooks(group);
		assertEquals(nonein, lib.booksDueOnDate("15 04 2018"));
	}
	@Test
	public void testLateFee() {
		Book book1= new Book("Harry Potter", "Rowling", 2453, 20.0);
		Book book2= new Book("Prisoner of Azkaban", "Rowling",34444, 20.0);
		Book book3= new Book("Chamber", "Rowling",108898, 18.99);
		Book book4= new Book("Order", "Rowling", 8938762, 20.00);
		Book book5= new Book("Harry Potter", "Rowling", 2454, 19.99);
		Book book6= new Book("Harry Potter", "Rowling", 2455, 19.99);
		Book book7= new Book("Harry Potter", "Rowling", 2456, 19.99);
		Library lib= new Library("FFC");
		Person personone=new Person("Bill", "Northwyck Ct.",123);
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
		lib.checkOut(personone, book1, "07 02 2018");
		lib.checkOut(personone, book2, "07 02 2018");
		assertTrue(lib.lateFee(personone)==3.6);
	}
	@Test
	public void TestLateFeeWhennotPatron() {
		
		Book book1= new Book("Harry Potter", "Rowling", 2453, 19.99);
		Book book2= new Book("Prisoner of Azkaban", "Rowling",34444, 25.99);
		Book book3= new Book("Chamber", "Rowling",108898, 18.99);
		Book book4= new Book("Order", "Rowling", 8938762, 20.00);
		Book book5= new Book("Harry Potter", "Rowling", 2454, 19.99);
		Book book6= new Book("Harry Potter", "Rowling", 2455, 19.99);
		Book book7= new Book("Harry Potter", "Rowling", 2456, 19.99);
		Library lib= new Library("FFC");
		Person personone=new Person("Bill", "Northwyck Ct.",123);
		lib.checkOut(personone, book1, "13 02 2018");
		ArrayList<Book> group= new ArrayList<Book>();
		group.add(book1);
		group.add(book2);
		group.add(book3);
		group.add(book4);
		group.add(book5);
		group.add(book6);
		group.add(book7);
		lib.setLibraryBooks(group);
		
		assertTrue(lib.lateFee(personone)==0.0);
	}
	public void TesttoStringBook(){
		Book book1= new Book("Harry Potter", "Rowling", 2453, 19.99);
		assertTrue(book1.toString().equals("Title: Harry Potter Author: Rowling"));
	}
	public void setdueDate() {
		Book b7=new Book("Harry Potter", "Rowling", 2453, 19.99);
		assertEquals("Your getDueDate or setDueDate in book didn't pass our tests", b7.getDueDate(), "01 03 2016");
	}


}
