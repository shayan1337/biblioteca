package view;

import java.util.Scanner;

// Represents the input for the user of the application
public class Input {

    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public int getUserInput(){
        return scanner.nextInt();
    }
}
