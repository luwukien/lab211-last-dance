import controller.StudentController;
import model.Student;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> listStudent = new ArrayList<>();
        StudentController controller = new StudentController(listStudent);

        controller.run();
    }
}