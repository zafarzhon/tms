/**
 * @author Zafarzhon_Odilov
 * @link https://github.com/zafarzhon
 */
public class RandomIntArrayGenerator {
    public static int[] getArray(int length) {
        if (length < 1) {
            length = 10;
        }
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 10 - Math.random() * 5);
        }
        return array;
    }
}
