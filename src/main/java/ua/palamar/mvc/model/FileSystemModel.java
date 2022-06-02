package ua.palamar.mvc.model;

import ua.palamar.dto.Definition;
import ua.palamar.dictionary.Dictionary;
import ua.palamar.mvc.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FileSystemModel implements Model {

    private final Dictionary dictionary;
    private final List<Observer> observers;
    public FileSystemModel() {
        this.dictionary = new Dictionary();
        this.observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void findDefinitions(String query) {
        Queue<Definition> definitions
                = dictionary.findDefinitions(query);
        notifyObservers(definitions);
    }

    @Override
    public void notifyObservers(Queue<Definition> definitions) {
        for (Observer o: observers) {
            o.update(definitions);
        }
    }
}
