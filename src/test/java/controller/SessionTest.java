package controller;

import model.Password;
import model.User;
import model.Username;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SessionTest {

    User user1, user2;

    @BeforeEach
    void setup() {
        user1 = new User(new Username("sayan"), new Password("sayan"));
        user2 = new User(new Username("messi"), new Password("messi"));
    }

    @DisplayName("session should not have a user in it")
    @Test
    void testIsLoggedIn1() {
        assertFalse(new Session().isLoggedIn());
    }

    @DisplayName("session should have a user in it")
    @Test
    void testIsLoggedIn2() {
        User user = new User(new Username("sayan"), new Password("sayan"));
        assertTrue(new Session(user).isLoggedIn());
    }

    @DisplayName("expect session to equal itself")
    @Test
    void testEqualsOnSameUser() {
        Session session = new Session(user1);
        assertEquals(session,session);
    }

    @DisplayName("expect session with different users to not equal each other")
    @Test
    void testEqualsOnDifferentSession() {
        assertNotEquals(new Session(user1), new Session(user2));
    }

    @DisplayName("expect sessions with no user in it to equal each other")
    @Test
    void testEqualsOnNull() {
        assertEquals(new Session(), new Session());
    }

    @DisplayName("expect sessions with same users to equal each other")
    @Test
    void testEqualsOnSameValues() {
        assertEquals(new Session(user1),new Session(user1));
    }
}
