package com.ianmeza;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();

//        read the inputs
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate: ", 0, 30);
        int numberOfYears = (int) readNumber("Period (Years): ", 0, 30);

//        make calculation
        double mortgage = calculateMortgage(principal, annualInterestRate, numberOfYears);

//        format currency
        String formattedMortgage = currency.format(mortgage);
//        print result

        System.out.println("Mortgage: " + formattedMortgage);
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextInt();

            if (value >= min && value <= max)
                break;

            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(
            int principal,
            float annualInterestRate,
            int numberOfYears) {

        final int MONTHS_IN_A_YEAR = 12;
        final int PERCENTAGE = 100;

        int numberOfMonths = numberOfYears * MONTHS_IN_A_YEAR;
        float monthlyInterestRate = (annualInterestRate / PERCENTAGE) / MONTHS_IN_A_YEAR;
        double onePlusRFactor = Math.pow((1 + monthlyInterestRate), numberOfMonths);

        double mortgage = principal * ((monthlyInterestRate * onePlusRFactor)/(onePlusRFactor - 1));
        return mortgage;
    }
}
