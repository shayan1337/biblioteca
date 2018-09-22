package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    Book book;

    @BeforeEach
    void setup() {
        book = new Book(new Title("Messi"), new Author("Sayan"), new Year(2018));
    }

    @DisplayName("returned string should equal test string")
    @Test
    void testToString() {
        assertEquals("To Kill A MockingBird\tHarper Lee\t1927", new Book(new Title("To Kill A MockingBird"),new Author("Harper Lee"), new Year(1927)).toString());
    }

    @DisplayName("returned string should not equal test string")
    @Test
    void testToString2() {
        assertNotEquals("To Kill Myself", new Book(new Title("The Pragmatic Programmer"),new Author("Harper Lee"), new Year(1999)).toString());
    }

    @DisplayName("expect true for book that matches the given title string")
    @Test
    void testHasTitle1() {
        assertTrue(book.hasTitle("Messi"));
    }

    @DisplayName("expect true for book that matches the given title string with different casing")
    @Test
    void testHasTitle2() {
        assertTrue(book.hasTitle("mEsSI"));
    }

    @DisplayName("expect false for book that does not match the given title string")
    @Test
    void testHasTitle3() {
        assertFalse(book.hasTitle("Messi is the best"));
    }

    @DisplayName("expect book object to equal itself")
    @Test
    void testEqualsOnItself() {
        assertEquals(book,book);
    }

    @DisplayName("expect book object to not equal another object of different type")
    @Test
    void testEqualsOnDifferentTypeObjects() {
        assertNotEquals(book,"hello");
    }

    @DisplayName("expect book object to equal book object with equal values")
    @Test
    void testEqualsOnEqualValues() {
        assertEquals(book,new Book(new Title("Messi"), new Author("Sayan"), new Year(2018)));
    }

    @DisplayName("expect book object to not equal book object with unequal values")
    @Test
    void testEqualsOnUnEqualValues() {
        assertNotEquals(book,new Book(new Title("Messi"), new Author("Sayan"), new Year(1892)));
    }
}
