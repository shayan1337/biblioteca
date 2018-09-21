package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BookTest {

    @DisplayName("returned string should equal test string")
    @Test
    void testToString() {
        assertEquals("To Kill A MockingBird\tHarper Lee", new Book(new Title("To Kill A MockingBird"),new Author("Harper Lee"), new Year(1927)).toString());
    }

    @DisplayName("returned string should not equal test string")
    @Test
    void testToString2() {
        assertNotEquals("To Kill Myself", new Book(new Title("The Pragmatic Programmer"),new Author("Harper Lee"), new Year(1999)).toString());
    }
}
