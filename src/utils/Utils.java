package utils;

import exceptions.ArgumentsException;

import java.util.ArrayList;

public class Utils {
    private static boolean isValidNumber(int number) {
        return number > 0 && number < Math.pow(2, 50);
    }

    private static boolean isValidString(String str) {
        if (str.length() > 256 || str == "") {
            return false;
        }
        return true;
    }

    private static boolean isNumeric(String str) {
        int intValue;
        if (str == null || str.equals("")) {
            return false;
        }
        try {
            intValue = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }

    private static boolean notValidOffsetAndLimit(int offset, int limit) {
        if (offset < 0 || limit < 0) {
            return false;
        } else if (offset > limit) {
            return false;
        }
        return true;
    }

    public static void assertArgumentsCount(ArrayList<String> args, int count) throws ArgumentsException {
        if (args.size() != count) {
            throw new ArgumentsException("Arguments are invalid count.");
        }
    }

    public static void areValidCreateCommandArguments(ArrayList<String> args) throws ArgumentsException {
        if (!isNumeric(args.get(0))) {
            throw new ArgumentsException("create command \"id\" argument is not a number.");
        } else if (!isNumeric(args.get(3))) {
            throw new ArgumentsException("crete command \"flights\" argument is not a number.");
        }
        try {
            int id = Integer.parseInt(args.get(0));
            String name = args.get(1);
            String type = args.get(2);
            int flights = Integer.parseInt(args.get(3));
            if (!isValidNumber(id)) {
                throw new ArgumentsException("Airplane \"id\" argument is not a valid number.");
            } else if (!isValidString(name)) {
                throw new ArgumentsException("Airplane \"name\" argument is not valid string.");
            } else if (!isValidString(type)) {
                throw new ArgumentsException("Airplane \"type\" argument is not valid string.");
            } else if (!isValidNumber(flights)) {
                throw new ArgumentsException("Airplane \"flights\" argument is not a valid number.");
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

    public static void areValidShowCommandArguments(ArrayList<String> args) throws ArgumentsException {
        if (!isNumeric(args.get(0))) {
            throw new ArgumentsException("show command \"offset\" argument is not a number.");
        } else if (!isNumeric(args.get(1))) {
            throw new ArgumentsException("show command \"limit\" argument  is not a number.");
        } else if (!notValidOffsetAndLimit(Integer.parseInt(args.get(0)), Integer.parseInt(args.get(1)))) {
            throw new ArgumentsException("show command \"offset\" and \"limit\" arguments are not valid.");
        }
    }

    public static void areValidDeleteCommandArguments(ArrayList<String> args) throws ArgumentsException {
        if (!isNumeric(args.get(0))) {
            throw new ArgumentsException("delete command \"id\" argument is not a number.");
        }
    }
}
