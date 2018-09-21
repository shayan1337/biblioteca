package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AuthorTest {

    @DisplayName("returned string should be equal to expected string")
    @Test
    void testToString1() {
        assertEquals("Harper Lee", new Author("Harper Lee").toString());
    }

    @DisplayName("returned string should not be equal to expected string")
    @Test
    void testToString2() {
        assertNotEquals("Harper Lee", new Author("Stan Lee").toString());
    }
}
