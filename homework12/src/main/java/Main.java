import Service.ValidateService;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) {
        boolean isValid = ValidateService.validateLoginAndPassword("admin",
                "admin1",
                "admin1");

        System.out.println(isValid);

    }
}
