package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

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
    
    public Date inputDate() {
        boolean isValid = false;
        Date result = null;
        
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        formatDate.setLenient(false);
        
        while (!isValid) {
            String date = sc.nextLine();
            
            if (date.isEmpty()) {
                System.out.println("Input could not be empty!!!");
            }            
            
            try {
                result = formatDate.parse(date);
                Date now = new Date();
                
                if (date.before(now)) {
                    continue;
                }
                isValid = true;
            } catch (ParseException e) {
                System.err.println("Wrong format date. Please try again(dd-MM-yyy): ");
            }
        }
        return result;
    }
    
}
