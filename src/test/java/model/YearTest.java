package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YearTest {

    @DisplayName("expect returned string to equal test string")
    @Test
    void testToString() {
        assertEquals("1987",new Year(1987).toString());
    }
}
