package bo;

import controller.AccountManagerController;
import utils.Captcha;

import java.util.Locale;
import java.util.ResourceBundle;

public class CaptchaInputter {
    private Locale locale;

    public CaptchaInputter() {
    }

    public String generateCaptcha() {
        return Captcha.generateCaptcha();
    }

    public void verifyCaptcha(String msg, String captchaGenerated, String errorMsg) {

        Captcha.checkValidCaptcha(msg,
                captchaGenerated,
                errorMsg
        );
    }
}
