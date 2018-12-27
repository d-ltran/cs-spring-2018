//Daniel Tran dlt2hc Homework 2
public class Book {
	private String title;
	private String author;
	private String dueDate;
	private boolean checkedOut;
	private int bookId;
	private double bookValue;


	public Book(String title, String author, int bookId, double bookValue) {
		this.title=title;
		this.author=author;
		this.bookId=bookId;
		this.bookValue=bookValue;
		this.dueDate="";
		this.checkedOut=false;
		
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title) {
		this.title=title;
	}
	public int getBookId() {
		return bookId;
	}
	public double getBookValue() {
		return bookValue;
	}
	public void setBookValue(double bookValue) {
		this.bookValue=bookValue;
	}
	public boolean isCheckedOut() {
		return checkedOut;	
	}
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut=checkedOut;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate=dueDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean equals(Object o) {
		if (o instanceof Book) {
			Book b1= (Book) o;
			return (b1.getAuthor()== this.author&& b1.getTitle()==this.title&&b1.getBookId()==this.bookId);
		}
		else {
			return false;
		}
	}
	public String toString() {
		return "Title: "+this.title+"  Author: "+ this.author;
	}

}

