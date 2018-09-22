package controller.commands;

import common.Message;
import controller.ICommand;
import model.Library;
import view.Input;
import view.Output;

public class ReturnBookCommand implements ICommand {

    @Override
    public void perform(Library library, Output output, Input input) {
        output.print(Message.BOOK_RETURN_MESSAGE);
        if (library.returnBook(input.getUserInput())) {
            output.print(Message.SUCCESSFUL_BOOK_RETURN_MESSAGE);
        } else {
            output.print(Message.UNSUCCESSFUL_BOOK_RETURN_MESSAGE);
        }
    }
}
