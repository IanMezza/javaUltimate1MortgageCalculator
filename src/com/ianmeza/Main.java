package com.ianmeza;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Scanner scanner = new Scanner(System.in);

//        read the inputs
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();
        System.out.print("Period (Years): ");
        int numberOfMonths = scanner.nextInt() * 12;
//        make calculation
        float monthlyInterestRate = (annualInterestRate / 100) / 12;
        double onePlusRFactor = Math.pow((1 + monthlyInterestRate), numberOfMonths);
        double mortgage = principal * ((monthlyInterestRate * onePlusRFactor)/(onePlusRFactor - 1));
//        format currency
        String formattedMortgage = currency.format(mortgage);
//        print result

        System.out.println("Mortgage: " + formattedMortgage);
    }
}
