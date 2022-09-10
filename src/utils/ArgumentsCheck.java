package utils;
import exceptions.ArgumentsException;

import java.util.ArrayList;

public class ArgumentsCheck {
    public void assertArgumentsCount(ArrayList<String> args, int count) throws ArgumentsException {
        if(args.size() != count) {
            throw new ArgumentsException("Arguments are invalid count.");
        }
    }
}
