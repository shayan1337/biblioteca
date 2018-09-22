package controller.commands;

import common.Message;
import controller.ICommand;
import model.Library;
import view.Input;
import view.Output;

public class CheckoutBooksCommand implements ICommand {
    @Override
    public void perform(Library library, Output output, Input input) {
        output.print(Message.BOOK_CHECKOUT_MESSAGE);
        String bookTitle = input.getUserInput();

        if (library.checkoutBook(bookTitle) == null) {
            output.print(Message.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        } else {
            output.print(Message.SUCCESSFUL_CHECKOUT_MESSAGE);
        }
    }
}
