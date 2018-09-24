package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    Book book;

    @BeforeEach
    void setup() {
        book = new Book(new Title("Messi"), new Person("Sayan"), new Year(2018));
    }

    @DisplayName("returned string should equal test string")
    @Test
    void testToString() {
        assertEquals("To Kill A MockingBird\tHarper Lee\t1927", new Book(new Title("To Kill A MockingBird"),new Person("Harper Lee"), new Year(1927)).toString());
    }

    @DisplayName("returned string should not equal test string")
    @Test
    void testToString2() {
        assertNotEquals("To Kill Myself", new Book(new Title("The Pragmatic Programmer"),new Person("Harper Lee"), new Year(1999)).toString());
    }

    @DisplayName("expect true for movie that matches the given title string")
    @Test
    void testHasTitle1() {
        assertTrue(book.hasTitle("Messi"));
    }

    @DisplayName("expect true for movie that matches the given title string with different casing")
    @Test
    void testHasTitle2() {
        assertTrue(book.hasTitle("mEsSI"));
    }

    @DisplayName("expect false for movie that does not match the given title string")
    @Test
    void testHasTitle3() {
        assertFalse(book.hasTitle("Messi is the best"));
    }

    @DisplayName("expect movie object to equal itself")
    @Test
    void testEqualsOnItself() {
        assertEquals(book, book);
    }

    @DisplayName("expect movie object to not equal another object of different type")
    @Test
    void testEqualsOnDifferentTypeObjects() {
        assertNotEquals(book,"hello");
    }

    @DisplayName("expect movie object to equal movie object with equal values")
    @Test
    void testEqualsOnEqualValues() {
        assertEquals(book,new Book(new Title("Messi"), new Person("Sayan"), new Year(2018)));
    }

    @DisplayName("expect movie object to not equal movie object with unequal values")
    @Test
    void testEqualsOnUnEqualValues() {
        assertNotEquals(book,new Book(new Title("Messi"), new Person("Sayan"), new Year(1892)));
    }

    @DisplayName("should return a collection of strings")
    @Test
    void testGetdetails1() {
        Collection<String> details = Arrays.asList("Messi","Sayan","2018");
        assertEquals(book.getDetails(), details);
    }

    @DisplayName("should return a collection of strings")
    @Test
    void testGetdetails2() {
        Collection<String> details = Arrays.asList("Messi","Sayan","1234");
        assertNotEquals(book.getDetails(), details);
    }
}
