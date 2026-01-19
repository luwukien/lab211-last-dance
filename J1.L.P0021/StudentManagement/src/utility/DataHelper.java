package utility;

import java.util.Scanner;

/**
 * @author Chi Kien-Luu | github/luwukien
 * Initialize Date: 19/01/2026
 */

public class DataHelper {
    private final Scanner sc = new Scanner(System.in);


    /**
     * This method helps validate choice when user enter the number of menu choice
     *
     * @param msg the prompt message for the captcha
     * @param min the lowest number choice in menu choice
     * @param max the greatest number choice in menu choice
     * @return choice after validating
     */
    public int checkInputLimitChoices(String msg, int min, int max) {
        int result = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println(msg);
                int input = Integer.parseInt(sc.nextLine().trim());
                if (input < min || input > max) {
                    System.err.println("Input must be in a range [" + min + ", " + max + "] ");
                } else {
                    result = input;
                    isValid = true;
                }
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                System.out.print("Input must be a number. Please try again: ");
            }
        }

        return result;
    }

    /**
     *
     * @param msg
     * @param formatMsg
     * @return
     */
    public String inputString(String msg, String formatMsg) {
        boolean isValid = false;
        String result = "";

        while (!isValid) {
            System.out.println(msg);
            String inputStr = sc.nextLine().trim();
            if (inputStr.isEmpty()) {
                System.err.println("Input string must not be empty!!");
                System.out.println(formatMsg);
                System.out.print("Enter again: ");
            } else {
                result = inputStr;
                isValid = true;
            }
        }
        return result;
    }


}
