package ua.palamar.mvc.view;

public class ConsoleView implements View {

    private final static String DELIMITER = "-".repeat(175);

    public void update(String definition) {
        System.out.println(definition);
        System.out.println(DELIMITER);
    }

    public void update(Exception error) {
        System.out.println(error.getMessage());
        System.out.println(DELIMITER);
    }
}
