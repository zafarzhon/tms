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
        System.out.println(array[0]);
        if (length >= 2) {
            array[1] = 1;
        }
        for (int i = 2; i < length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        System.out.println(Arrays.toString(array));
    }
}
