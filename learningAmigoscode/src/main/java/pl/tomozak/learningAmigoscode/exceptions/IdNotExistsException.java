package pl.tomozak.learningAmigoscode.exceptions;



public class IdNotExistsException extends RuntimeException {

    private static final String EXCEPTION_MESSAGE = "Id not exist!";

    public IdNotExistsException(){
        super(EXCEPTION_MESSAGE);
    }
}
