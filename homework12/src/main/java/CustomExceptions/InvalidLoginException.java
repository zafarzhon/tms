package CustomExceptions;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class InvalidLoginException extends Exception {
    public InvalidLoginException() {
    }

    public InvalidLoginException(String message) {
        super(message);
    }
}
