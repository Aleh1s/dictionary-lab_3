package ua.palamar.mvc;

import ua.palamar.dto.Definition;

import java.util.Queue;

public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Queue<Definition> definitions);
}
