package wagner.app.library.tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import wagner.app.library.BookStatus;
import wagner.app.library.Library;

@FixMethodOrder(MethodSorters.JVM)
public class LibraryTest {

	Library library;

	@Before
	public void setUp() throws Exception {
		library = new Library();
	}

	@After
	public void tearDown() throws Exception {
		library.library.clear();
		library = null;
	}

	@Test
	public final void testAddBookToLibrary() {
		library.addBookToLibrary("Title_1", "Author_1", 2018);
		assertEquals(1, library.library.size());
	}

	@Test
	public final void testRemoveBook() {
		library.addBookToLibrary("Title_1", "Author_1", 2018);
		int id = getCurrentBookID(library);
		library.removeBook(id);
		assertEquals(0, library.library.size());
	}

	@Test
	public final void testRemoveBookNotExist() {
		library.removeBook(-10);
		assertEquals(0, library.library.size());
	}

	@Test
	public final void testRemoveBookBorrowed() {
		library.addBookToLibrary("Title_1", "Author_1", 2018);
		int id = getCurrentBookID(library);
		library.rentBook(id, "Nowak Leszek");
		id = getCurrentBookID(library);
		library.removeBook(id);
		assertEquals(1, library.library.size());
	}

	@Test
	public final void testRentBookExist() {
		library.addBookToLibrary("Title_1", "Author_1", 2018);
		int id = getCurrentBookID(library);
		library.rentBook(id, "Kowalski Jan");
		assertEquals(1, library.library.size());
		assertEquals(BookStatus.borrowed, library.library.get(id).getStatus());
	}

	@Test
	public final void testRentBookBorrowed() {
		library.addBookToLibrary("Title_1", "Author_1", 2018);
		int id = getCurrentBookID(library);
		library.rentBook(id, "Kowalski Jan");
		library.rentBook(id, "Nowak Cezary");
		assertEquals("Kowalski Jan", library.library.get(id).getBorrower());
		assertEquals(1, library.library.size());
		assertEquals(BookStatus.borrowed, library.library.get(id).getStatus());
	}

	@Test
	public final void testRentBookNotExist() {
		// todo
	}

	private int getCurrentBookID(Library library) {
		int id = 0;
		for (Integer key : library.library.keySet()) {
			id = key;
		}
		return id;
	}
}
