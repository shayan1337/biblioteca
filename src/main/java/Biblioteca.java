import controller.LibraryManagementSystem;
import model.*;
import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.Collection;

// The entry point of the  application
public class Biblioteca {

    public static void main(String[] args) {

        Library library = new Library(getItems());
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(new Output(), library, new Input());
        libraryManagementSystem.start();
    }

    static Collection<Item> getItems() {
        Collection<Item> items = new ArrayList<>();
        Item book1 = new Book(new Title("To Kill A MockingBird"),new Person("Harper Lee"), new Year(1987));
        Item book2 = new Book(new Title("The Pragmatic Programmer"),new Person("Andy Hunt"), new Year(1999));

        Movie movie1 = new Movie(new Title("Interstellar"),new Person("Christopher Nolan"), new Year(2014), new Rating("10"));
        Movie movie2 = new Movie(new Title("Dunkirk"),new Person("Christopher Nolan"), new Year(2017), new Rating("10"));

        items.add(book1);
        items.add(book2);
        items.add(movie1);
        items.add(movie2);
        return items;
    }
}