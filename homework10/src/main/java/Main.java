/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) {

        Person p = new Person("Jame", 22, 55230.25D, new Cat("Murka", 8));
        Person clone = p.clone();

        System.out.println(p);  // Person{name='Jame', age=22, salary=55230.25, cat=Cat{name='Murka', age=8}}
        System.out.println(clone);  // Person{name='Jame', age=22, salary=55230.25, cat=Cat{name='Murka', age=8}}

        System.out.println(p.equals(clone));    // true

        clone.setName("CloneName");
        System.out.println(p.getName());    // Jame
        System.out.println(clone.getName());    // CloneName

        System.out.println(p.equals(clone));    // false

    }
}
