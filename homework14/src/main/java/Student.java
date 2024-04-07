import java.util.List;
import java.util.Objects;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Student {
    private String name;
    private String gender;
    private int age;
    private List<String> classes;

    public Student(String name, String gender, int age, List<String> classes) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Student student)) return false;
        return getAge() == student.getAge() && Objects.equals(getName(), student.getName()) && Objects.equals(getGender(), student.getGender()) && Objects.equals(getClasses(), student.getClasses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGender(), getAge(), getClasses());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", age=").append(age);
        sb.append(", classes=").append(classes);
        sb.append('}');
        return sb.toString();
    }
}
