import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IOStream {

    private static final String dictionaryPath = "default.path";

    public static List<String> readLines() {
        List<String> lines;
        try(BufferedReader reader = new BufferedReader(new FileReader(dictionaryPath))) {
            lines = new ArrayList<>();

            String line;
            while (!Objects.equals(line = reader.readLine(), "")) {
                lines.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }
}
