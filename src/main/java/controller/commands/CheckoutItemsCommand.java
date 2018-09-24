package controller.commands;

import common.Message;
import controller.ICommand;
import model.ItemType;
import model.Library;
import view.Input;
import view.Output;

public class CheckoutItemsCommand implements ICommand {

    private final ItemType itemType;

    public CheckoutItemsCommand(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public void perform(Library library, Output output, Input input) {
        output.print(Message.ITEM_CHECKOUT_MESSAGE);
        if (library.checkoutItem(input.getUserInput(), itemType) == null) {
            output.print(Message.UNSUCCESSFUL_ITEM_CHECKOUT_MESSAGE);
        } else {
            output.print(Message.SUCCESSFUL_ITEM_CHECKOUT_MESSAGE);
        }
    }
}
