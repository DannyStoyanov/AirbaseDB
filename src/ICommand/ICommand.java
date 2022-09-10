package ICommand;

import java.util.ArrayList;

abstract public class ICommand {
    private String name;
    private ArrayList<String> arguments;

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

    // Mutators:
    public void setArguments(ArrayList<String> arguments) {
        this.arguments = arguments;
    }
}
