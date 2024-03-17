/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public abstract class Doctor {

    abstract String treat();

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
