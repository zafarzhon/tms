import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
@Getter
@Setter
@AllArgsConstructor
public class Cat {
    private String name;
    private int age;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Cat cat)) return false;
        return getAge() == cat.getAge() && Objects.equals(getName(), cat.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cat{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
