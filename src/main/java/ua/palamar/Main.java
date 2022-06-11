package ua.palamar;

import ua.palamar.mvc.model.Dictionary;
import ua.palamar.mvc.controller.Controller;
import ua.palamar.mvc.view.ConsoleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(
                new Dictionary(),
                new ConsoleView()
        );

        while (true) {
            String input;

            System.out.print("Get definition. Write '-1' to exit: ");
            input = scanner.nextLine();

            if (input.equals("-1"))
                break;

            controller.getDefinitions(input);
        }
    }
}