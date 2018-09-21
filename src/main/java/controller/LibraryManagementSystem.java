package controller;

import model.Library;
import view.Input;
import view.Output;

import common.Message;

// Represents the controller where it dictates flow of data between model(library) and view(output, input)
public class LibraryManagementSystem {

    private final Output output;
    private final Library library;
    private final Input input;

    public LibraryManagementSystem(Output output, Library library, Input input) {
        this.output = output;
        this.library = library;
        this.input = input;
    }

    public void printBookList() {
        Action.ListBooks.perform(library, output);
    }

    public void printMenu() {
        Action actions[] = Action.values();
        for (int actionIndex = 0; actionIndex < actions.length; actionIndex++) {
            output.print(String.valueOf(actionIndex + 1).concat(".").concat(actions[actionIndex].description));
        }
        printAskForInputFromCustomerMessage();
    }

    private void printAskForInputFromCustomerMessage() {
        output.print(Message.ASK_CUSTOMER_INPUT_MESSAGE);
    }

    public void start() {
        output.print(Message.WELCOME_MESSAGE);
        interactWithUser();
    }

    private boolean isInvalidInput(int userInput) {
        return (userInput-1 < 0 || userInput-1 > Action.values().length-1);
    }

    private void printInvalidChoiceMessage() {
        output.print(Message.INVALID_CHOICE_MESSAGE);
    }

    public void interactWithUser() {
        int userInput;
        do {
            printMenu();
            userInput = input.getUserInput();
            if(isInvalidInput(userInput)) {
                printInvalidChoiceMessage();
                continue;
            }
            Action.values()[userInput - 1].perform(library, output);
        } while (userInput - 1 != Action.valueOf("Quit").ordinal());
    }
}

