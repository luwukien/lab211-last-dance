package controller;

import model.*;
import utility.DataHelper;

import java.util.ArrayList;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 27/01/2026
 */
public class CandidateController {
    private final DataHelper dataHelper = new DataHelper();
    public static final int INTERNSHIP_CANDIDATE_ID = 3;
    public static final int FRESHER_CANDIDATE_ID = 2;
    public static final int EXPERIENCE_CANDIDATE_ID = 1;
    private ArrayList<Candidate> listCandidate;

    /**
     *
     * @param listCandidate
     */
    public CandidateController(ArrayList<Candidate> listCandidate) {
            this.listCandidate = listCandidate;
    }

    public ArrayList<Candidate> getListCandidate() {
        return listCandidate;
    }

    /**
     * Create a type candidate, and add the list Candidate return Candidate type
     *
     * @param type the type of candidate(1-Intern; 2-Fresher; 3-Experience)
     * @return if the system create successfully , it will return a new Candidate
     */
    public Candidate createCandidate(int type) {
        Candidate newCandidate = null;

        String idCandidate = dataHelper.inputUniqueId(listCandidate, "Enter id: ",
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
            listCandidate.add(newCandidate);
        }
        return  newCandidate;
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
     * Find Candidate by name
     *
     * @param nameFound the parameter name who the user want to find
     * @param type the type of candidate(1-Intern; 2-Fresher; 3-Experience)
     * @return a list Candidate found if the system found by name, otherwise return an empty list
     */
    public ArrayList<Candidate> findCandidateByName(String nameFound, int type) {
        nameFound = nameFound.toLowerCase();
        ArrayList<Candidate> foundCandidates = new ArrayList<>();
        for (Candidate candidate : listCandidate) {
            if (candidate.getType().getId() == type) {
                if (candidate.getFirstName().toLowerCase().contains(nameFound) ||
                        candidate.getLastName().toLowerCase().contains(nameFound)) {
                    foundCandidates.add(candidate);
                }
            }
        }
        return foundCandidates;
    }

}