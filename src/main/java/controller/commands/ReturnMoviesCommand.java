package controller.commands;

import common.Message;
import controller.ICommand;
import model.ItemType;
import model.Library;
import view.Input;
import view.Output;

public class ReturnMoviesCommand implements ICommand {

    @Override
    public void perform(Library library, Output output, Input input) {
        output.print(Message.MOVIE_RETURN_MESSAGE);
        if (library.returnItem(input.getUserInput(), ItemType.Movie)) {
            output.print(Message.SUCCESSFUL_MOVIE_RETURN_MESSAGE);
        } else {
            output.print(Message.UNSUCCESSFUL_MOVIE_RETURN_MESSAGE);
        }
    }
}
