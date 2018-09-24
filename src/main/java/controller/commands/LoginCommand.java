package controller.commands;

import controller.ICommand;
import controller.Session;
import model.Library;
import model.Password;
import model.User;
import model.Username;
import view.Input;
import view.Output;

public class LoginCommand implements ICommand {

    @Override
    public void perform(Library library, Output output, Input input, Session session) {
        output.print("Enter the username:");
        String username = input.getUserInput();

        output.print("Enter the password:");
        String password = input.getUserInput();

        User user = new User(new Username(username), new Password(password));
        if (library.verifyUser(user)) {
            session = new Session(user);
            output.print("Logged in successfully.");
        } else {
            output.print("Wrong credentials!!!");
        }
    }
}
