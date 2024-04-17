/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        firstTask();
        secondTask();
//        thirdTask();
        fourthTask();
    }

    private static void firstTask() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i <= 10_000_000; i++) {
                sum = i;
            }
            System.out.println(Thread.currentThread().getName() + " : with " +
                    "Runnable" +
                    " : " + sum);
        });
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(Thread.currentThread().getName() + ": finished");
    }

    private static void secondTask() throws InterruptedException {
        int[] nums = new int[10_000_000];
        for (int i = 0; i < 10_000_000; i++) {
            nums[i] = i;
        }

        Thread thread1 = new Thread(() -> {
            int max = nums[0];
            for (int i = 1; i < 10_000_000; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            System.out.println(max);
        });
        Thread thread2 = new Thread(() -> {
            int min = nums[0];
            for (int i = 1; i < 10_000_000; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                }
            }
            System.out.println(min);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    private static void thirdTask() throws InterruptedException {
        Thread daemon = new Thread(()->{
            while(true){
                System.out.println("I'm daemon thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        daemon.setDaemon(true);
        daemon.start();
        Thread.sleep(5000);
    }

    private static void fourthTask() {
        Thread thread1 = new Thread(()->{
            while(true){
                synchronized (Main.class){
                    for(int i = 0;i<3;i++){
                        System.out.println(1);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        Thread thread2 = new Thread(()->{
            while(true){
                synchronized (Main.class){
                    for(int i = 0;i<3;i++){
                        System.out.println(2);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
