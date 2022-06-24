package com.ianmeza;

import java.text.NumberFormat;

public class MortgageReport {
    public static void displayPaymentSchedule(MortgageCalculator mortgageCalculator) {
        var console = new Console();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        console.log("PAYMENT SCHEDULE\n________________");
        for (double balance: mortgageCalculator.getRemainingBalances()) {
            console.log(currency.format(balance));
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
}
