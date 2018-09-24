package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    Collection<Item> checkedOutItems;
    User user;

    @BeforeEach
    void setup() {
        user = new User(new Username("sayan"), new Password("sayan"));
    }


    @DisplayName("expect the user object to equal itself")
    @Test
    void testEqualsOnItself() {
        assertEquals(user,user);
    }

    @DisplayName("expect object to not equal null")
    @Test
    void testEqualsOnNull() {
        assertNotNull(user);
    }

    @DisplayName("expect objects of different types to not equal each other")
    @Test
    void testEqualsOnDifferentTypes() {
        assertNotEquals(user,"Hello");
    }

    @DisplayName("expect objects of same types and unequal values to not equal each other")
    @Test
    void testEqualsOnSameTypeAndUnequalValues() {
        assertNotEquals(user,new User(new Username("messi"), new Password("messi")));
    }

    @DisplayName("expect objects of same types and equal values to equal each other")
    @Test
    void testEqualsOnSameTypeAndEqualValues() {
        assertEquals(user,new User(new Username("sayan"),new Password("sayan")));
    }
}
