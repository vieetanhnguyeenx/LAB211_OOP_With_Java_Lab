package utils;

import exception.NumberNotInRangeException;
import exception.StringEmptyException;
import exception.StringNotMatchRegexException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validation {
    public static final String NAME_PATTERN = "^[a-zA-Z][\\w .',]+$";
    public static final String PHONE_PATTERN = "^[0][0-9]{9}$";
    public static final String EMAIL_PATTERN = "^[a-zA-Z]\\w+@(\\w+.?)+(\\w)$";
    public static final String ALL_MATCH_PATTERN = "[\\s\\S]*";
    public static final String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,31}$";
    public static final String ACCOUNT_NUMBER_PATTERN = "^[0-9][0-9]{9}$";

    public static final String TIME_NUMBER_PATTERN = "^\\d+\\.([0]|[5])$";
    public static final String DATE_PATTERN_OUT = "dd-MMM-yyyy";
    public static final String DATE_PATTERN_IN = "dd/MM/yyyy";


    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    // Check user input and catch exception with custom error message
    public static int getInt(String msg, String errorMsg, int min, int max) {
        // Loop until get right format number
        while (true) {
            try {
                System.out.print(msg);
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
        return getInt(msg,
                "Invalid input, input must be an integer",
                Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    // Check user input and catch exception with custom error message
    public static int getInt(String msg, String errorMsg) {
        return getInt(msg,
                errorMsg,
                Integer.MIN_VALUE,
                Integer.MAX_VALUE);
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
        return getDouble(msg,
                "Invalid input, input must be a real number",
                Double.MIN_VALUE,
                Double.MAX_VALUE);
    }

    // Check user input and catch exception with custom error message
    public static double getDouble(String msg, String errorMsg) {
        return getDouble(msg,
                errorMsg,
                Double.MIN_VALUE,
                Double.MAX_VALUE);
    }

    // Check user input and catch exception with default error message and input in range
    public static double getDouble(String msg, double min, double max) {
        return getDouble(msg,
                "Invalid input, input must be a real number",
                min,
                max);
    }

    public static String getString(String msg, String errorMsg, String emptyErrorMsg, String regex, String notMatchErrorMsg){
        // Loop until get right format string
        while (true) {
            try {
                System.out.print(msg);
                String result = input.readLine().trim();
                if (result.isEmpty())
                    throw new StringEmptyException(emptyErrorMsg);
                if (!result.matches(regex))
                    throw new StringNotMatchRegexException(notMatchErrorMsg);

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
        return getString(msg,
                "Invalid input, input must be string",
                "Invalid input, input must be non-empty string",
                Validation.ALL_MATCH_PATTERN,
                "InvalidInput");
    }

    public static String getString(String msg, String regex, String notMatchErrorMsg) {
        return getString(msg,
                "Invalid input, input must be string",
                "Invalid input, input must be non-empty",
                regex,
                notMatchErrorMsg);
    }

    public static LocalDate getLocalDate(String msg, String errorMsg, String format, String wrongFormatErrorMsg) {
        while (true) {
            try {
                System.out.print(msg);
                LocalDate date = LocalDate.parse(input.readLine(),
                        DateTimeFormatter.ofPattern(format));
                return date;
            }catch (DateTimeParseException dateTimeParseException) {
                System.out.println(wrongFormatErrorMsg);
            }catch (Exception exception) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getDateString(String msg, String errorMsg, String enterFormat, String wrongFormatErrorMsg, String saveFormat) {
        while (true) {
            try {
                LocalDate date = getLocalDate(msg,
                        errorMsg,
                        enterFormat,
                        wrongFormatErrorMsg);
                return date.format(DateTimeFormatter.ofPattern(DATE_PATTERN_OUT));
            }catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static double getDoubleWithRegex(String msg, String errorMsg, String regex, String notMatchErrorMsg, double min, double max) {
        while (true) {
            try {
                String time = Validation.getString(msg, regex, notMatchErrorMsg);
                double result = Double.parseDouble(time);
                if (result < min || result > max)
                    throw new NumberNotInRangeException("Invalid input, number must be in range [" + min + ", " + max + "]");
                return result;

            }catch (NumberNotInRangeException numberNotInRangeException) {
                System.out.println(numberNotInRangeException.getMessage());
            }catch (Exception ex) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getDoubleWithRegex(String msg, String regex, String notMatchErrorMsg, double min, double max) {
        return getDoubleWithRegex(msg,
                "Invalid input, input must be a real number",
                regex,
                notMatchErrorMsg,
                min,
                max
                );
    }
}
