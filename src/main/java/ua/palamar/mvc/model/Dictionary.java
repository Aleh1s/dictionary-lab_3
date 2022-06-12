package ua.palamar.mvc.model;

import ua.palamar.dataStructure.HashtableOfStringKVPair;
import ua.palamar.exception.CanNotOpenFileException;
import ua.palamar.exception.NoElementWithSuchKeyException;
import ua.palamar.exception.NullOrEmptyStringException;
import ua.palamar.property.Property;
import ua.palamar.stream.IOStream;

import java.util.*;

public class Dictionary implements Model {

    private final HashtableOfStringKVPair hashtableOfStringKVPair;
    private final String DEFAULT_DICTIONARY_PATH;

    public Dictionary() {
        DEFAULT_DICTIONARY_PATH = Property
                .getInstance()
                .getProperties()
                .getProperty("default.dictionary.path");
        hashtableOfStringKVPair = loadContent();
    }

    public HashtableOfStringKVPair loadContent() {
        HashtableOfStringKVPair hashtableOfStringKVPair = new HashtableOfStringKVPair();
        List<String> definitions = null;
        try {
            definitions = IOStream.readLines(DEFAULT_DICTIONARY_PATH);
        } catch (CanNotOpenFileException e) {
            System.err.printf(
                    "Exception: %s. Please put dictionary.txt in root folder.", e.getMessage()
            );
            System.exit(-1);
        }

        for (String definition : definitions) {
            String key = definition.substring(0, definition.indexOf(";"));
            hashtableOfStringKVPair.put(key.toLowerCase(), definition);
        }

        return hashtableOfStringKVPair;
    }

    @Override
    public String findDefinition(String key) throws NoElementWithSuchKeyException, NullOrEmptyStringException {
        if (!Objects.nonNull(key) || key.isBlank()) {
            throw new NullOrEmptyStringException("Key word can not be null or empty");
        }

        return hashtableOfStringKVPair.get(key);
    }
}
