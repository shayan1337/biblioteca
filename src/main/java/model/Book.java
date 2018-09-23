package model;

import java.util.Objects;

// Represents a library item with title, person, and year
public class Item {

    private final Title title;
    private final Person person;
    private final Year year;

    public Item(Title title, Person person, Year year) {
        this.title = title;
        this.person = person;
        this.year = year;
    }

    boolean hasTitle(String title) {
        return this.title.toString().equalsIgnoreCase(title);
    }

    @Override
    public String toString() {
        return title.toString() + "\t" + person.toString() + "\t" + year.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(title, item.title) &&
                Objects.equals(person, item.person) &&
                Objects.equals(year, item.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, person, year);
    }
}
