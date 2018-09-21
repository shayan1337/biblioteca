package model;

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

    @Override
    public String toString() {
        return title.toString() + "\t" + author.toString() + "\t" + yearOfPublication.toString();
    }
}
