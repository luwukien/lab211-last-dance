package model;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 27/01/2026
 */
public enum CandidateType {
    Experience(1, "Experience"),
    Fresher(2, "Fresher"),
    Internship(3, "Intern");

    private final int id;
    private final String typeCandidate;

    CandidateType(int id, String typeCandidate) {
        this.id = id;
        this.typeCandidate = typeCandidate;
    }

    public int getId() {
        return id;
    }

    public String getTypeCandidate() {
        return typeCandidate;
    }

    public static CandidateType getCandidateById(int id) {
        CandidateType result = null;

        for (CandidateType candidateType : values()) {
            if (candidateType.getId() == id) {
                result = candidateType;
                break;
            }
        }
        return result;
    }
}
