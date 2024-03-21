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
        return validateLogin(login) && validatePassword(password,
                confirmPassword);
    }

    private static boolean validateLogin(final String login) {
        if (login.contains(" ") || (login.length() < 4 || login.length() > 20)) {
            try {
                throw new InvalidLoginException("Invalid login");
            } catch (InvalidLoginException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    private static boolean validatePassword(final String password,
                                            final String confirmPassword) {
        if (password != confirmPassword
                || password.contains(" ")
                || (password.length() < 4 || password.length() > 20)
                || !password.matches(".*\\d+.*")
        ) {
            try {
                throw new InvalidPasswordException("Invalid password");
            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }
}
