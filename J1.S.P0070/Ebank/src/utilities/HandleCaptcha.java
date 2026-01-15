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
     *
     * @param msgCaptcha
     * @param msg
     * @param formatMsg
     * @return
     */
    public String getCaptcha(String msgCaptcha, String msg, String formatMsg) {
        boolean isValid = false;
        String result = "";
        String captcha = generateCaptcha();
        
        System.out.print(msgCaptcha);
        System.out.println(" " + captcha);
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
     * 
     * @param inputCaptcha
     * @param generateCaptcha
     * @return 
     */
    public boolean checkCaptcha(String inputCaptcha, String generateCaptcha) {
        
        return inputCaptcha.contains(generateCaptcha);
    }

}
