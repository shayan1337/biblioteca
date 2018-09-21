import controller.LibraryManagementSystem;
import model.*;
import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.Collection;

// The entry point of the  application
public class Biblioteca {

    public static void main(String[] args) {
        Book book1 = new Book(new Title("To Kill A MockingBird"),new Author("Harper Lee"), new Year(1987));
        Book book2 = new Book(new Title("The Pragmatic Programmer"),new Author("Andy Hunt"), new Year(1999));
        Collection<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        Library library = new Library(books);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(new Output(), library, new Input());
        libraryManagementSystem.start();
    }

}