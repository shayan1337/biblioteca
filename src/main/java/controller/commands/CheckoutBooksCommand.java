package controller.commands;

import common.Message;
import controller.ICommand;
import model.ItemType;
import model.Library;
import view.Input;
import view.Output;

public class CheckoutBooksCommand implements ICommand {
    @Override
    public void perform(Library library, Output output, Input input) {
        output.print(Message.BOOK_CHECKOUT_MESSAGE);
        String bookTitle = input.getUserInput();

        if (library.checkoutItem(bookTitle, ItemType.Book) == null) {
            output.print(Message.UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE);
        } else {
            output.print(Message.SUCCESSFUL_BOOK_CHECKOUT_MESSAGE);
        }
    }
}
