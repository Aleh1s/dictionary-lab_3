package ua.palamar.dictionary;

import ua.palamar.dataStructure.Hashtable;
import ua.palamar.dto.Definition;
import ua.palamar.property.Property;
import ua.palamar.stream.IOStream;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Dictionary {

    private final Hashtable hashtable;
    private final String DEFAULT_DICTIONARY_PATH;

    public Dictionary() {
        DEFAULT_DICTIONARY_PATH = Property
                .getInstance()
                .getProperties()
                .getProperty("default.dictionary.path");
        hashtable = loadContent();
    }

    public Hashtable loadContent() {
        Hashtable hashtable = new Hashtable();
        List<String> definitions = IOStream.readLines(DEFAULT_DICTIONARY_PATH);

        for (String definition : definitions) {
            String key = definition.substring(0, definition.indexOf(";"));
            hashtable.put(key.toLowerCase(), definition);
        }

        return hashtable;
    }

    public String findDefinition(String key) {
        key = key.toLowerCase();
        return hashtable.get(key);
    }

    public Queue<Definition> findDefinitions(String query) {
        if (!Objects.nonNull(query) || Objects.equals(query, "")) {
            return null;
        }

        Queue<Definition> responses = new LinkedList<>();
        query = query.replaceAll("[,.!?():{}\\[\\]]", " ");
        String[] keys = query.split(" +");

        for (String key : keys) {
            Definition response = new Definition(
                    key,
                    findDefinition(key)
            );
            responses.add(response);
        }


        return responses;
    }
}
