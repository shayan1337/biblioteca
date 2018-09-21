package controller;

import model.Library;
import view.Output;

// Represents menu and the associated functions with it
public enum Action {

    ListBooks("List the books:", 1) {
        @Override
        void perform(Library library, Output output) {
            output.print(library.getBookDetails());
        }
    },

    Quit("Quit.", 2) {
        @Override
        void perform(Library library, Output output) {

        }
    };

    public int number;
    public String description;

    Action(String description, int number) {
        this.description = description;
        this.number = number;
    }

    abstract void perform(Library library, Output output);
}
