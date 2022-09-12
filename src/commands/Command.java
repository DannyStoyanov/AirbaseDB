package commands;

import java.util.ArrayList;

abstract public class Command {
    private String name;
    private ArrayList<String> arguments;
    private int argumentsCount;

    Command() {
        this.name = "";
        this.arguments = new ArrayList<String>();
    }

    Command(String name) {
        this.name = name;
        this.arguments = new ArrayList<String>();
    }

    // Abstract function:
    public abstract void execute(ArrayList<String> args);

    // Getters(Selectors):
    public String getName() {
        return name;
    }

    public ArrayList<String> getArguments() {
        return arguments;
    }

    public int getArgumentsCount() {
        return argumentsCount;
    }

    // Setters(Mutators):
    public void setArguments(ArrayList<String> arguments) {
        this.arguments = arguments;
    }

    public void setArgumentsCount(int argumentsCount) {
        this.argumentsCount = argumentsCount;
    }
}
