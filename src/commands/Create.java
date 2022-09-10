package commands;

import exceptions.ArgumentsException;
import utils.ArgumentsCheck;

import java.util.ArrayList;

public class Create  extends ICommand {
    public Create() {
        super("create");
        this.setArgumentsCount(4);
    }

    public void execute(ArrayList<String> args) {
        try {
            ArgumentsCheck checker = new ArgumentsCheck();
            checker.assertArgumentsCount(args, this.getArgumentsCount());
            System.out.println("Works");

            // TODO: ...
        } catch (ArgumentsException exception) {
            exception.printStackTrace();
            System.out.println("Command \"" + this.getName() + "\" must have " + this.getArgumentsCount() + " arguments.");
        }
    }
}
