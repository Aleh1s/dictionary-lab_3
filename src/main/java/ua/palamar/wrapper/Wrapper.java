package ua.palamar.wrapper;

import ua.palamar.mvc.controller.Controller;
import ua.palamar.mvc.model.FileSystemModel;

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
        Controller controller = new Controller(new FileSystemModel());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type a sentence to get definition: ");
        String query = scanner.nextLine();

        controller.getDefinitions(query);
    }
}

