package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TitleTest {

    @DisplayName("returned string should equal test string")
    @Test
    void testToString1() {
        assertEquals("To Kill A MockingBird", new Title("To Kill A MockingBird").toString());
    }

    @DisplayName("returned string should not equal test string")
    @Test
    void testToString2() {
        assertNotEquals("To Kill A MockingBird" , new Title("The Pragmatic Programmer").toString());
    }

    @DisplayName("expect two title objects with same values to equal each other")
    @Test
    void testEqualsSameValues() {
        assertEquals(new Title("Hello"), new Title("Hello"));
    }

    @DisplayName("expect two title objects with different values to not equal each other")
    @Test
    void testEqualsDifferentValues() {
        assertNotEquals(new Title("Hello"), new Title("Hello World"));
    }

    @DisplayName("expect objects of different type to not equal each other")
    @Test
    void testEqualsDifferentObjects() {
        assertNotEquals(new Title("Hello"), "Hello");
    }

    @DisplayName("expect title object to equal itself")
    @Test
    void testEqualsOnItself() {
        Title title = new Title("Hello");
        assertEquals(title,title);
    }
}
