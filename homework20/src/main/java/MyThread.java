/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i <= 10_000_000; i++) {
            sum = i;
        }
        System.out.println(Thread.currentThread().getName() +" : with class :" +
                " "+ sum);
    }
}
