package controller;

import controller.commands.*;
import model.Library;
import view.Input;
import view.Output;

// Represents menu and the associated functions with it
public enum Action {

    ListBooks("List the books", new ListBooksCommand()),

    ListMovies("List the movies", new ListMoviesCommand()),

    CheckoutBooks("Checkout books", new CheckoutBooksCommand()),

    CheckoutMovies("Checkout movies", new CheckoutMoviesCommand()),

    ReturnBooks("Return books", new ReturnBookCommand()),

    ReturnMovies("Return movies", new ReturnMoviesCommand()),

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
