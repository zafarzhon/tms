/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public abstract class Employee {
    private String name;
    private String surname;
    private int workExperienceInMonth;
    private Post post;


    public Employee(String name, String surname, int workExperienceInMonth,
                    Post post) {
        this.name = name;
        this.surname = surname;
        this.workExperienceInMonth = workExperienceInMonth;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getWorkExperienceInMonth() {
        return workExperienceInMonth;
    }

    public void setWorkExperienceInMonth(int workExperienceInMonth) {
        this.workExperienceInMonth = workExperienceInMonth;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", stageInMonth=" + workExperienceInMonth +
                ", position='" + post + '\'';
    }
}
