package utilities;

import java.util.ArrayList;
import java.util.Scanner;
import model.Country;

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

    public double inputDouble() {
        double result = 0.0;


        while (true) {
            try {
                double inputDouble = Double.parseDouble(sc.nextLine().trim());
                if (inputDouble > 0) {
                    result = inputDouble;
                    break;
                }
                System.out.println("Input double must be > 0. Please try again: ");
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                System.out.println("Input must be a number. Please try again: ");
            }
        }
        return result;
    }
    
    //check exist country by code
    public boolean checkCodeCountry(ArrayList<Country> lc, String countryCode) {
        boolean isExist = false;
        for (Country country : lc) {
            if (countryCode.equalsIgnoreCase(country.getCountryCode())) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }
    
    
}
