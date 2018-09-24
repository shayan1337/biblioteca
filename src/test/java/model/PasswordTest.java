package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PasswordTest {

    Password password;
    @BeforeEach
    void setup() {
        password = new Password("sayan");
    }

    @DisplayName("should return the string equivalent of the username")
    @Test
    void testToString1() {
        assertEquals("sayan", password.toString());
    }

    @DisplayName("should not return anything other than the string equivalent of the username")
    @Test
    void testToString2() {
        assertNotEquals("hello", password.toString());
    }

    @DisplayName("expect the object to equal itself")
    @Test
    void testEqualsOnItself() {
        assertEquals(password,password);
    }

    @DisplayName("expect the object to not equal null")
    @Test
    void testEqualsOnNull() {
        assertNotEquals(password,null);
    }

    @DisplayName("expect objects of different type to not equal itself")
    @Test
    void testEqualsOnDifferentTypes() {
        assertNotEquals(password,"Hello");
    }

    @DisplayName("expect objects of same type and equal values to equal itself")
    @Test
    void testEqualsOnSameTypeAndEqualValues() {
        assertEquals(password,new Password("sayan"));
    }

    @DisplayName("expect the object to equal itself")
    @Test
    void testEqualsOnSameTypeAndUnequalValues() {
        assertNotEquals(password,new Password("messi"));
    }
}
