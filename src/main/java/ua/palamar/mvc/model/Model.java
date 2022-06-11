package ua.palamar.mvc.model;

import ua.palamar.entity.Definition;
import ua.palamar.exception.NoElementWithSuchKeyException;
import ua.palamar.exception.NullOrEmptyStringException;

public interface Model {

    Definition findDefinition(String query) throws NoElementWithSuchKeyException, NullOrEmptyStringException;

}
