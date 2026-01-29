package utility;

import model.Candidate;

import java.util.ArrayList;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 27/01/2026
 */
public class Validation {

    /**
     *
     * @param listCandidate
     * @param idCandidate
     * @return
     */
    public boolean checkExistId(ArrayList<Candidate> listCandidate, String idCandidate) {
        boolean isExist = false;
        for (Candidate candidate : listCandidate) {
            if (candidate.getId().equalsIgnoreCase(idCandidate)) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }
}