package ua.palamar;

import ua.palamar.dataStructure.Hashtable;
import ua.palamar.dto.DefinitionResponse;
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
        List<String> content = IOStream.readLines(DEFAULT_DICTIONARY_PATH);

        for (String definition : content) {
            String key = definition.substring(0, definition.indexOf(";"));
            hashtable.put(key.toLowerCase(), definition);
        }

        return hashtable;
    }

    public String findDefinition(String key) {
        key = key.toLowerCase();
        return hashtable.get(key);
    }

    public Queue<DefinitionResponse> findDefinitions(String querySequences) {
        if (!Objects.nonNull(querySequences) || Objects.equals(querySequences, "")) {
            return null;
        }

        Queue<DefinitionResponse> responses = new LinkedList<>();
        querySequences = querySequences.replaceAll("[,.!?():{}\\[\\]]", " ");
        String[] queries = querySequences.split(" +");

        for (String query : queries) {
            DefinitionResponse response = new DefinitionResponse(
                    query,
                    findDefinition(query)
            );
            responses.add(response);
        }


        return responses;
    }
}
