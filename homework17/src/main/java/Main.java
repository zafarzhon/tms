import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(getBYNToUSDFunction("1000 BYN",
                byn -> Integer.parseInt(byn.substring(0,
                        byn.indexOf(" BYN"))) * 1.0 / 3.26 + " USD"));

        getBYNToUSDConsumer("1000 BYN",
                byn -> System.out.println(Integer.parseInt(byn.substring(0,
                        byn.indexOf(" BYN"))) * 1.0 / 3.26 + " USD"));

        System.out.println(getReverseInText(
                        () -> new StringBuilder(
                                new Scanner(System.in).nextLine()).reverse().toString()
                )
        );
    }

    private static String getReverseInText(Supplier<String> s) {
        return s.get();
    }


    private static String getBYNToUSDFunction(String s, Function<String, String> f) {
        return f.apply(s);
    }

    private static void getBYNToUSDConsumer(String s, Consumer<String> c) {
        c.accept(s);
    }
}
