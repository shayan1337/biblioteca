package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MovieTest {

    Movie movie;

    @BeforeEach
    void setup() {
        movie = new Movie(new Title("Interstellar"), new Person("Christopher Nolan"), new Year(2014), new Rating("10"));
    }

    @DisplayName("returned string should equal test string")
    @Test
    void testToString() {
        assertEquals("Interstellar\tChristopher Nolan\t2014\t10", new Movie(new Title("Interstellar"),new Person("Christopher Nolan"), new Year(2014), new Rating("10")).toString());
    }

    @DisplayName("returned string should not equal test string")
    @Test
    void testToString2() {
        assertNotEquals("Interstellar", new Movie(new Title("The Pragmatic Programmer"),new Person("Harper Lee"), new Year(1999), new Rating("7")).toString());
    }

    @DisplayName("expect objects with unequal values to not equal each other")
    @Test
    void testEqualsDifferentValues() {
        assertNotEquals(movie, new Movie(new Title("Batman Begins"), new Person("Christopher Nolan"), new Year(2005), new Rating("10")));
    }

    @DisplayName("expect objects with equal values to equal each other")
    @Test
    void testEqualsSameValues() {
        assertEquals(movie, new Movie(new Title("Interstellar"), new Person("Christopher Nolan"), new Year(2014), new Rating("10")));
    }

    @DisplayName("expect objects of different types to not equal each other")
    @Test
    void testEqualsOfDifferentTypes() {
        assertNotEquals(movie,"hello");
    }

    @DisplayName("expect the same object to equal itself")
    @Test
    void testEqualsOnSameObject() {
        assertEquals(movie,movie);
    }

    @DisplayName("should return a collection of strings")
    @Test
    void testGetdetails1() {
        Collection<String> details = Arrays.asList("Interstellar","Christopher Nolan","2014","10");
        assertEquals(movie.getDetails(), details);
    }

    @DisplayName("should return a collection of strings")
    @Test
    void testGetdetails2() {
        Collection<String> details = Arrays.asList("Messi","Sayan","1234");
        assertNotEquals(movie.getDetails(), details);
    }
}
