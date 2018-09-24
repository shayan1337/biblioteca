package controller.commands;

import common.Message;
import controller.ICommand;
import controller.Session;
import model.ItemType;
import model.Library;
import model.User;
import view.Input;
import view.Output;

public class CheckoutItemsCommand implements ICommand {

    private final ItemType itemType;

    public CheckoutItemsCommand(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public void perform(Library library, Output output, Input input, Session session) {
        User user = session.getUserLoggedIn();
        if (user == null) {
            output.print("Log in first!!!");
            return;
        }

        if (!library.verifyUser(user)) {
            output.print("Wrong credentials!!!");
            return;
        }
        library.checkoutItem(input.getUserInput(), itemType, user);
    }
}
