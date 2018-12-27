//Daniel Tran dlt2hc Homework 2
import java.util.*;
public class Person {
	private String name;
	private ArrayList<Book> checkedOut;
	private String address;
	private int libraryCardNum;

	public Person(String name, String address, int libraryCardNum) {
		this.name=name;
		this.address=address;
		checkedOut= new ArrayList<Book>();
		this.libraryCardNum=libraryCardNum;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public ArrayList<Book> getCheckedOut() {
		return checkedOut;
	}
	public void setCheckedOut(ArrayList<Book> checkedOut) {
		this.checkedOut = checkedOut;
	}
	public boolean addBook(Book b) {
		if (this.checkedOut.contains(b)) {
			return false;
		}
		else {
			this.checkedOut.add(b);
			return true;
		}
	}
	public boolean hasRead(Book b) {
		return this.checkedOut.contains(b);
	}
	public int numBooksRead() {
		return checkedOut.size();
	}
	public boolean equals(Object o) {
		if (o instanceof Person ) {
			Person here= (Person)(o);
			here.libraryCardNum=((Person)o).getLibraryCardNum();
			return true;
			}
		return false;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLibraryCardNum() {
		return libraryCardNum;
		
	}
	public void setLibraryCardNum(int libraryCardNum) {
		this.libraryCardNum = libraryCardNum;
	}
	public String toString() {
		return "Name: "+this.name+", Library Card Number: "+this.libraryCardNum+", Books CheckedOut: "+this.checkedOut;
	}

	
	

}


