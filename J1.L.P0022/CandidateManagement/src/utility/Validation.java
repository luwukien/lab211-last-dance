package utility;

import model.Candidate;

import java.util.ArrayList;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 27/01/2026
 */
public class Validation {

    public boolean checkExistId(ArrayList<Candidate> listCandidate, String idCandidate) {
        for (Candidate candidate : listCandidate) {
            if (candidate.getId().equalsIgnoreCase(idCandidate)) {
                return true;
            }
        }
        return false;
    }
}