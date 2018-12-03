package wagner.app.library;

import java.util.HashMap;
import java.util.Map.Entry;

public class Library {

	public HashMap<Integer, Book> library ;
	
	public Library() {
		super();
		library =  new HashMap<Integer, Book>();
	}

	public void addBookToLibrary(String title, String author, int year) {
		Book book = new Book(title, author, year);
		library.put(Integer.valueOf(book.getId()), book);
	}

	public void removeBook(int id) {
		if (library.containsKey(id)) {
			Book bookToRemove = library.get(id);
			if (bookToRemove.getStatus().equals(BookStatus.notBorrowed)) {
				library.remove(id);
			} else {
				System.out.println("This book is borrowed by " + bookToRemove.getBorrower() + ".\n");
			}
		} else {
			System.out.println("This book is does not exist.\n");
		}
	}

	public void rentBook(int id, String borrower) {
		if (library.containsKey(id)) {
			Book bookToRent = library.get(id);
			if (bookToRent.getStatus() == BookStatus.notBorrowed) {
				bookToRent.setBorrower(borrower);
				bookToRent.setStatus(BookStatus.borrowed);
				System.out.println("Success. The book with ID number " + id + " was borrowed by "
						+ bookToRent.getBorrower() + ".\n");
			} else {
				System.out.println(
						"The book with ID number " + id + " was borrowed by " + bookToRent.getBorrower() + ".\n");
			}
			library.put(bookToRent.getId(), bookToRent);
		} else {
			System.out.println("The book with ID number " + id + " is does not exist.\n");
		}
	}

	public void showResourceViewFromLibrary() {
		System.out.println(">>> BOOKS FROM MY FAVORITE LIBRARY <<<");
		for (Entry<Integer, Book> book : library.entrySet()) {
			System.out.println("BOOK ID: " + book.getKey() + book.getValue());
		}
		System.out.print("\n");
	}

	public void showLibraryInfo() {
		int numberBorrowedBooks = 0;
		for (Entry<Integer, Book> book : library.entrySet()) {
			if (book.getValue().getStatus() == BookStatus.borrowed) {
				numberBorrowedBooks = numberBorrowedBooks + 1;
			}
		}
		int numberAvailableBooks = library.size() - numberBorrowedBooks;
		System.out.println("The library contains " + numberAvailableBooks + " books.\n");

	}

	public void searchBookByTitle(String titleToSearch) {
		SearchStatus searchStatus = SearchStatus.noSearched;
		for (Entry<Integer, Book> book : library.entrySet()) {
			if (book.getValue().getTitle().equals(titleToSearch)) {
				System.out.println("SEARCH RESULT: BOOK ID: " + book.getKey() + book.getValue() + "\n");
				searchStatus = SearchStatus.searched;
			}
		}
		if (searchStatus.equals(SearchStatus.noSearched)) {
			System.out.println("SEARCH RESULT: In the library there is no book with title: " + titleToSearch+"\n");
		}
	}

	public void searchBookByAuthor(String authorToSearch) {
		SearchStatus searchStatus = SearchStatus.noSearched;
		for (Entry<Integer, Book> book : library.entrySet()) {
			if (book.getValue().getAuthor().equals(authorToSearch)) {
				System.out.println("SEARCH RESULT: BOOK ID: " + book.getKey() + book.getValue()+"\n");
				searchStatus = SearchStatus.searched;
			}
		}
		if (searchStatus.equals(SearchStatus.noSearched)) {
			System.out.println("SEARCH RESULT: In the library there is no book wrote by: " + authorToSearch+"\n");
		}
	}

	public void searchBookByYear(Integer yearToSearch) {
		SearchStatus searchStatus = SearchStatus.noSearched;
		for (Entry<Integer, Book> book : library.entrySet()) {
			if (Integer.valueOf(book.getValue().getYear()).equals(yearToSearch)) {
				System.out.println("SEARCH RESULT: BOOK ID: " + book.getKey() + book.getValue()+"\n");
			}
		}
		if (searchStatus.equals(SearchStatus.noSearched)) {
			System.out.println("SEARCH RESULT: In the library there is no book from the year: " + yearToSearch+"\n");
		}
	}

}
