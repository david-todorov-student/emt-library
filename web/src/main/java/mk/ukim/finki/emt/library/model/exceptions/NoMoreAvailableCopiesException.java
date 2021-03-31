package mk.ukim.finki.emt.library.model.exceptions;

public class NoMoreAvailableCopiesException extends RuntimeException {
    public NoMoreAvailableCopiesException(String name) {
        super("There are no more available copies for "+name);
    }
}
