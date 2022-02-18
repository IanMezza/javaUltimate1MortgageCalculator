package com.ianmeza;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static int MONTHS_IN_A_YEAR = 12;
    final static int PERCENTAGE = 100;

    public static void main(String[] args) {
        // TODO: 17/02/22 Console Class
        // TODO: 17/02/22 MortgageReport Class

//        read the inputs
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate: ", 0, 30);
        int numberOfYears = (int) readNumber("Period (Years): ", 0, 30);

        var mortgageCalculator = new MortgageCalculator(1000, 1_000_000, 0, 30, 0, 30, principal, annualInterestRate, numberOfYears);
//        make calculation
        double mortgage = mortgageCalculator.getMortgage();

        displayMortgage(mortgage);
        displayPaymentSchedule(mortgageCalculator, numberOfYears);
    }

    public static void displayPaymentSchedule(MortgageCalculator mortgageCalculator, int numberOfYears) {
        int p = 1;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        //        print result
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");
        while (p <= numberOfYears * MONTHS_IN_A_YEAR) {
            System.out.println(currency.format(mortgageCalculator.calculateRemainingBalance(p)));
            p ++;
        }
    }



    public static void displayMortgage(double mortgage) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
//        format currency
        String formattedMortgage = currency.format(mortgage);
//        print result

        System.out.println("MORTGAGE");
        System.out.println("________");
        System.out.println("Monthly Payments: " + formattedMortgage);
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
}
