/**
 * @author Zafarzhon_Odilov
 * @link https://github.com/zafarzhon
 */

import java.util.Arrays;

/**
 * 3)* дан массив целых чисел. Необходимо:
 * - найти какое число встречается больше всего раз [1,2,3,4,2,5,7,3,2] -> число 2
 */
public class ThirdTask {
    public static void main(String[] args) {
        int[] array = RandomIntArrayGenerator.getArray(8);
        System.out.println("Base array: " + Arrays.toString(array));
        int count = 0;
        int number = 0;
        for (int k : array) {
            int localCount = 0;
            for (int i : array) {
                if (k == i) {
                    localCount++;
                }
            }
            if (localCount > count) {
                number = k;
                count = localCount;
            }
        }
        System.out.println(number);
    }
}
