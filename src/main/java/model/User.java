package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class User {

    private final Username username;
    private final Password password;
    private Collection<Item> checkedOutItems;


    public User(Username username, Password password) {
        this.username = username;
        this.password = password;
        checkedOutItems = new HashSet<>();
    }

    void checkoutItem(Item item) {
        if(item != null) {
            checkedOutItems.add(item);
        }
    }

    boolean returnItem(Item item) {
        if(!checkedOutItems.contains(item)) {
            return false;
        }
        checkedOutItems.remove(item);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(checkedOutItems, user.checkedOutItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, checkedOutItems);
    }
}
