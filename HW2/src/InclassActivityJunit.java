import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class InclassActivityJunit {
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
