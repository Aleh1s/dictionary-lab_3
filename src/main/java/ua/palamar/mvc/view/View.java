package ua.palamar.mvc.view;

import ua.palamar.dto.Definition;
import ua.palamar.mvc.Observer;

import java.util.Queue;

public interface View extends Observer {

    void showDefinitions(Queue<Definition> definitions);

}
