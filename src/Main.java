import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int principal = (int) readNumber("Principal(RF1K-RF1M):", 1000, 1000000);
        float annualInterest = (float) readNumber("Annual Interest Rate:", 0, 30);
        int period = (int) readNumber("Period(Years):", 1, 30);

        printMortgage(annualInterest, principal, period);
        printPaymentSchedule(period, principal, annualInterest);
    }

    private static void printMortgage(float annualInterest, int principal, int period) {
        String mortgage = mortgageCalculator(annualInterest, principal, period);
        System.out.println("MORTAGE");
        System.out.println("_______");
        System.out.println("Monthly payement: " + mortgage);
    }

    public static void printPaymentSchedule(int period, int principal, float annualInterest) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");

        for (short month = 1; month <= period * MONTHS_IN_YEAR; month++) {
            double balance = calculateRemaining(principal, annualInterest, period, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, long min, long max) {
        Scanner scanner = new Scanner(System.in);
        float value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static String mortgageCalculator(float annualInterest, long principal, int period) {
        float rate = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgage = principal * (rate * Math.pow(1 + rate, numberOfPayments) / (Math.pow(1 + rate, numberOfPayments) - 1));
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        return result;
    }

    public static double calculateRemaining(double principal, float annualInterest, int period, int numberOfPaymentsMade) {
        float rate = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double balance = principal * (Math.pow(1 + rate, numberOfPayments) - Math.pow(1 + rate, numberOfPaymentsMade)) / (Math.pow(1 + rate, numberOfPayments) - 1);
        return balance;
    }
}
