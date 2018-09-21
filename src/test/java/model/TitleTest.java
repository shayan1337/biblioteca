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
}
