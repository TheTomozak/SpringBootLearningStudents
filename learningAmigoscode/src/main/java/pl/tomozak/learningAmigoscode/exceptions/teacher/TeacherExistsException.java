package pl.tomozak.learningAmigoscode.exceptions.teacher;

public class TeacherExistsException extends RuntimeException {

    private final static String MESS_ERROR = "Teacher with the given name and last name exists!";

    public TeacherExistsException() {
        super(MESS_ERROR);
    }
}
