package com.ianmeza;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Scanner scanner = new Scanner(System.in);

        final int MONTHS_IN_A_YEAR = 12;
        final int PERCENTAGE = 100;

        int principal;
        float annualInterestRate;
        int numberOfYears;
        int numberOfMonths;

//        read the inputs
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();

            if (principal >= 1000 && principal <= 1_000_000)
                break;

            System.out.println("Enter a number between 1,000 and 1,000,000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();

            if (annualInterestRate > 0 && annualInterestRate <= 30)
                break;

            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }

        while (true) {
            System.out.print("Period (Years): ");
            numberOfYears = scanner.nextInt();
            numberOfMonths = numberOfYears * MONTHS_IN_A_YEAR;

            if (numberOfYears > 0 && numberOfYears<= 30) {
                break;
            }

            System.out.println("Enter a value between 1 and 30");
        }
//        make calculation
        float monthlyInterestRate = (annualInterestRate / PERCENTAGE) / MONTHS_IN_A_YEAR;
        double onePlusRFactor = Math.pow((1 + monthlyInterestRate), numberOfMonths);
        double mortgage = principal * ((monthlyInterestRate * onePlusRFactor)/(onePlusRFactor - 1));
//        format currency
        String formattedMortgage = currency.format(mortgage);
//        print result

        System.out.println("Mortgage: " + formattedMortgage);
    }
}
