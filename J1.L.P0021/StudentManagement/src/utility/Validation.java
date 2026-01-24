package utility;

import model.CourseType;
import model.Student;

import java.util.ArrayList;

/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 19/01/2026
 */
public class Validation {

    /**
     * Checks if a student record already exists in the list.
     * Uniqueness is defined by the combination of ID, name, semester, course type.
     *
     * @param listStudent The list of existing students to check again.
     * @param id          the student id
     * @param name        the student name (case-insensitive)
     * @param courseType  the semester (case-insensitive)
     * @param semester    the type of course (Java, .Net, C/C++)
     * @return true if a duplicate is found, false otherwise
     */
    public boolean isDuplicate(ArrayList<Student> listStudent, String id, String name,
                               String semester, CourseType courseType) {

        for (Student student : listStudent) {
            if (student.getStudentName().equalsIgnoreCase(name)
                    && student.getId().equalsIgnoreCase(id)
                    && student.getCourseName().equals(courseType)
                    && student.getSemester().equalsIgnoreCase(semester)) return true;
        }

        return false;
    }


}
