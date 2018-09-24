package view;

import java.util.Collection;

// Represents the output for the user of the application
public class Output {

    public void print(String message) {
        System.out.println(message);
    }

    public void print(Collection<String> details) {
        for(String bookDetail : details) {
            System.out.println(bookDetail);
        }
        System.out.println();
    }

}