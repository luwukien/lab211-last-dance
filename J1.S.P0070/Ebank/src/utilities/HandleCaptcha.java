package utilities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author IdeaPad
 */
public class HandleCaptcha {

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGIT = "0123456789";
    private static final String ALL = LOWER + UPPER + DIGIT;
    private static final Random random = new Random();
    private final Scanner sc = new Scanner(System.in);

    public String generateCaptcha() {
        ArrayList<Character> chars = new ArrayList<>();

        chars.add(LOWER.charAt(random.nextInt(LOWER.length())));
        chars.add(UPPER.charAt(random.nextInt(UPPER.length())));
        chars.add(DIGIT.charAt(random.nextInt(DIGIT.length())));

        for (int i = 0; i < 2; i++) {
            chars.add(ALL.charAt(random.nextInt(ALL.length())));
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     *  Display the generated captcha and retrieves user input
     * 
     * @param generateCaptcha  the generated captcha code to be displayed
     * @param msgCaptcha  the label message for the captcha
     * @param msg the prompt  message  requesting user input
     * @param formatMsg the error message displayed when input is empty
     * @return the valid, non-empty string entered by the user
     */
    public String getCaptcha(String generateCaptcha, String msgCaptcha, String msg, String formatMsg) {
        boolean isValid = false;
        String result = "";

        System.out.print(msgCaptcha);
        System.out.println(" " + generateCaptcha);
        System.out.println(msg);

        while (!isValid) {
            String inputStr = sc.nextLine().trim();
            if (inputStr.isEmpty()) {
                System.err.println(formatMsg);
            } else {
                result = inputStr;
                isValid = true;
            }
        }
        return result;
    }

    /**
     * Validates the user's captcha input against the generated code
     * 
     * @param inputCaptcha the captcha characters enterd by user
     * @param generateCaptcha the actual  generated captcha code 
     * @return true if  the input captcha matches the generated code, otherwise false
     */
    public boolean checkCaptcha(String inputCaptcha, String generateCaptcha) {

        return generateCaptcha.contains(inputCaptcha);
    }
}
