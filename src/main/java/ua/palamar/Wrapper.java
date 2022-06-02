package ua.palamar;

import ua.palamar.mvc.Controller;
import ua.palamar.mvc.Model;
import ua.palamar.mvc.View;

import java.util.Objects;
import java.util.Scanner;

public class Wrapper {

    private static final String TITLE = """
                                                                                            \s
            ,------.   ,--.          ,--.   ,--.                                            \s
            |  .-.  \\  `--'  ,---. ,-'  '-. `--'  ,---.  ,--,--,   ,--,--. ,--.--. ,--. ,--.\s
            |  |  \\  : ,--. | .--' '-.  .-' ,--. | .-. | |      \\ ' ,-.  | |  .--'  \\  '  / \s
            |  '--'  / |  | \\ `--.   |  |   |  | ' '-' ' |  ||  | \\ '-'  | |  |      \\   '  \s
            `-------'  `--'  `---'   `--'   `--'  `---'  `--''--'  `--`--' `--'    .-'  /   \s
                                                                                   `---'    \s
            """;

    public static void showTitle() {
        System.out.println(TITLE);
    }

    public static void findDefinition() {
        Controller controller = new Controller(
                new Model(),
                new View()
        );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type a sentence to get definition: ");
        String query = scanner.nextLine();

        controller.getDefinitions(query);
    }
}

