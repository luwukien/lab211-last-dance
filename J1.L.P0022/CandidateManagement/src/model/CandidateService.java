package model;

import java.util.ArrayList;

public class CandidateService {
    private ArrayList<Candidate> listCandidate = new ArrayList<>();

    public CandidateService(ArrayList<Candidate> listCandidate) {
        this.listCandidate = listCandidate;
    }

    /**
     *
     * @param idCandidate
     * @return
     */
    public boolean checkExistId(String idCandidate) {
        boolean result = false;
        for (Candidate candidate : listCandidate) {
            if (candidate.getId().equalsIgnoreCase(idCandidate)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Find Candidate by name
     *
     * @param nameFound the parameter name who the user want to find
     * @param type      the type of candidate(1-Intern; 2-Fresher; 3-Experience)
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

    /**
     *
     * @param candidate
     */
    public void addCandidate(Candidate candidate) {
        this.listCandidate.add(candidate);
    }

}
