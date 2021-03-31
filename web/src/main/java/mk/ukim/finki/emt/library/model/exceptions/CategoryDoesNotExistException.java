package mk.ukim.finki.emt.library.model.exceptions;

public class CategoryDoesNotExistException extends RuntimeException{
    public CategoryDoesNotExistException() {
        super("Category does not exist.");
    }
}
