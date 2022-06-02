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
        while (true) {
            System.out.print("Type a sentence to get definition or '-1' if you want to exit: ");
            String query = scanner.nextLine();

            if (Objects.equals(query, "-1")) {
                System.out.println("Good luck!!!");
                break;
            }

            controller.getDefinitions(query);
        }
    }
}
