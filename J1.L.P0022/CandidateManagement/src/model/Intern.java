package model;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 27/01/2026
 */
public class Intern extends Candidate {
    private String majors;
    private String semester;
    private String universityName;

    public Intern() {
        super();
    }

    /**
     * @param id
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param address
     * @param phone
     * @param email
     * @param type
     * @param majors
     * @param semester
     * @param universityName
     */
    public Intern(String id, String firstName, String lastName, int birthDate,
                  String address, String phone, String email, CandidateType type,
                  String majors, String semester, String universityName) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}