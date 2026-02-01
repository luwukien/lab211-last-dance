package model;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 30/01/2026
 */
public enum GraduationType {
    Poor(1, "Poor"),
    Fair(2, "Fair"),
    Good(3, "Good"),
    Excellence(4, "Excellence");

    private final int id;
    private final String typeGraduation;

    GraduationType(int id, String typeGraduation) {
        this.id = id;
        this.typeGraduation = typeGraduation;
    }

    public int getId() {
        return id;
    }

    public String getTypeGraduation() {
        return typeGraduation;
    }

    public static GraduationType getGraduationById(int id) {
        GraduationType result = null;

        for (GraduationType graduationType : values()) {
            if (graduationType.getId() == id) {
                result = graduationType;
                break;
            }
        }
        return result;
    }
}
