package controller.commands;

import controller.ICommand;
import model.ItemType;
import model.Library;
import view.Input;
import view.Output;

public class ListItemsCommand implements ICommand {

    private final ItemType itemType;

    public ListItemsCommand(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public void perform(Library library, Output output, Input input) {
        output.print("The list is :");
        output.print(library.getDetails(itemType));
    }
}
