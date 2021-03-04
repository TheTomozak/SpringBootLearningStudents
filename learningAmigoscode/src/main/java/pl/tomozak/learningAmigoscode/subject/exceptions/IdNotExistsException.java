package pl.tomozak.learningAmigoscode.subject.exceptions;



public class IdNotExistsException extends RuntimeException {

    private static final String EXCEPTION_MESSAGE = "Id not exist!";

    public IdNotExistsException(){
        super(EXCEPTION_MESSAGE);
    }
}
