package controller;

import common.Message;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

// Dont know how to test if print method is called on output inside start()
public class LibraryManagementSystemTest {

    Library library;
    Book book1, book2;
    LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    void setup() {
        book1 = new Book(new Title("To Kill A MockingBird"),new Author("Harper Lee"), new Year(1987));
        book2 = new Book(new Title("The Pragmatic Programmer"),new Author("Andy Hunt"), new Year(1999));
    }

    @DisplayName("verify if the application is quitting on entering 2")
    @Test
    void testPrint1() {
        Output output = mock(Output.class);
        Input input = mock(Input.class);
        library = new Library(Arrays.asList(book1,book2));
        libraryManagementSystem = new LibraryManagementSystem(output, library, input);
        when(input.getUserInput()).thenReturn(2);
        libraryManagementSystem.start();
    }

    @DisplayName("verify if the print method printing the books titles in Output class is being called")
    @Test
    void testPrintBookDetails() {
        Collection<String> bookTitles = new ArrayList<>();
        bookTitles.add("To Kill A MockingBird\tHarper Lee\t1987");
        library = new Library(Arrays.asList(book1));
        Output output = mock(Output.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, library, new Input());
        libraryManagementSystem.printBookList();
        verify(output).print(bookTitles);
    }

    @DisplayName("verify if the print method printing the books titles in Output class is being called")
    @Test
    void testPrintMenu() {
        library = new Library(Arrays.asList(book1,book2));
        Output output = mock(Output.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, library, new Input());
        libraryManagementSystem.printMenu();
        verify(output, times(1)).print("1.List the books:");
    }

    @DisplayName("expect function to return ListBooks action type")
    @Test
    void testGetActionFor_1() {
        library = new Library(Arrays.asList(book1,book2));
        libraryManagementSystem = new LibraryManagementSystem(new Output(), library, new Input());
        assertEquals(Action.ListBooks,libraryManagementSystem.getActionForUserInput(1));
    }

    @DisplayName("expect function to return Quit action type")
    @Test
    void testGetActionFor_2() {
        library = new Library(Arrays.asList(book1,book2));
        libraryManagementSystem = new LibraryManagementSystem(new Output(), library, new Input());
        assertEquals(Action.Quit,libraryManagementSystem.getActionForUserInput(2));
    }

    @DisplayName("expect function to return null")
    @Test
    void testGetActionFor_10() {
        library = new Library(Arrays.asList(book1,book2));
        libraryManagementSystem = new LibraryManagementSystem(new Output(), library, new Input());
        assertNull(libraryManagementSystem.getActionForUserInput(10));
    }
}

