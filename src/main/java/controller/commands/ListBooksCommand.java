package controller.commands;

import controller.ICommand;
import model.ItemType;
import model.Library;
import view.Input;
import view.Output;

public class ListBooksCommand implements ICommand {
    @Override
    public void perform(Library library, Output output, Input input) {
        output.print("The list of books are:");
        output.print(library.getDetails(ItemType.Book));
    }
}
