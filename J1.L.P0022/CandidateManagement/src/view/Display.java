package view;

import utility.DataHelper;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 27/01/2026
 */
public class Display {
    private final DataHelper validation = new DataHelper();

    public int displayMenu() {
        System.out.println("============== Candidate Management Program ==============");
        System.out.println("1.\tExperience\n" +
                "2.\tFresher\n" +
                "3.\tInternship\n");
        System.out.println(" 5.	Exit");

        int choice = validation.checkInputLimitChoices("Enter your choice: ", 1, 5);
        return choice;
    }

    public void displayHeaderCreate() {
        System.out.println("============ Create New Candidate ============ ");
    }

    public void displayAllTypeCandidate() {
        System.out.println("----------------------------------------------");
        System.out.println("1.\tExperience\n" +
                "2.\tFresher\n" +
                "3.\tInternship\n");
    }

    public void displayAllTypeGraduation() {
        System.out.println("----------------------------------------------");
        System.out.println("1.\tPoor\n" +
                "2.\tFair\n" +
                "3.\tGood\n" +
                "4.\tExcellence\n");
    }
}