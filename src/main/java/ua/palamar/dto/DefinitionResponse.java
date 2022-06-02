package ua.palamar.dto;

public class DefinitionResponse {

    private final String query;
    private final String definition;

    public DefinitionResponse(String query, String definition) {
        this.query = query;
        this.definition = definition;
    }

    public String getQuery() {
        return query;
    }

    public String getDefinition() {
        return definition;
    }
}
