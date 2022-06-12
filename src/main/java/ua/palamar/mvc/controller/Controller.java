package ua.palamar.mvc.controller;

import ua.palamar.mvc.model.QueryParser;
import ua.palamar.exception.BadInputException;
import ua.palamar.exception.NoElementWithSuchKeyException;
import ua.palamar.exception.NullOrEmptyStringException;
import ua.palamar.mvc.model.Model;
import ua.palamar.mvc.view.View;

public class Controller {

    private final Model model;
    private final View view;

    public Controller(
            Model model,
            View view
    ) {
        this.view = view;
        this.model = model;
    }

    public void getDefinitions(String query) {
        try {
            String[] keyWords = QueryParser.getKeyWords(query);

            for (String keyWord : keyWords) {
                try {
                    String definition = model.findDefinition(keyWord);
                    view.update(definition);
                } catch (NoElementWithSuchKeyException | NullOrEmptyStringException e) {
                    view.update(e);
                }
            }
        } catch (BadInputException e) {
            view.update(e);
        }
    }
}
