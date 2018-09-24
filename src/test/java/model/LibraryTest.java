package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    Library library;
    User user1, user2;
    Collection<Item> items = new ArrayList<>();
    Collection<User> users = new ArrayList<>();
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

        user1 = new User(new Username("sayan"), new Password("sayan"));
        user2 = new User(new Username("messi"), new Password("messi"));

        items.add(book1);
        items.add(book2);
        items.add(book3);

        items.add(movie1);
        items.add(movie2);
        items.add(movie3);

        users.add(user1);
        users.add(user2);

        library = new Library(items,users);
    }

    @DisplayName("returned collection of book details should equal test collection of book details")
    @Test
    void testGetBookTitles1() {
        Collection<String> testBooks = new ArrayList<>();
        testBooks.add("The Pragmatic Programmer\tAndy Hunt\t1999");
        testBooks.add("To Kill A MockingBird\tHarper Lee\t1987");
        testBooks.add("Hamlet\tWilly Boy\t1500");
        assertEquals(testBooks,library.getDetails(ItemType.Book));
    }

    @DisplayName("returned collection of book details should not equal test collection of book details")
    @Test
    void testGetBookTitles2() {
        Collection<String> testBooks = new HashSet<>();
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

    @DisplayName("verify if the user has the correct credentials")
    @Test
    void testVerifyUser1() {
        User userToBeVerified = new User(new Username("sayan"), new Password("sayan"));
        assertTrue(library.verifyUser(userToBeVerified));
    }

    @DisplayName("verify if the user has the correct credentials")
    @Test
    void testVerifyUser2() {
        User userToBeVerified = new User(new Username("username"), new Password("password"));
        assertFalse(library.verifyUser(userToBeVerified));
    }
}
