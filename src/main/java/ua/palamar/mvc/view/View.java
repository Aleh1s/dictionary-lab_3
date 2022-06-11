package ua.palamar.mvc.view;

import ua.palamar.entity.Definition;

public interface View {

    void update(Exception exception);
    void update(Definition definition);

}
