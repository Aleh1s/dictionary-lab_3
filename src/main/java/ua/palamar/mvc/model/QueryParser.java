package ua.palamar.mvc.model;

import ua.palamar.exception.BadInputException;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public class QueryParser {

    public static String[] getKeyWords(String query) throws BadInputException {
        if (!Objects.nonNull(query) || query.isBlank()) {
            throw new BadInputException("Query can not be null or empty string");
        }

        query = query.trim();
        Pattern pattern = Pattern.compile("[-A-Za-z ]+");
        if (!pattern.matcher(query).matches()) {
            throw new BadInputException("Query must not contain any symbols except letters and spaces");
        }

        String[] keyWords = query.split("\\s+");
        toLowerCase(keyWords);
        return keyWords;
    }

    private static void toLowerCase(String[] keyWords) {
        for (int i = 0; i < keyWords.length; i++) {
            keyWords[i] = keyWords[i].toLowerCase(Locale.ROOT);
        }
    }
}
