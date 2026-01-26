package model;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 27/01/2026
 */
public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience() {
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
     * @param expInYear
     * @param proSkill
     */
    public Experience(String id, String firstName, String lastName, int birthDate,
                      String address, String phone, String email, CandidateType type,
                      int expInYear, String proSkill) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }


}