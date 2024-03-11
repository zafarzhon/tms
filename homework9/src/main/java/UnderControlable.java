import java.util.ArrayList;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public interface UnderControlable {
    void addUnderControl(Employee employee);

    ArrayList<Employee> getUnderControls();
}
