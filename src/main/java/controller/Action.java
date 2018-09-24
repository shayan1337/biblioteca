package controller;

import controller.commands.*;
import model.ItemType;
import model.Library;
import view.Input;
import view.Output;

// Represents menu and the associated functions with it
public enum Action {

    ListBooks("List the books", new ListItemsCommand(ItemType.Book)),

    ListMovies("List the movies", new ListItemsCommand(ItemType.Movie)),

    CheckoutBooks("Checkout books", new CheckoutItemsCommand(ItemType.Book)),

    CheckoutMovies("Checkout movies", new CheckoutItemsCommand(ItemType.Movie)),

    ReturnBooks("Return books", new ReturnItemsCommand(ItemType.Book)),

    ReturnMovies("Return movies", new ReturnItemsCommand(ItemType.Movie)),

    Login("Login", new LoginCommand()),

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

    public void perform(Library library, Output output, Input input, Session session){
        action.perform(library, output, input, session);
    }
}
