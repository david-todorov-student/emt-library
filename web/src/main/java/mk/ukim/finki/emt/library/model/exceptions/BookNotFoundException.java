package mk.ukim.finki.emt.library.model.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
        super("Book does not exist");
    }
}
