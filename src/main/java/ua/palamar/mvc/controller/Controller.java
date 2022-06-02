package ua.palamar.mvc.controller;

import ua.palamar.mvc.view.ConsoleView;
import ua.palamar.mvc.model.Model;

public class Controller {

    private final Model model;

    public Controller(
            Model model
    ) {
        this.model = model;
        model.attach(new ConsoleView());
    }

    public void getDefinitions(String query) {
        model.findDefinitions(query);
    }
}
