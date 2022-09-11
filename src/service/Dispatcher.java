package service;

import commands.*;
import exceptions.InvalidCommand;

import java.util.ArrayList;

public class Dispatcher {
    private ArrayList<Command> commands;

    public Dispatcher() {
        this.commands = new ArrayList<Command>();
        this.commands.add(new ExitCommand());
        this.commands.add(new CreateCommand());
        this.commands.add(new ShowCommand());
//        this.commands.add(new SearchCommand());
        this.commands.add(new DeleteCommand());
//        this.commands.add(new UpdateCommand());
        // TODO: add rest commands
    }

    public Dispatcher(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public void processCommand(AirbaseSystem.ParsedCommand parsedCommand) throws InvalidCommand {
        boolean validCommand = false;
        for (Command command: this.commands) {
            if(parsedCommand.getCommandName().equals(command.getName())) {
                command.execute(parsedCommand.getCommandArguments());
                validCommand = true;
                break;
            }
        }
        if(!validCommand) {
            throw new InvalidCommand("Invalid command.");
        }
    }
}
