package com.ianmeza;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static int MONTHS_IN_A_YEAR = 12;
    final static int PERCENTAGE = 100;

    public static void main(String[] args) {

//        read the inputs
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate: ", 0, 30);
        int numberOfYears = (int) readNumber("Period (Years): ", 0, 30);

//        make calculation
        double mortgage = calculateMortgage(principal, annualInterestRate, numberOfYears);

        displayMortgage(mortgage);
        displayPaymentSchedule(mortgage, principal, annualInterestRate, numberOfYears);
    }

    public static void displayPaymentSchedule(double mortgage, double principal, float annualInterestRate, int numberOfYears) {
        int p = 1;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
//        format currency
        String formattedMortgage = currency.format(mortgage);
//        print result
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");
        while (p <= numberOfYears * MONTHS_IN_A_YEAR) {
            System.out.println(currency.format(calculateRemainingBalance(principal, annualInterestRate, numberOfYears, p)));
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
    public static double calculateRemainingBalance(double principal, float annualInterestRate, int numberOfYears, int currentMonth) {
        int numberOfMonths = numberOfYears * MONTHS_IN_A_YEAR;
        float monthlyInterestRate = (annualInterestRate / PERCENTAGE) / MONTHS_IN_A_YEAR;

        return (principal * (Math.pow((1 + monthlyInterestRate), numberOfMonths) - Math.pow((1 + monthlyInterestRate), currentMonth))) / (Math.pow((1 + monthlyInterestRate), numberOfMonths) - 1);
    }

    public static double calculateMortgage(
            int principal,
            float annualInterestRate,
            int numberOfYears) {

        int numberOfMonths = numberOfYears * MONTHS_IN_A_YEAR;
        float monthlyInterestRate = (annualInterestRate / PERCENTAGE) / MONTHS_IN_A_YEAR;
        double onePlusRFactor = Math.pow((1 + monthlyInterestRate), numberOfMonths);

        double mortgage = principal * ((monthlyInterestRate * onePlusRFactor)/(onePlusRFactor - 1));
        return mortgage;
    }
}
