package commands;

import java.util.ArrayList;

abstract public class ICommand {
    private String name;
    private ArrayList<String> arguments;
    private int argumentsCount;

    ICommand() {
        this.name = "";
        this.arguments = new ArrayList<String>();
    }

    ICommand(String name) {
        this.name = name;
        this.arguments = new ArrayList<String>();
    }

    // Abstract function:
    public abstract void execute(ArrayList<String> args);

    // Selectors:
    public String getName() {
        return name;
    }

    public ArrayList<String> getArguments() {
        return arguments;
    }

    public int getArgumentsCount() {
        return argumentsCount;
    }

    // Mutators:
    public void setArguments(ArrayList<String> arguments) {
        this.arguments = arguments;
    }

    public void setArgumentsCount(int argumentsCount) {
        this.argumentsCount = argumentsCount;
    }
}
