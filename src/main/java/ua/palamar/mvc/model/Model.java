package ua.palamar.mvc.model;

import ua.palamar.exception.NoElementWithSuchKeyException;
import ua.palamar.exception.NullOrEmptyStringException;

public interface Model {

    String findDefinition(String query) throws NoElementWithSuchKeyException, NullOrEmptyStringException;

}
