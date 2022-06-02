package ua.palamar.mvc.model;

import ua.palamar.mvc.Observable;

public interface Model extends Observable {

    void findDefinitions(String query);

}
