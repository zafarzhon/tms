/**
 * @author Zafarzhon_Odilov
 * @link https://github.com/zafarzhon
 */

import java.util.Scanner;

/**
 * 1) пользователь вводит число с консоли (меньше 10_000). Необходимо вывести какое количество тысяч, сотен, десятков,
 * единиц есть в этом числе. Так же вывести информацию сколько у числа знаков.
 * Пример - ввод 235, вывод - 2 сотни, 3 десятка, 5 единиц, всего 3 знака
 */
public class FirstTask {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            if (n <= 0 || n >= 10000) {
                System.err.println("n great 10000 or less 0!");
            } else {
                int signs = (int) Math.log10(n) + 1;
                int tempSigns = signs;
                if (signs == 4) {
                    System.out.print(n / 1000 + " тысяч, ");
                    n %= 1000;
                    signs--;
                }
                if (signs == 3) {
                    System.out.print(n / 100 + " сотни, ");
                    n %= 100;
                    signs--;
                }
                if (signs == 2) {
                    System.out.print(n / 10 + " десятка, ");
                    n %= 10;
                    signs--;
                }
                if (signs == 1) {
                    System.out.print(n % 10 + " единиц, ");
                }
                System.out.println("всего " + tempSigns + " знака");
            }
        }
    }
}
