package service;

import exceptions.InvalidCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class AirbaseSystem {
    private Dispatcher dispatcher;

    private ParsedCommand parseLineToCommand(String line) {
        String[] tokens = line.split(" ");
        String[] args = Arrays.stream(tokens).filter(s -> !s.isEmpty()).toArray(String[]::new);
        String commandName = args[0];
        ArrayList<String> commandArguments = new ArrayList<String>();
        for (int i = 1; i < args.length; i++) {
            commandArguments.add(args[i]);
        }
        return new ParsedCommand(commandName, commandArguments);
    }

    public AirbaseSystem() {
        this.dispatcher = new Dispatcher();
    }

    public void start() {
        System.out.println("[Type \"help\" to see full list of commands.]");
        String line;
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                line = bufferedReader.readLine().trim();
                ParsedCommand parsedCommand = parseLineToCommand(line);
                dispatcher.processCommand(parsedCommand);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (InvalidCommand ex) {
                ex.printStackTrace();
            }

        }
    }
}
