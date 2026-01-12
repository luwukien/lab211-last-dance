package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import model.Task;

/**
 *
 * @author IdeaPad
 */
public class Validation {

    private final Scanner sc = new Scanner(System.in);
    private final String VALID_FORMAT = "([0-9]{1,2}\\.5|[0-9]{1,2}\\.0)$";

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
            String date = sc.nextLine().trim();

            if (date.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            }

            try {
                result = formatDate.parse(date);
                Date now = new Date();

                if (result.before(now)) {
                    System.out.println("Date must be in the future or today! Please try again.");
                    continue;
                }
                isValid = true;
            } catch (NumberFormatException e) {
                System.err.println("Wrong format number. Please try again: ");
            } catch (ParseException e) {
                System.err.println("Wrong format date. Please try again(dd-MM-yyy): ");
            }
        }
        return result;
    }

    public String inputPlanTime() {
        String result = "";

        while (true) {
            String time = inputString();
            if (time.matches(VALID_FORMAT) && Double.parseDouble(time) >= 8.0 && Double.parseDouble(time) <= 17.5) {
                result = time;
                break;
            } else {
                System.err.println("The format plan must be Hours.5 or Hours.0");
                System.out.println("Please try again: ");
            }
        }

        return result;

    }

    public int inputInt() {
        int result = 0;

        while (true) {
            try {
                int inputInt = Integer.parseInt(sc.nextLine().trim());
                if (inputInt > 0) {
                    result = inputInt;
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

    public String inputTaskType() {
        int choice = checkInputLimitChoices(1, 4);
        String result = "";
        switch (choice) {
            case 1:
                result = "Code";
                break;
            case 2:
                result = "Test";
                break;
            case 3:
                result = "Design";
                break;
            case 4:
                result = "Review";
                break;
        }
        return result;
    }

    /**
     * This method helps check id task is exist in list
     * 
     * @param id id task 
     * @param allTask the list task in array list task
     * @return
     */
    public boolean checkExistIdTask(int id, ArrayList<Task> allTask) {
        boolean isExsit = false;

        for (Task task : allTask) {
            if (task.getId() == id) {
                isExsit = true;
                break;
            }
        }
        return isExsit;
    }
}
