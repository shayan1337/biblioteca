package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

// Represents a library item with title, author, and yearOfPublication
public class Book implements Item {

    private final Title title;
    private final Person author;
    private final Year yearOfPublication;
    private final ItemType itemType;

    public Book(Title title, Person author, Year yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.itemType = ItemType.Book;
    }

    public Collection<String> getDetails() {
        Collection<String> details = new ArrayList<>();
        Collections.addAll(details, toString().split("\t"));
        return details;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public boolean hasTitle(String title) {
        return this.title.toString().equalsIgnoreCase(title);
    }

    @Override
    public String toString() {
        return title.toString() + "\t" + author.toString() + "\t" + yearOfPublication.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(yearOfPublication, book.yearOfPublication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, yearOfPublication);
    }
}
