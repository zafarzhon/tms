/**
 * @author Zafarzhon_Odilov
 * @link https://github.com/zafarzhon
 */

import java.util.Scanner;

/**
 * 2) пользователь вводит название месяца в консоль, необходимо вывести какой это сезон.
 * Сделать два решения - используя if и используя switch
 */
public class SecondTask {
    public static void main(String[] args) {
        System.out.println("months called in my program: january february  mart april may june july august september october november december");
        try (Scanner scanner = new Scanner(System.in)) {
            String month = scanner.next().trim().toLowerCase();
            printSeasonWithSwitch(month);
            printSeasonWithIf(month);
        }
    }

    private static void printSeasonWithIf(String month) {
        if (month.equals("january") || month.equals("february") || month.equals("december")) {
            System.out.println("Winter");
        } else if (month.equals("mart") || month.equals("april") || month.equals("may")) {
            System.out.println("Spring");
        } else if (month.equals("june") || month.equals("july") || month.equals("august")) {
            System.out.println("Summer");
        } else if (month.equals("september") || month.equals("october") || month.equals("november")) {
            System.out.println("Autumn");
        } else {
            System.err.println("Wrong!!!");
        }
    }

    private static void printSeasonWithSwitch(String month) {
        switch (month) {
            case "january", "february", "december":
                System.out.println("Winter");
                break;
            case "mart", "april", "may":
                System.out.println("Spring");
                break;
            case "june", "july", "august":
                System.out.println("Summer");
                break;
            case "september", "october", "november":
                System.out.println("Autumn");
                break;
            default:
                System.err.println("Wrong!!!");
        }
    }
}
