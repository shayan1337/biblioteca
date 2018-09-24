package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    Library library;
    Collection<Item> items = new ArrayList<>();
    Book book1, book2, book3;
    Movie movie1, movie2, movie3;

    @BeforeEach
    void init() {
        book1 = new Book(new Title("The Pragmatic Programmer"),new Person("Andy Hunt"),new Year(1999));
        book2 = new Book(new Title("To Kill A MockingBird"),new Person("Harper Lee"),new Year(1987));
        book3 = new Book(new Title("Hamlet"),new Person("Willy Boy"),new Year(1500));

        movie1 = new Movie(new Title("Interstellar"), new Person("Christopher Nolan"), new Year(2014), new Rating("10"));
        movie2 = new Movie(new Title("Dunkirk"), new Person("Christopher Nolan"), new Year(2017), new Rating("10"));
        movie3 = new Movie(new Title("The Prestige"), new Person("Christopher Nolan"), new Year(2005), new Rating("10"));

        items.add(book1);
        items.add(book2);
        items.add(book3);

        items.add(movie1);
        items.add(movie2);
        items.add(movie3);

        library = new Library(items);
    }

    @DisplayName("returned collection of book details should equal test collection of book details")
    @Test
    void testGetBookTitles1() {
        ArrayList<String> testBooks = new ArrayList<>();
        testBooks.add("The Pragmatic Programmer\tAndy Hunt\t1999");
        testBooks.add("To Kill A MockingBird\tHarper Lee\t1987");
        testBooks.add("Hamlet\tWilly Boy\t1500");
        assertEquals(testBooks,library.getDetails(ItemType.Book));
    }

    @DisplayName("returned collection of book details should not equal test collection of book details")
    @Test
    void testGetBookTitles2() {
        ArrayList<String> testBooks = new ArrayList<>();
        testBooks.add("To Kill A MockingBird\tHarper Lee\t1987");
        testBooks.add("Hamlet\tWilly Boy\t1500");
        testBooks.add("The Pragmatic Programmer\tAndy Hunt\t1999");
        assertNotEquals(testBooks,library.getDetails(ItemType.Book));
    }

    @DisplayName("should be able to checkout books from library")
    @Test
    void testCheckoutBook1() {
        assertEquals(book1,library.checkoutItem("The Pragmatic Programmer", ItemType.Book));
    }

    @DisplayName("the library should not checkout any book other than what the customer wants")
    @Test
    void testCheckoutBook2() {
        assertNotEquals(book1,library.checkoutItem("Hamlet",ItemType.Book));
    }

    @DisplayName("the customer cannot checkout a book that does not exist in the library")
    @Test
    void testCheckoutBook3() {
        assertNull(library.checkoutItem("Odyssey", ItemType.Book));
    }

    @DisplayName("should be able to return a movie that was checked out")
    @Test
    void testReturnBook1() {
        library.checkoutItem("Hamlet", ItemType.Book);
        assertTrue(library.returnItem("Hamlet",ItemType.Book));
    }

    @DisplayName("should not be able to return a book that does not belong to the library")
    @Test
    void testReturnBook2() {
        assertFalse(library.returnItem("Odyssey", ItemType.Book));
    }

    @DisplayName("should not be able to return a movie was not checked out in the first place")
    @Test
    void testReturnBook3() {
        assertFalse(library.returnItem("Hamlet", ItemType.Book));
    }

    // -------------------------------------------------------------------------------------------------------------------

    @DisplayName("should be able to checkout movie from library")
    @Test
    void testCheckoutMovie1() {
        assertEquals(movie1,library.checkoutItem("Interstellar", ItemType.Movie));
    }

    @DisplayName("the library should not checkout any movie other than what the customer wants")
    @Test
    void testCheckoutMovie2() {
        assertNotEquals(book1,library.checkoutItem("Dunkirk",ItemType.Movie));
    }

    @DisplayName("the customer cannot checkout a movie that does not exist in the library")
    @Test
    void testCheckoutMovie3() {
        assertNull(library.checkoutItem("The Hangover", ItemType.Movie));
    }

    @DisplayName("should be able to return a movie that was checked out")
    @Test
    void testReturnMovie1() {
        library.checkoutItem("Dunkirk", ItemType.Movie);
        assertTrue(library.returnItem("Dunkirk",ItemType.Movie));
    }

    @DisplayName("should not be able to return a movie that does not belong to the library")
    @Test
    void testReturnMovie2() {
        assertFalse(library.returnItem("Othello", ItemType.Movie));
    }

    @DisplayName("should not be able to return a movie was not checked out in the first place")
    @Test
    void testReturnMovie3() {
        assertFalse(library.returnItem("Dunkirk", ItemType.Book));
    }
}
