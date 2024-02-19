/**
 * @author Zafarzhon_Odilov
 * @link https://github.com/zafarzhon
 */

/**
 * Блок 2. Домашнее задание
 * Задача 1:
 * Написать приложение, которое будет вычислять и выводить значение по формуле:
 * a=4*(b+c-1)/2; b и c задаем в коде самостоятельно.
 * Задача 2:
 * В переменной n хранится двузначное число. Создайте программу, вычисляющую и
 * выводящую на экран сумму цифр n. Например: n =26, в результате мы должны получить 8
 * (2+6).
 * Задача 3:
 * В переменной n хранится трёхзначное число. Создайте программу, вычисляющую и
 * выводящую на экран сумму цифр n. Например: n =126, в результате мы должны получить
 * 9 (1+2+6).
 * Задача 4:
 * В переменной n хранится вещественное число с ненулевой дробной частью. Создайте
 * программу, округляющую число n до ближайшего целого и выводящую результат на
 * экран.
 * Задача 5:
 * В переменных q и w хранятся два натуральных числа. Создайте программу, выводящую
 * на экран результат деления q на w с остатком. Пример вывода программы (для случая,
 * когда в q хранится 21, а в w хранится 8): 21 / 8 = 2 и 5 в остатке.
 * Задача *:
 * Написать программу которая будет менять местами значение целочисленных
 * переменных. Пример:
 * int a = 1; int b = 2;
 * //код (ваше решение)
 * sout(a); //выведет 2
 * sout(b); //выведет 1
 * Усовершенствовать программу, использовать только 2 входные переменные (a,b)
 */
public class SecondBlock {
    public static void main(String[] args) {
        System.out.println("firstTask()");
        firstTask();
        System.out.println("secondTask()");
        secondTask();
        System.out.println("thirdTask()");
        thirdTask();
        System.out.println("fourthTask()");
        fourthTask();
        System.out.println("fifthTask()");
        fifthTask();
        System.out.println("starTask()");
        starTask();
    }

    private static void starTask() {
        int a = 7;
        int b = 1;
        a = a+b;
        b = a-b;
        a=a-b;
        System.out.println("a = "+a+", b = "+b);
    }

    private static void fifthTask() {
        int q = 21;
        int w = 8;
        System.out.println(q%w);
    }

    private static void fourthTask() {
        double n = 2.6;
        System.out.println(Math.round(n));
    }

    private static void thirdTask() {
        int n = 231;
        int res = n/100+n/10%10+n%10;
        System.out.println(res);
    }

    private static void secondTask() {
        int n = 23;
        int res = n/10+n%10;
        System.out.println(res);
    }

    public static void firstTask(){
        int b = 2;
        int c = 7;
        double a = 4*(b+c-1)/2.0;
        System.out.println(a);
    }
}
