package commands;

import exceptions.ArgumentsException;
import utils.Utils;

import java.util.ArrayList;

public class ExitCommand extends Command {

    public ExitCommand() {
        super("exit");
        this.setArgumentsCount(0);
    }

    public void execute(ArrayList<String> args) {
        try {
            Utils.assertArgumentsCount(args, this.getArgumentsCount());
            System.exit(0);
        } catch (ArgumentsException exception) {
            exception.printStackTrace();
            System.out.println("Command \"" + this.getName() + "\" must have " + this.getArgumentsCount() + " arguments.");
        }
    }
}
