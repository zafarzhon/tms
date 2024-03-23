import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String dir = "./homework13/src/main/java/";
        List<String> lines = Files.readAllLines(
                Paths.get(dir + "input.txt"));
        try (BufferedWriter bfRomeo =
                     new BufferedWriter(
                             new FileWriter(dir + "romeo.txt"));
             BufferedWriter bfJuliet =
                     new BufferedWriter(
                             new FileWriter(dir + "juliet.txt"))) {
            boolean isRomeo = false;
            for (String line : lines) {
                if (line.contains("Romeo:")) {
                    isRomeo = true;
                } else if (line.contains("Juliet")) {
                    isRomeo = false;
                }
                if (isRomeo) {
                    bfRomeo.write(line.concat("\n"));
                } else {
                    bfJuliet.write(line.concat("\n"));
                }
            }
        }
    }
}
