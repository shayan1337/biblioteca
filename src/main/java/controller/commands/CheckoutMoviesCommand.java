package controller.commands;

import common.Message;
import controller.ICommand;
import model.ItemType;
import model.Library;
import view.Input;
import view.Output;

public class CheckoutMoviesCommand implements ICommand {

    @Override
    public void perform(Library library, Output output, Input input) {
        output.print(Message.MOVIE_CHECKOUT_MESSAGE);
        String bookTitle = input.getUserInput();

        if (library.checkoutItem(bookTitle, ItemType.Movie) == null) {
            output.print(Message.UNSUCCESSFUL_MOVIE_CHECKOUT_MESSAGE);
        } else {
            output.print(Message.SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE);
        }
    }
}
