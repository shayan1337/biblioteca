package controller.commands;

import controller.ICommand;
import model.Library;
import view.Input;
import view.Output;

public class ListBooksCommand implements ICommand {
    @Override
    public void perform(Library library, Output output, Input input) {
        output.print(library.getBookDetails());
    }
}
