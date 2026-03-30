package controller;

import model.*;
import utility.DataHelper;
import view.Display;

import java.util.ArrayList;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 27/01/2026
 */
public class CandidateController {
    private final ArrayList<Candidate> listCandidate;
    private final DataHelper dataHelper = new DataHelper();
    private final CandidateService candidateService;
    private final Display display = new Display();
    public static final int INTERNSHIP_CANDIDATE_ID = 3;
    public static final int FRESHER_CANDIDATE_ID = 2;
    public static final int EXPERIENCE_CANDIDATE_ID = 1;

    public CandidateController(ArrayList<Candidate> listCandidate, CandidateService candidateService) {
            this.listCandidate = listCandidate;
        this.candidateService = candidateService;
    }

    public ArrayList<Candidate> getListCandidate() {
        return listCandidate;
    }

    public void run() {
        while (true) {
            int choice = display.displayMenu();
            switch (choice) {
                case 1:
                    manageCreation(EXPERIENCE_CANDIDATE_ID);
                    break;
                case 2:
                    manageCreation(FRESHER_CANDIDATE_ID);
                    break;
                case 3:
                    manageCreation(INTERNSHIP_CANDIDATE_ID);
                    break;
                case 4:
                    displayManageSearch();
                    break;
                case 5:
                    return;
            }
        }
    }

    /**
     * Create a type candidate, and add the list Candidate return Candidate type
     *
     * @param type the type of candidate(1-Intern; 2-Fresher; 3-Experience)
     * @return if the system create successfully , it will return a new Candidate
     */
    public Candidate createCandidate(int type) {
        Candidate newCandidate = null;

        String idCandidate = dataHelper.inputUniqueId(candidateService,"Enter id: ",
                "The id existed. Try again!!!");
        String firstName = dataHelper.inputString("Enter first name: ");
        String lastName = dataHelper.inputString("Enter last name: ");
        int birthDate = dataHelper.inputBirthDate("Enter birth date: ",
                "Birth date must be > 1900 and <= year now");
        String address = dataHelper.inputString("Enter address: ");
        String phone = dataHelper.inputPhone("Enter phone: ",
                "The phone number must be > 10 number and must be a number. Try again!!! ");
        String email = dataHelper.inputEmail("Enter email format <account name>@<domain> (eg: annguyen@fpt.edu.vn): ",
                "Wrong format. Try again!!!");

        switch (type) {
            case 1:
                newCandidate = createExperience(idCandidate, firstName, lastName, birthDate, address, phone, email);
                break;
            case 2:
                newCandidate = createFresher(idCandidate, firstName, lastName, birthDate, address, phone, email);
                break;
            case 3:
                newCandidate = createIntern(idCandidate, firstName, lastName, birthDate, address, phone, email);
                break;
        }

        if (newCandidate != null) {
            candidateService.addCandidate(newCandidate);
        }
        return newCandidate;
    }


    private Intern createIntern(String id, String firstName, String lastName, int birthDate,
                                String address, String phone, String email) {
        String major = dataHelper.inputString("Enter Major: ");
        String semester = dataHelper.inputString("Enter Semester: ");
        String university = dataHelper.inputString("Enter University Name: ");

        return new Intern(id, firstName, lastName, birthDate,
                address, phone, email, CandidateType.getCandidateById(INTERNSHIP_CANDIDATE_ID),
                major, semester, university);
    }

    private Experience createExperience(String id, String firstName, String lastName, int birthDate,
                                        String address, String phone, String email) {
        int yearExperience = dataHelper.inputExperience("Enter year experience of experience candidate: ",
                "Experience number must be > 0 and < 100. Try again!!!");
        String skill = dataHelper.inputString("Enter Professional Skill: ");

        return new Experience(id, firstName, lastName, birthDate,
                address, phone, email, CandidateType.getCandidateById(EXPERIENCE_CANDIDATE_ID),
                yearExperience, skill);
    }

    private Fresher createFresher(String id, String firstName, String lastName, int birthDate,
                                  String address, String phone, String email) {
        String graduatedDate = dataHelper.inputString("Enter Graduation Date: ");
        String graduatedRank = dataHelper.inputGraduationRank("Enter type of graduation: ");
        String university = dataHelper.inputString("Enter University: ");
        return new Fresher(id, firstName, lastName, birthDate,
                address, phone, email, CandidateType.getCandidateById(FRESHER_CANDIDATE_ID),
                graduatedDate, graduatedRank, university) ;
    }

    /**
     *  Display result of a method createCandidate in {@link CandidateController}. Then, get the choice from user Y/N to
     *  continue creating a new candidate
     *
     * @param type the type of candidate(1-Intern; 2-Fresher; 3-Experience)
     */
    public void manageCreation(int type) {
        while (true) {
            display.displayHeaderCreate();
            Candidate result = createCandidate(type);

            if (result != null) {
                System.out.println("Create success candidate: " + result.getFirstName());
            } else  {
                System.out.println("Create failed!");
            }

            if (!dataHelper.getYesNoChoice("Do you want to continue(Y/N): ",
                    "Try again. You can only enter Y/N")) {
                break;
            }
        }
    }

    public void displayManageSearch() {
        ArrayList<Candidate> listCandidate = getListCandidate();

        if (listCandidate.isEmpty()) {
            System.out.println("No any candidate to display!!!");
            return;
        }
        display.displayAllCandidate(listCandidate);

        String foundName = dataHelper.inputString("Input Candidate name (First name or Last name): ");

        int foundType = dataHelper.inputCandidateType("Input type of candidate: ").getId();
        ArrayList<Candidate> foundCandidates = candidateService.findCandidateByName(foundName, foundType);

        if (foundCandidates.isEmpty()) {
            System.out.println("Not found any candidate name: " + foundName);
            return;
        }

        System.out.println("The candidates found:");
        for (Candidate foundCandidate : foundCandidates) {
            display.displayCandidate(foundCandidate);
        }
    }
}