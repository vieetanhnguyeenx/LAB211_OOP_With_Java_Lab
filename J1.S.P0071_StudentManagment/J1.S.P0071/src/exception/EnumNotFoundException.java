package exception;

public class EnumNotFoundException extends Exception{
    public EnumNotFoundException (String errorMessage) {
        super(errorMessage);
    }
}
