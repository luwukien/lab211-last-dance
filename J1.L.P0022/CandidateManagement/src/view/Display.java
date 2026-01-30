package view;

import controller.CandidateController;
import model.Candidate;
import model.GraduationType;
import utility.DataHelper;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 27/01/2026
 */
public class Display {
    private final DataHelper dataHelper = new DataHelper();
    private final CandidateController controller;


    public Display(CandidateController controller) {
        this.controller = controller;
    }

    public int displayMenu() {
        System.out.println("============== Candidate Management Program ==============");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");

        int choice = dataHelper.checkInputLimitChoices("Enter your choice: ", 1, 5);
        return choice;
    }

    public void displayHeaderCreate() {
        System.out.println("============ Create New Candidate ============ ");
    }

    public void manageCreation(int type) {
        while (true) {
            displayHeaderCreate();
            Candidate result = controller.createCandidate(type);

            if (result != null) {
                System.out.println("Create success candidate: " + result.getFirstName());
            } else  {
                System.out.println("Create failed!");
            }

            if (!dataHelper.getYesNoChoice("Do you want to continue(Y/N)",
                    "Try again. You can only enter Y/N")) {
                break;
            }
        }
    }

}