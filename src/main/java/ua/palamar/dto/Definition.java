package ua.palamar.dto;

public class Definition {

    private final String key;
    private final String definition;

    public Definition(String key, String definition) {
        this.key = key;
        this.definition = definition;
    }

    public String getKey() {
        return key;
    }

    public String getDefinition() {
        return definition;
    }
}
