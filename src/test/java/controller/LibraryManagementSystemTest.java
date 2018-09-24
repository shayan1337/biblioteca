package controller;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.Output;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.*;

// Dont know how to test if print method is called on output inside start()
public class LibraryManagementSystemTest {

    Library library;
    Book book1, book2;
    LibraryManagementSystem libraryManagementSystem;
    Collection<User> users;
    Collection<Item> items;
    User user1, user2;

    @BeforeEach
    void setup() {
        book1 = new Book(new Title("To Kill A MockingBird"),new Person("Harper Lee"), new Year(1987));
        book2 = new Book(new Title("The Pragmatic Programmer"),new Person("Andy Hunt"), new Year(1999));

        items = new HashSet<>(Arrays.asList(book1,book2));

        user1 = new User(new Username("sayan"), new Password("sayan"));
        user2 = new User(new Username("messi"), new Password("messi"));

        users = new HashSet<>(Arrays.asList(user1,user2));
    }

    @DisplayName("verify if the application is quitting on entering 7")
    @Test
    void testPrint1() {
        Output output = mock(Output.class);
        Input input = mock(Input.class);
        library = new Library(items,users);
        libraryManagementSystem = new LibraryManagementSystem(output, library, input);
        when(input.getUserInput()).thenReturn("7");
        libraryManagementSystem.start();
    }

    @DisplayName("verify if the print method printing the menu works")
    @Test
    void testPrintMenu() {
        library = new Library(items,users);
        Output output = mock(Output.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, library, new Input());
        libraryManagementSystem.printMenu();
        verify(output, times(1)).print("1.List the books");
        verify(output, times(1)).print("2.List the movies");
        verify(output, times(1)).print("3.Checkout books");
        verify(output, times(1)).print("4.Checkout movies");
        verify(output, times(1)).print("5.Return books");
        verify(output, times(1)).print("6.Return movies");
        verify(output, times(1)).print("7.Quit");
    }
}

