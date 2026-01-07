package utilities;

import java.util.Scanner;

/**
 *
 * @author IdeaPad
 */
public class Validation {

    private final Scanner sc = new Scanner(System.in);

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
                System.out.println("Input must be a number. Please try again: ");
            }
        }
        return result;
    }
    
    public String inputString() {
        boolean isValid = false;
        String result = "";
        
        while(!isValid) {
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
    
    
}
