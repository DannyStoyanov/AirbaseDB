package utils;
import exceptions.ArgumentsException;

import java.util.ArrayList;

public class ArgumentsCheck {
    public void assertZeroArguments(ArrayList<String> args) throws ArgumentsException {
        if(args.size() != 0) {
            throw new ArgumentsException("Arguments are not zero");
        }
    }
}
