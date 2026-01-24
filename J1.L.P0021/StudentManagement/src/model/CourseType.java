package model;

public enum CourseType {
    JAVA(1, "Java"),
    NET(2, ".Net"),
    C(3, "C/C++");

    private final int id;
    private final String courseName;

    CourseType(int id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    /**
     * @param id
     * @return
     */
    public static CourseType getById(int id) {
        CourseType result = null;

        for (CourseType course : values()) {
            if (course.getId() == id) {
                result = course;
                break;
            }
        }
        return result;
    }
}
