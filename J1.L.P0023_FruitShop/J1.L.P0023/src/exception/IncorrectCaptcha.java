package exception;

public class IncorrectCaptcha extends Exception{
    public IncorrectCaptcha (String errorMessage) {
        super(errorMessage);
    }
}
