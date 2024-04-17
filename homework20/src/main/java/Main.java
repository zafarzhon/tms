/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()-> {
            int sum = 0;
            for (int i = 0; i <= 10_000_000; i++) {
                sum=i;
            }
            System.out.println(Thread.currentThread().getName() +" : with " +
                    "Runnable" +
                    " : "+ sum);
        });
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(Thread.currentThread().getName()+": finished");

    }
}
