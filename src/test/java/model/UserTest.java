package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    Collection<Item> checkedOutItems;
    Item item1, item2;
    User user;

    @BeforeEach
    void setup() {
        user = new User(new Username("sayan"), new Password("sayan"));
        item1 = new Book(new Title("To Kill A MockingBird"), new Person("Harper Lee"), new Year(1987));
        item2 = new Movie(new Title("Interstellar"), new Person("Christopher Nolan"), new Year(2014), new Rating("10"));
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

    @DisplayName("user should be able to checkout a book")
    @Test
    void testCheckoutItem1() {
        User user1 = new User(new Username("sayan"), new Password("sayan"));
        user1.checkoutItem(item1);
        user1.checkoutItem(item2);

        user.checkoutItem(item2);
        user.checkoutItem(item1);

        assertEquals(user, user1);
    }

    @DisplayName("user should be able to checkout a book")
    @Test
    void testCheckoutItem2() {
        User user1 = new User(new Username("sayan"), new Password("sayan"));
        user1.checkoutItem(item1);

        user.checkoutItem(item2);
        user.checkoutItem(item1);

        assertNotEquals(user, user1);
    }

    @DisplayName("user should be able to return an item that they checked out before")
    @Test
    void testReturnItem1() {
        user.checkoutItem(item2);
        user.checkoutItem(item1);
        assertTrue(user.returnItem(item1));
    }

    @DisplayName("user should not be able to return an item that they havent checked out before")
    @Test
    void testReturnItem2() {
        user.checkoutItem(item2);
        user.returnItem(item2);
        assertFalse(user.returnItem(item2));
    }
}
