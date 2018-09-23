package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    Item item;

    @BeforeEach
    void setup() {
        item = new Item(new Title("Messi"), new Person("Sayan"), new Year(2018));
    }

    @DisplayName("returned string should equal test string")
    @Test
    void testToString() {
        assertEquals("To Kill A MockingBird\tHarper Lee\t1927", new Item(new Title("To Kill A MockingBird"),new Person("Harper Lee"), new Year(1927)).toString());
    }

    @DisplayName("returned string should not equal test string")
    @Test
    void testToString2() {
        assertNotEquals("To Kill Myself", new Item(new Title("The Pragmatic Programmer"),new Person("Harper Lee"), new Year(1999)).toString());
    }

    @DisplayName("expect true for movie that matches the given title string")
    @Test
    void testHasTitle1() {
        assertTrue(item.hasTitle("Messi"));
    }

    @DisplayName("expect true for movie that matches the given title string with different casing")
    @Test
    void testHasTitle2() {
        assertTrue(item.hasTitle("mEsSI"));
    }

    @DisplayName("expect false for movie that does not match the given title string")
    @Test
    void testHasTitle3() {
        assertFalse(item.hasTitle("Messi is the best"));
    }

    @DisplayName("expect movie object to equal itself")
    @Test
    void testEqualsOnItself() {
        assertEquals(item, item);
    }

    @DisplayName("expect movie object to not equal another object of different type")
    @Test
    void testEqualsOnDifferentTypeObjects() {
        assertNotEquals(item,"hello");
    }

    @DisplayName("expect movie object to equal movie object with equal values")
    @Test
    void testEqualsOnEqualValues() {
        assertEquals(item,new Item(new Title("Messi"), new Person("Sayan"), new Year(2018)));
    }

    @DisplayName("expect movie object to not equal movie object with unequal values")
    @Test
    void testEqualsOnUnEqualValues() {
        assertNotEquals(item,new Item(new Title("Messi"), new Person("Sayan"), new Year(1892)));
    }
}
