/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) {
        String str = "i'm string";

        System.out.println(str.length());

        String[] strs = str.split("i");

        System.out.println(strs.length);

        StringBuilder sb = new StringBuilder(str.substring(0, str.indexOf(" ")));
        System.out.println(sb.reverse());


        String sFormat = String.format("Hi, My name's %s and I'm %d years.",
                "John", 22);
        System.out.println(sFormat);
    }
}
