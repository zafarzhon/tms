import SecondTask.Computer;
import SecondTask.Hp;
import SecondTask.Mac;
import firstTask.Cat;
import firstTask.Dog;
import firstTask.Voice;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) {
        // Test first task
        Voice[] voices = new Voice[]{new Dog(), new Cat()};
        for (Voice voice : voices) {
            System.out.print(voice.getClass().getName().concat(" "));
            voice.doVoice();
        }

        // Test Second task
        Computer[] computers = new Computer[]{new Hp(), new Mac()};
        for (Computer computer : computers) {
            System.out.println(computer.getClass().getName() + ": " + computer.getClassName());
        }
    }
}
