package commands;

import database.DBAdmin;
import exceptions.ArgumentsException;
import utils.Utils;

import java.util.ArrayList;

public class CreateCommand extends Command {
    public CreateCommand() {
        super("create");
        this.setArgumentsCount(4);
    }

    public void execute(ArrayList<String> args) {
        try {
            // Validating:
            Utils.assertArgumentsCount(args, this.getArgumentsCount());
            Utils.areValidCreateCommandArguments(args);

            // Main functionality:
            AirplaneRecord airplaneRecord = new AirplaneRecord(Integer.parseInt(args.get(0)), args.get(1), args.get(2), Integer.parseInt(args.get(3)));
            DBAdmin admin = new DBAdmin("planesDB.ser");
            admin.saveNewRecord(airplaneRecord);
        } catch (ArgumentsException exception) {
            exception.printStackTrace();
        }
    }
}
