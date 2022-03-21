package com.ianmeza;

import java.text.NumberFormat;

public class Main {
    final static int MONTHS_IN_A_YEAR = 12;
    final static int PERCENTAGE = 100;

    public static void main(String[] args) {
        // TODO: 17/02/22 Console Class
        // TODO: 17/02/22 MortgageReport Class

//        read the inputs
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate: ", 0, 30);
        int numberOfYears = (int) Console.readNumber("Period (Years): ", 0, 30);

        var mortgageCalculator = new MortgageCalculator(1000, 1_000_000, 0, 30, 0, 30, principal, annualInterestRate, numberOfYears);
//        make calculation
        double mortgage = mortgageCalculator.getMortgage();

        displayMortgage(mortgage);
        displayPaymentSchedule(mortgageCalculator, numberOfYears);
    }

    public static void displayPaymentSchedule(MortgageCalculator mortgageCalculator, int numberOfYears) {
        int p = 1;
        var console = new Console();
        String result = "PAYMENT SCHEDULE\n________________";
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        while (p <= numberOfYears * MONTHS_IN_A_YEAR) {
            result = result + "\n" + currency.format(mortgageCalculator.calculateRemainingBalance(p));
            p ++;
        }
        console.log(result);
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

}
