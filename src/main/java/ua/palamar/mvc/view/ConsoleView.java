package ua.palamar.mvc.view;

import ua.palamar.dto.Definition;

import java.util.Objects;
import java.util.Queue;

public class ConsoleView implements View {
    @Override
    public void update(Queue<Definition> definitions) {
        showDefinitions(definitions);
    }

    @Override
    public void showDefinitions(Queue<Definition> definitions) {
        if (!Objects.nonNull(definitions)) {
            System.err.println("Query can not be null or empty");
            return;
        }

        Definition definition;
        while (Objects.nonNull(definition = definitions.poll())) {
            if (!Objects.nonNull(definition.getDefinition())) {
                System.err.printf("Can not find definition of word [%s]%n", definition.getKey());
            } else {
                System.out.printf("Definition for query [%s]: %s\n\n", definition.getKey(), definition.getDefinition());
            }
        }
    }
}
