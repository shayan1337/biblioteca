package model;

import java.util.Objects;

public class Rating {

    private final String value;

    public Rating(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Objects.equals(value, rating.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
