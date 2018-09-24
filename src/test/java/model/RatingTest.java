package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RatingTest {

    @DisplayName("toString() function should return the rating of the movie")
    @Test
    void testToString1() {
        assertEquals(new Rating("10").toString(),"10");
    }

    @DisplayName("toString() function should return the rating of the movie")
    @Test
    void testToString2() {
        assertNotEquals(new Rating("1").toString(),"10");
    }
}
