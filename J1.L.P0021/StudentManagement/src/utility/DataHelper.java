package utility;

import model.CourseType;

import java.util.Scanner;

/**
 * @author Chi Kien-Luu | github/luwukien
 * Initialize Date: 19/01/2026
 */

public class DataHelper {
    private final Scanner sc = new Scanner(System.in);
    private final String YES_CHOICE = "Y";
    private final String NO_CHOICE = "N";
    private final String UPDATE_CHOICE = "U";
    private final String DELETE_CHOICE = "D";

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
                System.out.print(msg);
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
     * This method helps the string valid when users enter a string
     *
     * @param msg the prompt message require input
     * @return a string if it is valid
     */
    public String inputString(String msg) {
        boolean isValid = false;
        String result = "";

        while (!isValid) {
            System.out.println(msg);
            String inputStr = sc.nextLine().trim();
            if (inputStr.isEmpty()) {
                System.err.println("String must be enter at least 1 character");
                System.out.print("Enter again: ");
            } else {
                result = inputStr;
                isValid = true;
            }
        }
        return result;
    }

    /**
     * This method helps the system get Yes/No choice from the user
     *
     * @param msg       the prompt message require input
     * @param formatMsg the prompt message will be displayed if input user not valid
     * @return true if user enter Y/y, otherwise false if input is N/n
     */
    public boolean getYesNoChoice(String msg, String formatMsg) {
        boolean result = false;
        boolean isValid = false;
        while (!isValid) {
            String choice = inputString(msg);

            if (choice.equalsIgnoreCase(YES_CHOICE)) {
                result = true;
                isValid = true;
            }

            if (choice.equalsIgnoreCase((NO_CHOICE))) {
                result = false;
                isValid = true;
            }
            System.err.println(formatMsg);
        }
        return result;
    }

    /**
     * This method helps the system get Update/Delete choice from the user
     *
     * @param msg       the prompt message require input
     * @param formatMsg the prompt message will be displayed if input user not valid
     * @return true if user enter U/u, otherwise false if input is D/d
     */
    public boolean getUpdateDelete(String msg, String formatMsg) {
        while (true) {
            String choice = inputString(msg);
            if (choice.equalsIgnoreCase(UPDATE_CHOICE)) {
                return true;
            }

            if (choice.equalsIgnoreCase((DELETE_CHOICE))) {
                return false;
            }
            System.err.println(formatMsg);
            System.out.println(msg);
        }
    }

    /**
     * Getting the type of course the choice from the user
     *
     * @param msg the prompt message require input
     * @return CourseType based on the choice of user
     */
    public CourseType inputCourseName(String msg) {
        System.out.println("1. Java");
        System.out.println("2. .Net");
        System.out.println("3. C/C++");

        int choice = checkInputLimitChoices(msg, 1, 3);
        CourseType course = CourseType.getById(choice);

        return course;
    }


}
