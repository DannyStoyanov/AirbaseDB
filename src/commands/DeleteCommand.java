package commands;

import database.DBAdmin;
import exceptions.ArgumentsException;
import utils.Utils;

import java.util.ArrayList;

public class DeleteCommand extends Command {
    public DeleteCommand() {
        super("delete");
        this.setArgumentsCount(1);
    }
    public void execute(ArrayList<String> args) {
        try {
            // Validating:
            Utils.assertArgumentsCount(args, this.getArgumentsCount());
            Utils.areValidDeleteCommandArguments(args);

            // Serialization:
            DBAdmin admin = new DBAdmin("recordsDB.ser");
            admin.deleteRecord(Integer.parseInt(args.get(0)));
        } catch (ArgumentsException exception) {
            exception.printStackTrace();
        }
    }
}
