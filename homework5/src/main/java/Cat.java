/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */

/**
 * 1)
 * Создаем класс Cat
 * Данный класс будет иметь следующее состояние
 * 1) имя кота (строка)
 * 2) возраст кота (int)
 * 3) порода кота (строка)
 * Создаем конструктор со всеми параметрами. Устанавливаем значения в переменные класса.
 * Создаем конструктор с именем и возрастом. Данный конструктор должен вызвать конструктор с тремя параметрами, а породу кота передать - "Без породы"
 * Создать метод который будет печатать всю информацию о коте - имя, возраст и породу
 * Создать метод который принимает новое имя кота и устанавливает вместо старого
 * Распечатать новое имя кота
 */
public class Cat {
    private String name;
    private int age;
    private String breed;

    public Cat(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public Cat(String name, int age) {
        this(name, age, "Без породы");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                '}';
    }
}
