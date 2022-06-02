package ua.palamar.mvc;

import ua.palamar.dto.DefinitionResponse;

import java.util.Objects;
import java.util.Queue;

public class Controller {

    private final Model model;
    private final View view;
    public Controller(
            Model model,
            View view
    ) {
        this.model = model;
        this.view = view;
    }

    public void getDefinitions(String query) {
        Queue<DefinitionResponse> definitions = model.findDefinitions(query);
        if (!Objects.nonNull(definitions)) {
            System.err.println("Query can not be null or empty");
        }

        view.showDefinitions(definitions);
    }
}
