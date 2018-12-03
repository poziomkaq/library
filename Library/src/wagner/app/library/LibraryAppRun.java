package wagner.app.library;
public class LibraryAppRun {

	public static void main(String[] args) {
		Library myLibrary = new Library();

		System.out.println("The initial state of the library resource: " + myLibrary.library.size());
		myLibrary.addBookToLibrary("Title_0", "Author_0", 2012);
		System.out.println("Control library resource after adding one book: " + myLibrary.library.size());
		
		//  fill the library with books
		for (int i = 1; i < 6; i++) {
			myLibrary.addBookToLibrary("Title_1" + i, "Author_1" + i, 2000 + i);
		}
		
		myLibrary.showResourceViewFromLibrary();
		myLibrary.removeBook(8);
		myLibrary.removeBook(2);
		myLibrary.rentBook(1, "Kowalski Jan");
		myLibrary.rentBook(1, "Michalczyk Ewa");
		myLibrary.rentBook(100, "Nowak Leszek");
		myLibrary.showResourceViewFromLibrary();
		myLibrary.searchBookByTitle("Title_11");
		myLibrary.searchBookByAuthor("Author_15");
		myLibrary.searchBookByYear(2009);
		myLibrary.addBookToLibrary("Title_11", "Author_11", 2001);
		myLibrary.searchBookByTitle("Title_");
	}
}