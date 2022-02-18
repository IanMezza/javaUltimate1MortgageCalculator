package com.ianmeza;

public class MortgageCalculator {
    final static int MONTHS_IN_A_YEAR = 12;
    final static int PERCENTAGE = 100;

    private int principalMinAllowed;
    private int principalMaxAllowed;
    private int principal;
    private int annualInterestRateMinAllowed;
    private int annualInterestRateMaxAllowed;
    private float annualInterestRate;
    private int numberOfYearsMinAllowed;
    private int numberOfYearsMaxAllowed;
    private int numberOfYears;
    private double mortgage;

    public MortgageCalculator(
            int principalMinAllowed,
            int principalMaxAllowed,
            int annualInterestRateMinAllowed,
            int annualInterestRateMaxAllowed,
            int numberOfYearsMinAllowed,
            int numberOfYearsMaxAllowed,
            int principal,
            float annualInterestRate,
            int numberOfYears) {
        setPrincipalMinAllowed(principalMinAllowed);
        setPrincipalMaxAllowed(principalMaxAllowed);
        setAnnualInterestRateMinAllowed(annualInterestRateMinAllowed);
        setAnnualInterestRateMaxAllowed(annualInterestRateMaxAllowed);
        setNumberOfYearsMinAllowed(numberOfYearsMinAllowed);
        setNumberOfYearsMaxAllowed(numberOfYearsMaxAllowed);
        setPrincipal(principal);
        setAnnualInterestRate(annualInterestRate);
        setNumberOfYears(numberOfYears);
        setMortgage();
    }

    private void setPrincipalMinAllowed(int principalMinAllowed) {
        if (principalMinAllowed < 0)
            throw new IllegalArgumentException("principalMinAllowed cannot be less than 0.");
        this.principalMinAllowed = principalMinAllowed;
    }

    private void setPrincipalMaxAllowed(int principalMaxAllowed) {
        if (principalMaxAllowed < 0)
            throw new IllegalArgumentException("principalMaxAllowed cannot be less than 0.");
        this.principalMaxAllowed = principalMaxAllowed;
    }

    private void setAnnualInterestRateMaxAllowed(int annualInterestRateMaxAllowed) {
        if (annualInterestRateMaxAllowed < 0)
            throw new IllegalArgumentException("annualInterestRateMaxAllowed cannot be less than 0.");
        this.annualInterestRateMaxAllowed = annualInterestRateMaxAllowed;
    }

    private void setAnnualInterestRateMinAllowed(int annualInterestRateMinAllowed) {
        if (annualInterestRateMinAllowed < 0)
            throw new IllegalArgumentException("annualInterestRateMinAllowed cannot be less than 0.");
        this.annualInterestRateMinAllowed = annualInterestRateMinAllowed;
    }

    private void setNumberOfYearsMinAllowed(int numberOfYearsMinAllowed) {
        if (numberOfYearsMinAllowed < 0)
            throw new IllegalArgumentException("numberOfYearsMinAllowed cannot be less than 0.");
        this.numberOfYearsMinAllowed = numberOfYearsMinAllowed;
    }

    private void setNumberOfYearsMaxAllowed(int numberOfYearsMaxAllowed) {
        if (numberOfYearsMaxAllowed < 0)
            throw new IllegalArgumentException("numberOfYearsMaxAllowed cannot be less than 0.");
        this.numberOfYearsMaxAllowed = numberOfYearsMaxAllowed;
    }

    private void setPrincipal(int principal) {
        if (principal < principalMinAllowed || principal > principalMaxAllowed)
            throw new IllegalArgumentException("Principal cannot be neither less than " + principalMinAllowed + " nor more than " + principalMaxAllowed);
        this.principal = principal;
    }

    private void setAnnualInterestRate(float annualInterestRate) {
        if (annualInterestRate < annualInterestRateMinAllowed || annualInterestRate > annualInterestRateMaxAllowed)
            throw new IllegalArgumentException("Annual Interest Rate cannot be neither less than " + annualInterestRateMinAllowed + " nor more than " + annualInterestRateMaxAllowed);
        this.annualInterestRate = annualInterestRate;
    }

    private void setNumberOfYears(int numberOfYears) {
        if (numberOfYears < numberOfYearsMinAllowed || numberOfYears > numberOfYearsMaxAllowed)
            throw new IllegalArgumentException("Number Of Years cannot be less than " + numberOfYearsMinAllowed + " nor more than " + numberOfYearsMaxAllowed);
        this.numberOfYears = numberOfYears;
    }

    private double calculateMortgage() {
        int numberOfMonths = numberOfYears * MONTHS_IN_A_YEAR;
        float monthlyInterestRate = (annualInterestRate / PERCENTAGE) / MONTHS_IN_A_YEAR;
        double onePlusRFactor = Math.pow((1 + monthlyInterestRate), numberOfMonths);

        return principal * ((monthlyInterestRate * onePlusRFactor)/(onePlusRFactor - 1));
    }

    public double getMortgage() {
        return mortgage;
    }

    public void setMortgage() {
        this.mortgage = calculateMortgage();
    }

    public double calculateRemainingBalance(int currentMonth) {
        int numberOfMonths = numberOfYears * MONTHS_IN_A_YEAR;
        float monthlyInterestRate = (annualInterestRate / PERCENTAGE) / MONTHS_IN_A_YEAR;

        return (principal * (Math.pow((1 + monthlyInterestRate), numberOfMonths) - Math.pow((1 + monthlyInterestRate), currentMonth))) / (Math.pow((1 + monthlyInterestRate), numberOfMonths) - 1);
    }
}
