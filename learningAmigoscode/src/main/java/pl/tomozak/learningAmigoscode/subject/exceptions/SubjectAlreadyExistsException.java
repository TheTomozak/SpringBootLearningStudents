package pl.tomozak.learningAmigoscode.subject.exceptions;

public class SubjectAlreadyExistsException extends RuntimeException {

    private static final String EXCEPTION_MESSAGE = "Subject with this tile exist!";

    public SubjectAlreadyExistsException(){
        super(EXCEPTION_MESSAGE);
    }
}
