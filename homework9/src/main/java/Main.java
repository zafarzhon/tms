import java.util.ArrayList;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) {
        WorkerService ws = new WorkerService();

        System.out.println("1//");
        Director mainDirector = new Director("Main", "MainDirector", 10,
                Post.DIRECTOR);
        Employee worker1 = new Worker("First", "Worker1", 1, Post.WORKER);
        Employee worker2 = new Worker("Second", "Worker2", 2, Post.WORKER);
        mainDirector.addUnderControl(worker1);
        mainDirector.addUnderControl(worker2);

        System.out.println(mainDirector);
        System.out.println(mainDirector.getUnderControls());

        System.out.println("2//");
        Director localDirector = new Director("Local", "LocalDirector", 5,
                Post.DIRECTOR);
        Employee worker3 = new Worker("Third", "Worker3", 3, Post.WORKER);
        localDirector.addUnderControl(worker3);
        System.out.println(localDirector);
        System.out.println(localDirector.getUnderControls());

        System.out.println("3//");
        mainDirector.addUnderControl(localDirector);

        ArrayList<Employee> mainDirectorUnderControl = mainDirector.getUnderControls();
        System.out.println(mainDirectorUnderControl);


        System.out.println("4//");
        System.out.println(ws.printUnderControls(mainDirector, "Local")); //true
    }
}
