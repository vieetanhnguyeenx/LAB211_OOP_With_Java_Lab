package util;

import exception.IncorrectCaptcha;

import java.util.Locale;
import java.util.Random;

public class Captcha {
    private static final int CAPTCHA_LENGTH = 6;
    public static String generateCaptcha() {
        Random random = new Random();
        String chars = "";
        for (char c = 'a'; c < 'z'; c++) {
            chars += c;
        }
        for (char c = 'A'; c < 'Z'; c++) {
            chars += c;
        }
        for (char c = '0'; c < '9'; c++) {
            chars += c;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < CAPTCHA_LENGTH; i++) {
            int index = random.nextInt(chars.length() - 1);
            builder.append(chars.charAt(index));

        }
        return builder.toString();
    }

    public static void checkValidCaptcha(String msg, String captchaGenerate, String errorMsg) {
        while (true) {
            try {
                String captchaInput = Validation.getString(msg);
                for (int i = 0; i < captchaInput.length(); i++) {
                    if (!captchaGenerate.contains(String.valueOf(captchaInput.charAt(i)))) {
                        throw new IncorrectCaptcha(errorMsg);
                    }
                }
                return;
            } catch (IncorrectCaptcha incorrectCaptcha) {
                System.out.println(incorrectCaptcha.getMessage());
            } catch (Exception exception) {
                System.out.println(errorMsg);
            }

        }

    }
}
