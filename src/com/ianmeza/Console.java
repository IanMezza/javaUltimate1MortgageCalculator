package com.ianmeza;

/**
 * Utility for interacting through the console
 */
public class Console {


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
