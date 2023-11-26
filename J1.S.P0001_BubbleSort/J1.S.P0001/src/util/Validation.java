package util;

import exception.NumberNotInRangeException;
import exception.StringEmptyException;
import exception.StringNotMatchRegexException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Validation {
    public static final String NAME_PATTERN = "^[a-zA-Z][\\w .',]+$";
    public static final String PHONE_PATTERN = "^[0][0-9]{9}$";
    public static final String EMAIL_PATTERN = "^[a-zA-Z]\\w+@(\\w+.?)+(\\w)$";
    public static final String ALL_PATTERN = "[\\s\\S]*";


    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    // Check user input and catch exception with custom error message
    public static int getInt(String msg, String errorMsg, int min, int max) {
        // Loop until get right format number
        while (true) {
            try {
                System.out.println(msg);
                int result = Integer.parseInt(input.readLine().trim());
                if (result < min || result > max)
                    throw new NumberNotInRangeException("Invalid input, number must be in range [" + min + ", " + max +"]");
                return result;

            } catch (NumberNotInRangeException numberNotInRangeException) {
                System.out.println(numberNotInRangeException.getMessage());
            } catch (Exception ex) {
                System.out.println(errorMsg);
            }
        }
    }

    // Check user input and catch exception with default error message
    public static int getInt(String msg) {
        return getInt(msg, "Invalid input, input must be an integer", Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Check user input and catch exception with custom error message
    public static int getInt(String msg, String errorMsg) {
        return getInt(msg, errorMsg, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Check user input and catch exception with default error message and input in range
    public static int getInt(String msg, int min, int max) {
        return getInt(msg, "Invalid input, input must be an integer", min, max);
    }


    // Check user input and catch exception with custom error message
    public static double getDouble(String msg, String errorMsg, double min, double max) {
        // Loop until get right format number
        while (true) {
            try {
                System.out.println(msg);
                double result = Double.parseDouble(input.readLine().trim());
                if (result < min || result > max)
                    throw new NumberNotInRangeException("Invalid input, number must be in range [" + min + ", " + max +"]");
                return result;

            } catch (NumberNotInRangeException numberNotInRangeException) {
                System.out.println(numberNotInRangeException.getMessage());
            } catch (Exception ex) {
                System.out.println(errorMsg);
            }
        }
    }

    // Check user input and catch exception with default error message
    public static double getDouble(String msg) {
        return getDouble(msg, "Invalid input, input must be a real number", Double.MIN_VALUE, Double.MAX_VALUE);
    }

    // Check user input and catch exception with custom error message
    public static double getDouble(String msg, String errorMsg) {
        return getDouble(msg, errorMsg, Double.MIN_VALUE, Double.MAX_VALUE);
    }

    // Check user input and catch exception with default error message and input in range
    public static double getDouble(String msg, double min, double max) {
        return getDouble(msg, "Invalid input, input must be a real number", min, max);
    }

    public static String getString(String msg, String errorMsg, String regex){
        // Loop until get right format string
        while (true) {
            try {
                System.out.println(msg);
                String result = input.readLine().trim();
                if (result.isEmpty())
                    throw new StringEmptyException("Invalid input, input must be non-empty string");
                if (!result.matches(regex))
                    throw new StringNotMatchRegexException("Invalid input, input must be match regex " + regex);

                return result;

            }catch (StringEmptyException stringEmptyException) {
                System.out.println(stringEmptyException.getMessage());
            }catch (StringNotMatchRegexException stringNotMatchRegexException) {
                System.out.println(stringNotMatchRegexException.getMessage());
            } catch (Exception exception) {
                System.out.println(errorMsg);
            }
        }
    }


    public static String getString(String msg) {
        return getString(msg, "Invalid input, input must be string", Validation.ALL_PATTERN);
    }

    public static String getString(String msg, String regex) {
        return getString(msg,"Invalid input, input must be string", regex);
    }

}
