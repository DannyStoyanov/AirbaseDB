package commands;

import database.DBAdmin;
import exceptions.ArgumentsException;
import utils.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ShowCommand extends Command {
    public ShowCommand() {
        super("show");
        this.setArgumentsCount(2);
    }

    public void execute(ArrayList<String> args) {
        try {
            // Validation:
            Utils.assertArgumentsCount(args, this.getArgumentsCount());
            Utils.areValidShowCommandArguments(args);
            int offset = Integer.parseInt(args.get(0));
            int limit = Integer.parseInt(args.get(1));
            DBAdmin admin = new DBAdmin("recordsDB.ser");
            admin.showRecords(offset, limit);
        } catch (ArgumentsException ex) {
            ex.printStackTrace();
        }
    }
}
