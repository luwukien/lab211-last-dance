package model;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 19/01/2026
 */

public class Student {
    private String id;
    private String studentName;
    private String semester;
    private CourseType courseName;

    public Student() {

    }

    /**
     * @param id
     * @param studentName
     * @param semester
     * @param courseName
     */
    public Student(String id, String studentName, String semester, CourseType courseName) {
        this.courseName = courseName;
        this.semester = semester;
        this.studentName = studentName;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public CourseType getCourseName() {
        return courseName;
    }

    public void setCourseName(CourseType courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", studentName='" + studentName + '\'' +
                ", semester='" + semester + '\'' +
                ", courseName=" + courseName +
                '}';
    }


}
