package commands;

import exceptions.ArgumentsException;
import utils.ArgumentsCheck;

import java.util.ArrayList;

public class Exit extends ICommand {

    public Exit() {
        super("exit");
        this.setArgumentsCount(0);
    }

    public void execute(ArrayList<String> args) {
        try {
            ArgumentsCheck checker = new ArgumentsCheck();
            checker.assertArgumentsCount(args, this.getArgumentsCount());
            System.exit(0);
        } catch (ArgumentsException exception) {
            exception.printStackTrace();
            System.out.println("Command \"" + this.getName() + "\" must have " + this.getArgumentsCount() + " arguments.");
        }
    }
}
