package com.ianmeza;

import java.util.Scanner;

/**
 * Utility for interacting through the console
 */
public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt) {
        return scanner.nextDouble();
    }
    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();

            if (value >= min && value <= max)
                break;

            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    /**
     * String ->
     * prints a string per line
     *
     * printInfo({"PAYMENT SCHEDULE", "________________"})
     * should print     PAYMENT SCHEDULE
     *                  ________________
     */
    public void log(String info) {
        if (info.length() == 0)
            return;
        System.out.println(info);
    }
}
