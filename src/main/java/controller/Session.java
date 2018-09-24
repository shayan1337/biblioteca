package controller;

import model.User;

import java.util.Objects;

public class Session {

    private final User userLoggedIn;

    public Session() {
        userLoggedIn = null;
    }

    public Session(User userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }

    public boolean isLoggedIn() {
        return !(userLoggedIn == null);
    }

    public User getUserLoggedIn() {
        return userLoggedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(userLoggedIn, session.userLoggedIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLoggedIn);
    }
}
