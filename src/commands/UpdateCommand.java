package commands;

import database.DBAdmin;
import exceptions.ArgumentsException;
import utils.Utils;

import java.util.ArrayList;

public class UpdateCommand extends Command {
    public UpdateCommand() {
        super("update");
        this.setArgumentsCount(3);
    }
    public void execute(ArrayList<String> args) {
        try {
            // Validating:
            Utils.assertArgumentsCount(args, this.getArgumentsCount());
            Utils.areValidUpdateCommandArguments(args);

            // Serialization:
            DBAdmin admin = new DBAdmin("recordsDB.ser");
            admin.updateRecord(Integer.parseInt(args.get(0)), args.get(1), args.get(2));
        } catch (ArgumentsException exception) {
            exception.printStackTrace();
        }
    }
}
