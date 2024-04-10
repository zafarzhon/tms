import java.util.List;
import java.util.Objects;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class User {
    private String name;
    private int experience;
    private List<String> tasks;

    public User(String name, int experience, List<String> tasks) {
        this.name = name;
        this.experience = experience;
        this.tasks = tasks;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User user)) return false;
        return experience == user.experience && Objects.equals(name, user.name) && Objects.equals(tasks, user.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience, tasks);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", experience=").append(experience);
        sb.append(", tasks=").append(tasks);
        sb.append('}');
        return sb.toString();
    }
}
