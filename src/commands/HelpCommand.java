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
        System.out.println("[### -<>-  List with commands  -<>- ###]");
        System.out.println("Command             Attributes          ");
        System.out.println();
        System.out.println("create     <id> <name> <type> <flights>");
        System.out.println("           Description:");
        System.out.println("           <id> - number");
        System.out.println("           <name> - string");
        System.out.println("           <type> - string");
        System.out.println("           <flights> - number");
        System.out.println();
        System.out.println("show       <offset> <limit>");
        System.out.println("           Description:");
        System.out.println("           <offset> - number");
        System.out.println("           <limit> - number");
        System.out.println();
        System.out.println("update     <id> <attribute> <new_value>");
        System.out.println("           Description:");
        System.out.println("           <attribute> - string - name/type/flights");
        System.out.println("           <new_value> - string/number (*depends on <attribute>)");
        System.out.println();
        System.out.println("search     <id>");
        System.out.println("           Description:");
        System.out.println("           <id> - number");
        System.out.println();
        System.out.println("help       (*no arguments)");
        System.out.println();
        System.out.println("exit       (*no arguments)");
        System.out.println();
        System.out.println("[### -<>- --- -<>- --- -<>- --- -<>- ### ]");

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
