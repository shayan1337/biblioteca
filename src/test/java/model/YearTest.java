package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class YearTest {

    @DisplayName("expect returned string to equal test string")
    @Test
    void testToString1() {
        assertEquals("1987",new Year(1987).toString());
    }

    @DisplayName("expect returned string to not equal test string")
    @Test
    void testToString2() {
        assertNotEquals("1987",new Year(1957).toString());
    }

    @DisplayName("expect year object to equal year object with same value")
    @Test
    void testEqualsSameValues(){
        assertEquals(new Year(1987), new Year(1987));
    }

    @DisplayName("expect year object to not equal year object with different value")
    @Test
    void testEqualsDifferentValues(){
        assertNotEquals(new Year(1947), new Year(1987));
    }

    @DisplayName("expect string object to not equal year object")
    @Test
    void testEqualsDifferentObjects(){
        assertNotEquals(new Year(1947), "Hello");
    }

    @DisplayName("expect year object to equal itself")
    @Test
    void testEqualsSameObject(){
        Year year = new Year(2018);
        assertEquals(year,year);
    }
}
