package ua.palamar.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IOStream {

    public static List<String> readLines(String path) {
        List<String> lines;
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            lines = new ArrayList<>();

            String line;
            while (Objects.nonNull(line = reader.readLine())) {
                lines.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }
}
