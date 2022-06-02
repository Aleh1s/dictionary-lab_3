package ua.palamar.mvc;

import ua.palamar.dto.DefinitionResponse;

import java.util.Objects;
import java.util.Queue;

public class View {

    public void showDefinitions(Queue<DefinitionResponse> definitions) {
        DefinitionResponse response;
        while (Objects.nonNull(response = definitions.poll())) {
            if (!Objects.nonNull(response.getDefinition())) {
                System.err.printf("Can not find definition of word [%s]%n", response.getQuery());
            } else {
                System.out.printf("Definition for query [%s]: %s\n\n", response.getQuery(), response.getDefinition());
            }
        }
    }
}
