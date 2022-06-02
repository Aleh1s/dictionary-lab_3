package ua.palamar.mvc;

import ua.palamar.dto.Definition;

import java.util.Queue;

public interface Observer {
    void update(Queue<Definition> definitions);
}
