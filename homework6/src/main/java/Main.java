/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) {
        User director = new User("Jim", Profession.DIRECTOR, 4);
        User worker = new User("Alex", Profession.WORKER, 2);
        User hr = new User("Jane", Profession.HR, 5);

        System.out.println(director + " " + director.getSalary());
        System.out.println(worker + " " + worker.getSalary());
        System.out.println(hr + " " + hr.getSalary());

        System.out.println("test additional salary");
        System.out.println(director + " " + director.getSalary(12000));
        System.out.println(worker + " " + worker.getSalary(2000));
        System.out.println(hr + " " + hr.getSalary(5000));

    }
}
