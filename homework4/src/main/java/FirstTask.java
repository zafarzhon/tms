/**
 * @author Zafarzhon_Odilov
 * @link https://github.com/zafarzhon
 */

import java.util.Arrays;

/**
 * 1) дан массив целых чисел. Необходимо:
 * - найти среднее арифметическое всех чисел
 * - скопировать в новый массив но в обратном порядке [1,2,3,4]->[4,3,2,1]
 * - найти любое число которое повторяется
 */
public class FirstTask {
    public static void main(String[] args) {
        int[] array = RandomIntArrayGenerator.getArray(15);
        System.out.println("Base array: " + Arrays.toString(array));
        System.out.println("Среднее арифметическое: " + getArithmeticMean(array));
        System.out.println("Reversed array: " + Arrays.toString(getReverseArray(array)));
        System.out.println("любое число которое повторяется: " + findAnyRepeatNumber(array));
    }

    private static int getArithmeticMean(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    private static int[] getReverseArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[array.length - 1 - i] = array[i];
        }
        return newArray;
    }

    private static int findAnyRepeatNumber(int[] array) {
        for (int j : array) {
            int count = 0;
            for (int k : array) {
                if (j == k) {
                    count++;
                    if (count == 2) {
                        return j;

                    }
                }
            }
        }
        return Integer.MIN_VALUE;
    }

}
