package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UsernameTest {

    Username username;
    @BeforeEach
    void setup() {
        username = new Username("sayan");
    }

    @DisplayName("should return the string equivalent of the username")
    @Test
    void testToString1() {
        assertEquals("sayan", username.toString());
    }

    @DisplayName("should not return anything other than the string equivalent of the username")
    @Test
    void testToString2() {
        assertNotEquals("hello", username.toString());
    }

    @DisplayName("expect the object to equal itself")
    @Test
    void testEqualsOnItself() {
        assertEquals(username,username);
    }

    @DisplayName("expect the object to not equal null")
    @Test
    void testEqualsOnNull() {
        assertNotEquals(username,null);
    }

    @DisplayName("expect objects of different type to not equal itself")
    @Test
    void testEqualsOnDifferentTypes() {
        assertNotEquals(username,"Hello");
    }

    @DisplayName("expect objects of same type and equal values to equal itself")
    @Test
    void testEqualsOnSameTypeAndEqualValues() {
        assertEquals(username,new Username("sayan"));
    }

    @DisplayName("expect the object to equal itself")
    @Test
    void testEqualsOnSameTypeAndUnequalValues() {
        assertNotEquals(username,new Username("messi"));
    }
}
