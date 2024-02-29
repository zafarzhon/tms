/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */

import java.util.Objects;

/**
 * Необходимо создать класс User со следующими полями
 * имя - строковой параметр
 * профессия - enum (DIRECTOR, WORKER, HR)
 * стаж работы - число
 * Так же надо создать метод который будет выводить зарплату данного пользователя
 * Подсчет зп должен учитывать стаж работы и профессию (1000 * стаж работы * коэффициент профессии)
 * <p>
 * Создайте несколько пользователей с разными параметрами
 * Выведете зп каждого сотрудника
 * <p>
 * Создайте еще один метод подсчета зп, но он должен принимать параметр - доп оплата
 * Его задача - подсчитывать ЗП и добавлять к ней доп плату
 * Проверить правильность работы данного метода
 */
public class User {
    private String name;
    private Profession profession;
    private int experience;

    public User(String name, Profession profession, int experience) {
        this.name = name;
        this.profession = profession;
        this.experience = experience;
    }

    public double getSalary() {
        return 1000 * experience * profession.getCoefficient();
    }

    public double getSalary(double additionalSalary) {
        return getSalary() + additionalSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", profession=" + profession + ", experience=" + experience + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getExperience() == user.getExperience() && Objects.equals(getName(), user.getName()) && getProfession() == user.getProfession();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getProfession(), getExperience());
    }
}
