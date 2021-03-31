package mk.ukim.finki.emt.library.model.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException() {
        super("Author was not found.");
    }
}
