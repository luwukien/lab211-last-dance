package model;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 27/01/2026
 */
public class Fresher extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
        super();
    }

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param address
     * @param phone
     * @param email
     * @param type
     * @param graduationDate
     * @param graduationRank
     * @param education
     */
    public Fresher(String id, String firstName, String lastName, int birthDate,
                   String address, String phone, String email, CandidateType type,
                   String graduationDate, String graduationRank, String education) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}