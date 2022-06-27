package MVC;

public class Main {
    public static void main(String[] args) {
        // get student info
        StudentModel model = retriveStudentFromDatabase();

        // create view : to write student details to console
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        // update model
        controller.setStudentName("John");
        controller.updateView();
    }

    private static StudentModel retriveStudentFromDatabase() {
        StudentModel student = new StudentModel();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
