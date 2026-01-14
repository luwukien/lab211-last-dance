package utilities;

import java.util.Scanner;

/**
 *
 * @author IdeaPad
 */
public class GetData {

    private final Scanner sc = new Scanner(System.in);
    private final String FORMAT_ACCOUNT_NUMBER = "^[0-9]{10}$";

    /**
     * This method helps validate choice when user enter the number of menu
     * choice
     *
     * @param msg ??
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

    public String inputString() {
        boolean isValid = false;
        String result = "";

        while (!isValid) {
            String inputStr = sc.nextLine().trim();
            if (inputStr.isEmpty()) {
                System.err.println("Input string must not be empty!!");
                System.out.print("Enter again: ");
            } else {
                result = inputStr;
                isValid = true;
            }
        }
        return result;
    }

    public String getAccountNumber(String msg, String formatMsg) {
        boolean isValid = false;
        String accountNumber = "";
        while (!isValid) {
            System.out.println(msg);
            String inputAccountNumber = inputString();
            if (inputAccountNumber.matches(FORMAT_ACCOUNT_NUMBER)) {
                accountNumber = inputAccountNumber;
                isValid = true;
            } else {
                System.out.println(formatMsg);
            }
        }
        return accountNumber;
    }
    
    

}
