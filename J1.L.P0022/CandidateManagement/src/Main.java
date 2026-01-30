import controller.CandidateController;
import model.Candidate;
import view.Display;

import java.util.ArrayList;

import static controller.CandidateController.*;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 26/01/2026
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Candidate> listCandidate = new ArrayList<>();
        CandidateController controller = new CandidateController(listCandidate);
        Display display = new Display(controller);

        while (true) {
            int choice = display.displayMenu();
            switch (choice) {
                case 1:
                    display.manageCreation(EXPERIENCE_CANDIDATE_ID);
                    break;
                case 2:
                    display.manageCreation(FRESHER_CANDIDATE_ID);
                    break;
                case 3:
                    display.manageCreation(INTERNSHIP_CANDIDATE_ID);
                    break;
                case 5:
                    return;
            }
        }

    }
}