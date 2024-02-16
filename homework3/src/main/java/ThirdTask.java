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
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n<=0){
            System.err.println("n must greater than 0!!!");
        }else{
            for(int i = 0;i<n;i++){
                if(i%3==0 && i%2==1){
                    System.out.println(i);
                }
            }
        }
    }
}
