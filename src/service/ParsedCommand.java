package service;

import java.util.ArrayList;

public class ParsedCommand {
    private String commandName;
    private ArrayList<String> commandArguments;

    public ParsedCommand(String commandName, ArrayList<String> commandArguments) {
        this.commandName = commandName;
        this.commandArguments = commandArguments;
    }

    public String getCommandName() {
        return commandName;
    }

    public ArrayList<String> getCommandArguments() {
        return commandArguments;
    }
}
