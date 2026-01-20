package utility;

import model.CourseType;
import model.Student;

import java.util.ArrayList;

/**
 * @author Chi Kien-Luu | github/luwukien
 * Initialize Date: 19/01/2026
 */

public class Validation {

    /**
     *
     * @param listStudent
     * @param id
     * @param name
     * @param courseType
     * @param semester
     * @return
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

    /**
     *
     * @param listStudent
     * @param id
     * @param name
     * @return
     */
    public boolean isNameMatchWithId(ArrayList<Student> listStudent, String id, String name) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)) {
                if (student.getStudentName().equalsIgnoreCase(name)) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }


}
