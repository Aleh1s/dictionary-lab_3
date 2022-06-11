package ua.palamar.entity;

public class Definition {

    private final String key;
    private final String definition;

    public Definition(String key, String definition) {
        this.key = key;
        this.definition = definition;
    }

    @Override
    public String toString() {
        return String.format(
                "Key: %s. Definition: %s", key, definition
        );
    }
}
