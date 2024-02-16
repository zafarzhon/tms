/**
 * @author Zafarzhon_Odilov
 * @link https://github.com/zafarzhon
 */

import java.util.Scanner;

/**
 * 3) пользователь вводит число в консоль, необходимо вывести все числа от 0 до
 * введенного пользователем, которые делятся на 3 и являются нечетными.
 */
public class ThirdTask {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int i = 0;
            while (i != n) {
                if (i % 3 == 0 && i % 2 != 0) {
                    System.out.println(i);
                }
                if (n > 0) {
                    i++;
                } else {
                    i--;
                }
            }
        }
    }
}
