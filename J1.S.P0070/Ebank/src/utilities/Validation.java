package utilities;

import java.util.ArrayList;
import java.util.Scanner;
import model.Account;

/**
 *
 * @author IdeaPad
 */
public class Validation {

    private final Scanner sc = new Scanner(System.in);

    /**
     * This method helps validate choice when user enter the number of menu
     * choice
     *
     * @param min the lowest number choice in menu choice
     * @param max the greatest number choice in menu choice
     * @return choice after validating
     */
    public int checkInputLimitChoices(int min, int max) {
        int result = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
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
    
    public String checkAccountNumber(ArrayList<Account> la, String accountNumber) {
        for (Account account : la) {
            if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                
            }
        }
    }
}
