import java.text.NumberFormat;

public class MortageCalculator {
    private float annualInterest;
    private long principal;
    private int period;

    public MortageCalculator(float annualInterest, long principal, int period) {
        this.annualInterest = annualInterest;
        this.principal = principal;
        this.period = period;
    }

    public String mortgageCalculator() {
        float rate = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        double mortgage = principal * (rate * Math.pow(1 + rate, numberOfPayments) / (Math.pow(1 + rate, numberOfPayments) - 1));
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        return result;
    }

    public double[] getRemainingBalance(){
        var balances=new double[getNumberOfPayments()];
        for (short month = 1; month <=period * balances.length; month++)
            balances[month-1]= calculateRemaining(month);


        return balances;
    }
    private int getNumberOfPayments() {
        return period * Main.MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;
    }

    public double calculateRemaining(int numberOfPaymentsMade) {
        float rate = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        double balance = principal * (Math.pow(1 + rate, numberOfPayments) - Math.pow(1 + rate, numberOfPaymentsMade)) / (Math.pow(1 + rate, numberOfPayments) - 1);
        return balance;
    }


}
