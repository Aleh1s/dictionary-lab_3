package ua.palamar.stream;

import ua.palamar.exception.CanNotOpenFileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IOStream {

    public static List<String> readLines(String path) throws CanNotOpenFileException {
        List<String> lines;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            lines = new ArrayList<>();

            String line;
            while (Objects.nonNull(line = reader.readLine())) {
                lines.add(line);
            }

        } catch (IOException e) {
            throw new CanNotOpenFileException(String.format("Can not open file [%s]. Perhaps it does not exist", path), e);
        }

        return lines;
    }
}
