package controller.commands;

import common.Message;
import controller.ICommand;
import controller.Session;
import model.ItemType;
import model.Library;
import view.Input;
import view.Output;

public class ReturnItemsCommand implements ICommand {

    private final ItemType itemType;

    public ReturnItemsCommand(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public void perform(Library library, Output output, Input input, Session session) {
        output.print(Message.ITEM_RETURN_MESSAGE);
        if (library.returnItem(input.getUserInput(), itemType)) {
            output.print(Message.SUCCESSFUL_ITEM_RETURN_MESSAGE);
        } else {
            output.print(Message.UNSUCCESSFUL_ITEM_RETURN_MESSAGE);
        }
    }
}
