package utility;

import model.Candidate;
import model.CandidateType;
import model.GraduationType;
import view.Display;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 27/01/2026
 */
public class DataHelper {
    private final Scanner sc = new Scanner(System.in);
    private final String FORMAT_EMAIL = "^([A-Za-z0-9])+@([A-Za-z0-9.-])+\\.([A-Za-z])+$";
    private final String FORMAT_PHONE = "^[0-9]{10,}$";
    private final String YES_CHOICE = "Y";
    private final String NO_CHOICE = "N";
    private final int MINIMUM_YEAR_BIRTH = 1990;
    private final Validation validation = new Validation();

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
        while (true) {
            System.out.print(msg);
            String inputStr = sc.nextLine().trim();
            if (inputStr.isEmpty()) {
                System.out.println("String must be enter at least 1 character!!!");
                continue;
            }
            return inputStr;
        }
    }

    /**
     * This method helps validate input integer from user
     *
     * @param msg the prompt requires the user input
     * @return a valid integer > 0.
     */
    public int inputInt(String msg) {
        int result = 0;

        while (true) {
            try {
                System.out.print(msg);
                int inputInteger = Integer.parseInt(sc.nextLine().trim());
                if (inputInteger > 0) {
                    result = inputInteger;
                    break;
                }
                System.out.println("Input must be > 0. Please try again: ");
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                System.out.println("Input must be a number. Please try again: ");
            }
        }
        return result;
    }

    /**
     * This method helps validate input email from user
     *
     * @param msg the prompt requires the user input
     * @param formatMsg display an example valid email if the input from user not valid.
     *                  Then the user must be entered again
     * @return a valid email
     */
    public String inputEmail(String msg, String formatMsg) {
        while(true) {
            String email = inputString(msg);
            if (!email.matches(FORMAT_EMAIL)) {
                System.out.println(formatMsg);
                continue;
            }
            return email;
        }
    }

    /**
     * This method helps validate input phone from user
     *
     * @param msg the prompt requires the user input
     * @param formatMsg display an example valid phone if the input from user not valid.
     *      *                  Then the user must be entered again
     * @return a valid phone
     */
    public String inputPhone(String msg, String formatMsg) {
        while (true) {
            String phone = inputString(msg);
            if (!phone.matches(FORMAT_PHONE)) {
                System.out.println(formatMsg);
                continue;
            }
            return phone;
        }
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
        while (true) {
            String choice = inputString(msg);

            if (choice.equalsIgnoreCase(YES_CHOICE)) {
                result = true;
                break;
            }

            if (choice.equalsIgnoreCase((NO_CHOICE))) {
                result = false;
                break;
            }
            System.err.println(formatMsg);
        }
        return result;
    }

    /**
     *
     * @param msg
     * @param formatMsg
     * @return
     */
    public int inputBirthDate(String msg, String formatMsg) {
        int result = 0;

        while (true) {
            int birthDate = inputInt(msg);
            int currentYear = LocalDate.now().getYear();

            if (birthDate < MINIMUM_YEAR_BIRTH || birthDate > currentYear) {
                System.out.println(formatMsg);
                continue;
            }
            return result;
        }
    }

    /**
     *
     * @param msg
     * @param formatMsg
     * @return
     */
    public int inputExperience(String msg, String formatMsg) {
        while (true) {
            int experience = inputInt(msg);
            if (experience <= 0 || experience >= 100) {
                System.out.println(formatMsg);
                continue;
            }
            return experience;
        }
    }

    /**
     * Display a list candidate to choose by user
     *
     * @param msg the prompt requires the user input
     * @param formatMsg display the prompt require the user enter again if input is wrong
     * @return CourseType Experience, Fresher, Internship
     */
    public CandidateType inputCandidateType(String msg, String formatMsg) {
        System.out.println("1.\tExperience\n" +
                "2.\tFresher\n" +
                "3.\tInternship\n");
        int choice = checkInputLimitChoices(msg, 1, 3);
        return CandidateType.getCandidateById(choice);
    }

    /**
     *
     * @param listCandidate
     * @param msg
     * @param formatMsg
     * @return
     */
    public String inputUniqueId(ArrayList<Candidate> listCandidate, String msg, String formatMsg) {
        String result = null;
        while (true) {
            String idInput = inputString(msg);

            if (!validation.checkExistId(listCandidate, idInput)) {
                result = idInput;
                break;
            }
            System.out.print(formatMsg);
        }
        return result;
    }

    /**
     *
     * @param msg
     * @return
     */
    public String inputGraduationRank(String msg) {
        System.out.println("----------------------------------------------");
        System.out.println("1.\tPoor\n" +
                "2.\tFair\n" +
                "3.\tGood\n" +
                "4.\tExcellence\n");

        int type = checkInputLimitChoices(msg, 1, 4);
        return GraduationType.getGraduationById(type).getTypeGraduation();
    }

}