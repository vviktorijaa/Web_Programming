package mk.finki.ukim.mk.lab.model.exceptions;

public class BalloonAlreadyExistsException extends RuntimeException {

    public BalloonAlreadyExistsException() {
        super("A balloon with that name already exists!");
    }

}
