package commands;

import database.DBAdmin;
import exceptions.ArgumentsException;
import utils.Utils;

import java.util.ArrayList;

public class SearchCommand extends Command {
    public SearchCommand() {
        super("search");
        this.setArgumentsCount(1);
    }

    public void execute(ArrayList<String> args) {
        try {
            // Validation:
            Utils.assertArgumentsCount(args, this.getArgumentsCount());
            Utils.areValidSearchCommandArguments(args);

            // Main functionality:
            DBAdmin admin = new DBAdmin("planesDB.ser");
            admin.searchRecord(Integer.parseInt(args.get(0)));
        } catch (ArgumentsException ex) {
            ex.printStackTrace();
        }
    }
}
