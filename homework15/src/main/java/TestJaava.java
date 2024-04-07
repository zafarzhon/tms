import java.util.HashSet;
import java.util.Set;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class TestJaava {
    public static void main(String[] args) {
        String str1 = new String("test");
        String str2 = new String("test");
        Set<String> set = new HashSet<>();
        set.add(str1);
        set.add(str2);
        System.out.println(set);
    }
}
