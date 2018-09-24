package controller;

import model.Library;
import view.Input;
import view.Output;

public interface ICommand {

    void perform(Library library, Output output, Input input, Session session);
}
