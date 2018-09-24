package controller;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.Input;
import view.Output;

import java.util.Arrays;
import static org.mockito.Mockito.*;

// Dont know how to test if print method is called on output inside start()
public class LibraryManagementSystemTest {

    Library library;
    Book book1, book2;
    LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    void setup() {
        book1 = new Book(new Title("To Kill A MockingBird"),new Person("Harper Lee"), new Year(1987));
        book2 = new Book(new Title("The Pragmatic Programmer"),new Person("Andy Hunt"), new Year(1999));
    }

    @DisplayName("verify if the application is quitting on entering 3")
    @Test
    void testPrint1() {
        Output output = mock(Output.class);
        Input input = mock(Input.class);
        library = new Library(Arrays.asList(book1, book2));
        libraryManagementSystem = new LibraryManagementSystem(output, library, input);
        when(input.getUserInput()).thenReturn("4");
        libraryManagementSystem.start();
    }

    @DisplayName("verify if the print method printing the books titles in Output class is being called")
    @Test
    void testPrintMenu() {
        library = new Library(Arrays.asList(book1, book2));
        Output output = mock(Output.class);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(output, library, new Input());
        libraryManagementSystem.printMenu();
        verify(output, times(1)).print("1.List the books");
        verify(output, times(1)).print("2.CheckoutBooks books");
        verify(output, times(1)).print("3.ReturnBooks books");
        verify(output, times(1)).print("4.Quit");
    }
}

