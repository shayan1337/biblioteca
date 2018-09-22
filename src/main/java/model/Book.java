package model;

import java.util.Objects;

// Represents a book with its title, author, and year of publication
public class Book {

    private final Title title;
    private final Author author;
    private final Year yearOfPublication;

    public Book(Title title, Author author, Year yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    boolean hasTitle(String bookTitle) {
        return title.toString().equalsIgnoreCase(bookTitle);
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
