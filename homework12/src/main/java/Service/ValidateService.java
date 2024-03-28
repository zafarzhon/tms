package Service;

import CustomExceptions.InvalidLoginException;
import CustomExceptions.InvalidPasswordException;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class ValidateService {
    public static boolean validateLoginAndPassword(
            final String login,
            final String password,
            final String confirmPassword) {
        try {
            validateLogin(login);
        } catch (InvalidLoginException e) {
            return false;
        }
        try {
            validatePassword(password, confirmPassword);
        } catch (InvalidPasswordException e) {
            return false;
        }
        return true;
    }

    private static void validateLogin(final String login) throws InvalidLoginException {
        if (login.contains(" ") || (login.length() < 4 || login.length() > 20)) {
            throw new InvalidLoginException("Invalid login");
        }
    }

    private static void validatePassword(final String password,
                                         final String confirmPassword)
            throws InvalidPasswordException {
        if (!password.equals(confirmPassword)
                || password.contains(" ")
                || (password.length() < 4 || password.length() > 20)
                || !password.matches(".*\\d+.*")
        ) {
            throw new InvalidPasswordException("Invalid password");
        }
    }
}
