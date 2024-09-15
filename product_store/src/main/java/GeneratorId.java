/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class GeneratorId {
    private static final int high = 10_000_000;
    private static final int low = 1_000_000;

    public static int getRandomId() {
        return (int) (Math.random() * (high - low) + low);
    }
}
