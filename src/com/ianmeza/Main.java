package com.ianmeza;

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

        MortgageReport.displayMortgage(mortgage);
        MortgageReport.displayPaymentSchedule(mortgageCalculator, numberOfYears);
    }


}
