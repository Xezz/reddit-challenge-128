package org.xezz;

import java.io.Console;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Console console = System.console();
        System.out.println("Enter any non number to exit!");
        if (console != null) {
            final Reader reader = console.reader();
            Scanner scanner = new Scanner(reader);
            System.out.print("Enter a number to solve: ");
            while (scanner.hasNext()) {
                String input = scanner.nextLine();
                try {
                    final List<Integer> solve = Solver.solve(input);
                    for (Integer result : solve) {
                        System.out.println(result);
                    }
                    System.out.print("Enter a number to solve: ");
                } catch (NumberFormatException nfe) {
                    System.out.println("Given input was not a number ... exiting");
                    scanner.close();
                    break;
                }
            }
            scanner.close();
        }
    }
}
