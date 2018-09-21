package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTest {

    Library library;
    Collection<Book> books = new ArrayList<>();
    Book book1,book2,book3;

    @BeforeEach
    void init() {
        book1 = new Book(new Title("The Pragmatic Programmer"),new Author("Andy Hunt"),new Year(1987));
        book2 = new Book(new Title("To Kill A MockingBird"),new Author("Harper Lee"),new Year(1999));
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
        testBooks.add("The Pragmatic Programmer");
        testBooks.add("To Kill A MockingBird");
        testBooks.add("Hamlet");
        assertEquals(testBooks,library.getBookDetails());
    }

    @DisplayName("returned collection of strings should equal test collection of strings")
    @Test
    void testGetBookTitles2() {
        ArrayList<String> testBooks = new ArrayList<>();
        testBooks.add("To Kill A MockingBird");
        testBooks.add("Hamlet");
        testBooks.add("The Pragmatic Programmer");
        assertNotEquals(testBooks,library.getBookDetails());
    }
}
