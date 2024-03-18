import java.util.ArrayList;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Director extends Employee implements UnderControlable {
    private final ArrayList<Employee> underControl = new ArrayList<>();

    public Director(String name, String surname, int workExperienceInMonth,
                    Post post) {
        super(name, surname, workExperienceInMonth, post);
    }

    @Override
    public void addUnderControl(Employee employee) {
        underControl.add(employee);
    }

    @Override
    public ArrayList<Employee> getUnderControls() {
        return underControl;
    }

}
