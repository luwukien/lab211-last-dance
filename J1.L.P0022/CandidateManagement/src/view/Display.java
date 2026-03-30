package view;

import controller.CandidateController;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import utility.DataHelper;

import java.util.ArrayList;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 27/01/2026
 */
public class Display {
    private final DataHelper dataHelper = new DataHelper();

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

    public void displayHeaderFresherCandidate() {
        System.out.println("============ Fresher Candidate ============ ");
    }

    public void displayHeaderInternCandidate() {
        System.out.println("============ Intern Candidate ============ ");
    }

    public void displayHeaderExperienceCandidate() {
        System.out.println("============ Experience Candidate ============ ");
    }

    public void displayCandidate(Candidate candidate) {
        String fullName = candidate.getFirstName() + " " + candidate.getLastName();
        System.out.printf("%-20s | %-4d | %-20s | %-12s | %-25s | %-3s\n", fullName, candidate.getBirthDate(),
                candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getType().getId());
    }

    public void displayAllCandidate(ArrayList<Candidate> listCandidate) {
        ArrayList<Candidate> internList = new ArrayList<>();
        ArrayList<Candidate> fresherList = new ArrayList<>();
        ArrayList<Candidate> experienceList = new ArrayList<>();

        for (Candidate candidate : listCandidate) {
            if (candidate instanceof Intern) {
                internList.add(candidate);
            } else if (candidate instanceof Fresher) {
                fresherList.add(candidate);
            } else if (candidate instanceof Experience) {
                experienceList.add(candidate);
            }
        }
        System.out.println("The list candidate:");
        if (!internList.isEmpty()) {
            displayHeaderInternCandidate();
            for (Candidate candidate : internList) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

        if (!fresherList.isEmpty()) {
            displayHeaderFresherCandidate();
            for (Candidate candidate : fresherList) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

        if (!experienceList.isEmpty()) {
            displayHeaderExperienceCandidate();
            for (Candidate candidate : experienceList) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

    }
}