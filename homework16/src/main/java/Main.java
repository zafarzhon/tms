import java.util.HashMap;
import java.util.Map;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(wordMultiple(new String[]{"a", "b", "a", "c",
                "b"}));
        System.out.println(wordMultiple(new String[]{"c", "b", "a"}));
        System.out.println(wordMultiple(new String[]{"c", "c", "c", "c"}));

        System.out.println(pairs(new String[]{"code", "bug"}));
        System.out.println(pairs(new String[]{"man", "moon", "main"}));
        System.out.println(pairs(new String[]{"man", "moon", "good", "night"}));
    }

    private static Map<String, Boolean> wordMultiple(String[] strs) {
        Map<String, Boolean> hashMap = new HashMap<>();
        for (String str : strs) {
            if (hashMap.containsKey(str)) {
                hashMap.put(str, true);
            } else {
                hashMap.put(str, false);
            }
        }
        return hashMap;
    }

    private static Map<String, String> pairs(String[] strs) {
        Map<String, String> hashMap = new HashMap<>();
        for (String str : strs) {
            String[] split = str.split("");
            hashMap.put(split[0], split[split.length - 1]);
        }
        return hashMap;
    }
}
