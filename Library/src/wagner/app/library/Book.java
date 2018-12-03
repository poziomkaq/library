package wagner.app.library;

public class Book {

	String title;
	// formatowanie roku dodaj
	int year;
	String author;
	private int id;
	static int nextId = 1;
	BookStatus status = BookStatus.notBorrowed;
	String borrower = "";

	public Book(String title, String author, int year) {
		this.title = title;
		this.year = year;
		this.author = author;
		this.id = getNextId();
		setNextId(++nextId);
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNextId() {
		return nextId;
	}

	public void setNextId(int nextId) {
		Book.nextId = nextId;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

	public String toString() {
		if (getStatus() == BookStatus.notBorrowed) {
			return " TITLE: " + getTitle() + " AUTHOR: " + getAuthor() + " YEAR: " + getYear() + " STATUS: "
					+ getStatus();
		}
		return " TITLE: " + getTitle() + " AUTHOR: " + getAuthor() + " YEAR: " + getYear() + " STATUS: " + getStatus()
				+ " by " + getBorrower();
	}

}
