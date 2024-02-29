/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public enum Profession {
    DIRECTOR(3), WORKER(1.5), HR(2.5);

    private final double coefficient;

    Profession(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
