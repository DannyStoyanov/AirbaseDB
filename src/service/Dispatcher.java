package service;

import commands.*;

import java.util.ArrayList;

public class Dispatcher {
    private ArrayList<ICommand> commands;

    public Dispatcher() {
        this.commands = new ArrayList<ICommand>();
        this.commands.add(new Exit());
        this.commands.add(new Create());
        // TODO: add rest commands
    }

    public Dispatcher(ArrayList<ICommand> commands) {
        this.commands = commands;
    }

    public ArrayList<ICommand> getCommands() {
        return commands;
    }

    public void processCommand(AirbaseSystem.ParsedCommand parsedCommand) {
        for (ICommand command: this.commands) {
            if(parsedCommand.getCommandName().equals(command.getName())) {
                command.execute(parsedCommand.getCommandArguments());
                break;
            }
        }
    }
}
