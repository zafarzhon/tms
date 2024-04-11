import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
@Data
@AllArgsConstructor
public class Store {
    private int id;
    private String city;
    private String address;
    private String phoneNumber;


}
