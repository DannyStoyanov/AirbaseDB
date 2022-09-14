package utils;

import commands.AirplaneRecord;
import exceptions.ArgumentsException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class UtilsTest {
    String longNotLegalString = "a".repeat(257);
    String longLegalString = "a".repeat(256);

    @Test
    public void testIsValidNumber() {
        assertFalse(Utils.isValidNumber(-10));
        assertFalse(Utils.isValidNumber(0));
        assertFalse(Utils.isValidNumber((int) Math.pow((double) 2, (double) 30)));

        assertTrue(Utils.isValidNumber(1));
        assertTrue(Utils.isValidNumber(100));
        assertTrue(Utils.isValidNumber(100000));
        assertTrue(Utils.isValidNumber(10000000));
        assertTrue(Utils.isValidNumber((int) Math.pow((double) 2, (double) 29)));
    }

    @Test
    public void testIsValidString() {
        assertFalse(Utils.isValidString(""));
        assertFalse(Utils.isValidString(longNotLegalString));

        assertTrue(Utils.isValidString(longLegalString));
        assertTrue(Utils.isValidString("Some string"));
        assertTrue(Utils.isValidString("a"));
        assertTrue(Utils.isValidString("!@#$%^&*()~`[]{}\';|/?.,><"));
    }

    @Test
    public void testIsNumeric() {
        assertFalse(Utils.isNumeric(""));
        assertFalse(Utils.isNumeric("a1"));
        assertFalse(Utils.isNumeric("1a"));
        assertFalse(Utils.isNumeric("1a1"));
        assertFalse(Utils.isNumeric("1   a"));
        assertFalse(Utils.isNumeric("a   1"));
        assertFalse(Utils.isNumeric("1 2 3"));
        assertFalse(Utils.isNumeric("1    "));
        assertFalse(Utils.isNumeric("    1"));

        assertTrue(Utils.isNumeric("0"));
        assertTrue(Utils.isNumeric("1"));
        assertTrue(Utils.isNumeric("123"));
    }

    @Test
    public void testAssertArgumentsCount() {
        ArrayList<String> arr = new ArrayList<String>();
        String x = "x";
        arr.add(x); // added argument => argumentsCount = 1
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.assertArgumentsCount(arr, 0);
                });
    }

    @Test
    public void testAreValidCreateCommandArguments() {
        ArrayList<String> args = new ArrayList<String>();

        // Test invalid id exception:
        args.add("1a");
        args.add("ZSH45");
        args.add("SuperJet");
        args.add("8");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidCreateCommandArguments(args);
                });
        args.clear();

        // Test invalid name(empty) exception:
        args.add("1");
        args.add("");
        args.add("SuperJet");
        args.add("8");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidCreateCommandArguments(args);
                });
        args.clear();

        // Test invalid name(length>256) exception:
        args.add("1");
        args.add(longNotLegalString);
        args.add("SuperJet");
        args.add("8");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidCreateCommandArguments(args);
                });
        args.clear();

        // Test invalid type(empty) exception:
        args.add("1");
        args.add("ZSH45");
        args.add("");
        args.add("8");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidCreateCommandArguments(args);
                });
        args.clear();

        // Test invalid type(length>256) exception:
        args.add("1");
        args.add("ZSH45");
        args.add(longNotLegalString);
        args.add("8");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidCreateCommandArguments(args);
                });
        args.clear();

        // Test invalid flights exception:
        args.add("1");
        args.add("ZSH45");
        args.add("SuperJet");
        args.add("8a");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidCreateCommandArguments(args);
                });
    }


    @Test
    public void testAreValidShowCommandArguments() {
        ArrayList<String> args = new ArrayList<String>();

        // Test invalid offset exception:
        args.add("0a");
        args.add("10");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidShowCommandArguments(args);
                });
        args.clear();

        // Test invalid limit exception:
        args.add("0");
        args.add("10a");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidShowCommandArguments(args);
                });
        args.clear();

        // Test invalid offset and limit (offset > limit) exception:
        args.add("10");
        args.add("0");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidShowCommandArguments(args);
                });
        args.clear();
    }

    @Test
    public void testAreValidDeleteCommandArguments() {
        ArrayList<String> args = new ArrayList<String>();

        // Test invalid id exception:
        args.add("");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidDeleteCommandArguments(args);
                });
        args.clear();
        args.add("a");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidDeleteCommandArguments(args);
                });
    }

    @Test
    public void testAreValidUpdateCommandArguments() {
        ArrayList<String> args = new ArrayList<String>();

        // Test invalid id exception:
        args.add("");
        args.add("name");
        args.add("ZSH45");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidUpdateCommandArguments(args);
                });
        args.clear();
        args.add("a");
        args.add("name");
        args.add("ZSH45");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidUpdateCommandArguments(args);
                });
        args.clear();
        args.add("1a");
        args.add("name");
        args.add("ZSH45");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidUpdateCommandArguments(args);
                });
        args.clear();

        // Test invalid attribute(empty) exception:
        args.add("1");
        args.add("");
        args.add("ZSH45");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidUpdateCommandArguments(args);
                });
        args.clear();

        // Test invalid attribute(length>256) exception:
        args.add("1");
        args.add(longNotLegalString);
        args.add("ZSH45");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidUpdateCommandArguments(args);
                });
        args.clear();

        // Test invalid new_value to name attribute exception:
        args.add("1");
        args.add("name");
        args.add(longNotLegalString);
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidUpdateCommandArguments(args);
                });
        args.clear();

        // Test invalid new_value to type attribute exception:
        args.add("1");
        args.add("type");
        args.add(longNotLegalString);
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidUpdateCommandArguments(args);
                });
        args.clear();

        // Test invalid new_value to flights attribute(empty) exception:
        args.add("1");
        args.add("flights");
        args.add("");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidUpdateCommandArguments(args);
                });
        args.clear();
    }

    @Test
    public void testAreValidSearchCommandArguments() {
        ArrayList<String> args = new ArrayList<String>();

        // Test invalid id exception:
        args.add("");
        args.add("name");
        args.add("ZSH45");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidUpdateCommandArguments(args);
                });
        args.clear();
        args.add("1e");
        args.add("name");
        args.add("ZSH45");
        assertThrows(ArgumentsException.class,
                () -> {
                    Utils.areValidUpdateCommandArguments(args);
                });
    }
}
