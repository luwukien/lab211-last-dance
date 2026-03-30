import controller.CandidateController;
import model.Candidate;
import model.CandidateService;
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
        CandidateService candidateService = new CandidateService(listCandidate);
        CandidateController controller = new CandidateController(listCandidate, candidateService);
        controller.run();


    }
}