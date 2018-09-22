package controller;

import controller.commands.CheckoutBooksCommand;
import controller.commands.ListBooksCommand;
import controller.commands.QuitCommand;
import controller.commands.ReturnBookCommand;
import model.Library;
import view.Input;
import view.Output;

// Represents menu and the associated functions with it
public enum Action {

    ListBooks("List the books", new ListBooksCommand()),

    Checkout("Checkout books", new CheckoutBooksCommand()) ,

    Return("Return books", new ReturnBookCommand()),

    Quit("Quit", new QuitCommand());

    private String description;
    private ICommand action;

    Action(String description, ICommand action) {
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void perform(Library library, Output output, Input input){
        action.perform(library, output, input);
    }
}
