package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LibraryTest {

    Library library;
    Collection<Book> books = new ArrayList<>();
    Book book1,book2,book3;

    @BeforeEach
    void init() {
        book1 = new Book(new Title("The Pragmatic Programmer"),new Author("Andy Hunt"),new Year(1999));
        book2 = new Book(new Title("To Kill A MockingBird"),new Author("Harper Lee"),new Year(1987));
        book3 = new Book(new Title("Hamlet"),new Author("Willy Boy"),new Year(1500));
        books.add(book1);
        books.add(book2);
        books.add(book3);
        library = new Library(books);
    }

    @DisplayName("returned collection of strings should equal test collection of strings")
    @Test
    void testGetBookTitles1() {
        ArrayList<String> testBooks = new ArrayList<>();
        testBooks.add("The Pragmatic Programmer\tAndy Hunt\t1999");
        testBooks.add("To Kill A MockingBird\tHarper Lee\t1987");
        testBooks.add("Hamlet\tWilly Boy\t1500");
        assertEquals(testBooks,library.getBookDetails());
    }

    @DisplayName("returned collection of strings should not equal test collection of strings")
    @Test
    void testGetBookTitles2() {
        ArrayList<String> testBooks = new ArrayList<>();
        testBooks.add("To Kill A MockingBird\tHarper Lee\t1987");
        testBooks.add("Hamlet\tWilly Boy\t1500");
        testBooks.add("The Pragmatic Programmer\tAndy Hunt\t1999");
        assertNotEquals(testBooks,library.getBookDetails());
    }

    @DisplayName("expect returned book object to equal test book object")
    @Test
    void testCheckoutBook1() {
        assertEquals(book1,library.checkoutBook("The Pragmatic Programmer"));
    }

    @DisplayName("expect returned book object to not equal test book object")
    @Test
    void testCheckoutBook2() {
        assertNotEquals(book1,library.checkoutBook("Hamlet"));
    }

    @DisplayName("expect returned object to be null")
    @Test
    void testCheckoutBook3() {
        assertNull(library.checkoutBook("Odyssey"));
    }
}
