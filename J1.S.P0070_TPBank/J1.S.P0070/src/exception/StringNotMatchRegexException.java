package exception;

public class StringNotMatchRegexException extends Exception{
    public StringNotMatchRegexException(String errorMessage) {
        super(errorMessage);
    }
}
