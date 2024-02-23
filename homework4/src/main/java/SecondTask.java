/**
 * @author Zafarzhon_Odilov
 * @link https://github.com/zafarzhon
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2) пользователь вводит число элементов в массиве. Необходимо создать массив данной длинны, заполнив их целыми числами,
 * первые два элемента которых 0 и 1, а каждое следующее равно сумме двух предыдущих.
 */
public class SecondTask {
    public static void main(String[] args) {
        int length;
        try (Scanner scanner = new Scanner(System.in)) {
            length = scanner.nextInt();
        }
        int[] array = new int[length];
        int x = 1;
        int y = 0;
        int z;
        for (int i = 0; i < length; i++) {
            z = x + y;
            x = y;
            y = z;
            array[i] = x;
        }
        System.out.println(Arrays.toString(array));
    }
}
