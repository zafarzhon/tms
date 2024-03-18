import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
@Setter
@Getter
@AllArgsConstructor
public class Person implements Cloneable {
    private String name;
    private int age;
    private double salary;
    private Cat cat;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Person person)) {
            return false;
        }
        if (person.hashCode() != hashCode()) {
            return false;
        }
        if (person.getAge() != getAge()) {
            return false;
        }
        if (Double.compare(person.getSalary(), getSalary()) != 0) {
            return false;
        }
        return person.getName().equals(getName()) && person.getCat().equals(getCat());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getCat().hashCode();
        result = 53 * result + getAge();
        result = 71 * result + Double.hashCode(getSalary());
        return result;
    }

    @Override
    protected Person clone() {
        return new Person(name, age, salary, new Cat(cat.getName(), cat.getAge()));
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", salary=").append(salary);
        sb.append(", cat=").append(cat);
        sb.append('}');
        return sb.toString();
    }

}
