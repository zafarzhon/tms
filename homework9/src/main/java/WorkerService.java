import java.util.ArrayList;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class WorkerService {
    public boolean printUnderControls(Employee employee, String name) {
        if (employee instanceof Director) {
            ArrayList<Employee> underControl = ((Director) employee).getUnderControls();
            for (Employee e : underControl) {
                if (e.getName().equalsIgnoreCase(name)) {
                    return true;
                }
                if (e instanceof Director) {
                    return printUnderControls(e, name);
                }
            }
        }
        return false;
    }
}
