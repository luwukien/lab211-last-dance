import controller.CandidateController;
import model.Candidate;
import view.Display;

import java.util.ArrayList;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 26/01/2026
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Candidate> listCandidate = new ArrayList<>();
        CandidateController controller = new CandidateController();
        Display display = new Display();

        while (true) {
            int choice = display.displayMenu();
            switch (choice) {
                case 1:
                    controller.createCandidate(listCandidate, display, choice);
                case 2:
                    controller.createCandidate(listCandidate, display, choice);
                case 3:
                    controller.createCandidate(listCandidate, display, choice);
                case 5:
                    return;
            }
        }

    }
}