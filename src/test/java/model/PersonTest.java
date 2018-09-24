package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersonTest {

    @DisplayName("returned string should be equal to expected string")
    @Test
    void testToString1() {
        assertEquals("Harper Lee", new Person("Harper Lee").toString());
    }

    @DisplayName("returned string should not be equal to expected string")
    @Test
    void testToString2() {
        assertNotEquals("Harper Lee", new Person("Stan Lee").toString());
    }

    @DisplayName("expect two author objects with same values to equal each other")
    @Test
    void testEqualsSameValues() {
        assertEquals(new Person("Hello"), new Person("Hello"));
    }

    @DisplayName("expect two author objects with different values to not equal each other")
    @Test
    void testEqualsDifferentValues() {
        assertNotEquals(new Person("Hello"), new Person("Hello World"));
    }

    @DisplayName("expect objects of different type to not equal each other")
    @Test
    void testEqualsDifferentObjects() {
        assertNotEquals(new Person("Hello"), "Hello");
    }

    @DisplayName("expect title object to equal itself")
    @Test
    void testEqualsOnItself() {
        Person person = new Person("Hello");
        assertEquals(person, person);
    }
}
