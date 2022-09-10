package ICommand;

import exceptions.ArgumentsException;
import utils.ArgumentsCheck;

import java.util.ArrayList;

public class Exit extends ICommand {
    public Exit() {
        super("exit");
    }

    public void execute(ArrayList<String> args) {
        try {
            ArgumentsCheck checker = new ArgumentsCheck();
            checker.assertZeroArguments(args);
            System.exit(0);
        } catch (ArgumentsException exception) {
            exception.printStackTrace();
        }

    }

}
