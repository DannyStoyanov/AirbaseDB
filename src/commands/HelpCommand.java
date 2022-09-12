package commands;

import database.DBAdmin;
import exceptions.ArgumentsException;
import utils.Utils;

import java.util.ArrayList;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("help");
        this.setArgumentsCount(0);
    }

    private void printCommandsList() {
        System.out.println("--- <> ---  List with commands --- <> ---");
        System.out.println("create     <id> <name> <type> <flights>");
        System.out.println("show       <offset> <limit>");
        System.out.println("update     <id> <attribute> <new_value>");
        System.out.println("search     <id>");
        System.out.println("help");
        System.out.println("exit");
        System.out.println("--- --- --- --- --- <> --- --- --- --- ---");

    }

    public void execute(ArrayList<String> args) {
        try {
            // Validation:
            Utils.assertArgumentsCount(args, this.getArgumentsCount());

            // Main functionality:
            printCommandsList();
        } catch (ArgumentsException ex) {
            ex.printStackTrace();
        }
    }
}
