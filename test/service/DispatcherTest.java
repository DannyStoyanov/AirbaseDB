package service;

import exceptions.InvalidCommand;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class DispatcherTest {

    @Test
    public void testProcessCommand() {
        ArrayList<String> args = new ArrayList<String>();
        args.add("test_arg_1");
        args.add("test_arg_2");
        args.add("test_arg_3");
        String invalidCommand = "invalidCommand";
        ParsedCommand parsedCommand = new ParsedCommand(invalidCommand, args);
        assertThrows(InvalidCommand.class,
                () -> {
                    Dispatcher dispatcher = new Dispatcher();
                    dispatcher.processCommand(parsedCommand);
                });
    }
}