package com.ianmeza;

import java.text.NumberFormat;

public class MortgageReport {
    public static void displayPaymentSchedule(MortgageCalculator mortgageCalculator, int numberOfYears) {
        int p = 1;
        var console = new Console();
        String result = "PAYMENT SCHEDULE\n________________";
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        while (p <= numberOfYears * Main.MONTHS_IN_A_YEAR) {
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
