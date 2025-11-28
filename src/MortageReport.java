import java.text.NumberFormat;

public class MortageReport {

    private final NumberFormat currency;
    private MortageCalculator calculator;

    public MortageReport(MortageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");
for(double balance:calculator.getRemainingBalance())
    System.out.println(currency.format(balance));
    }

    public void printMortgage() {
        String mortgage = calculator.mortgageCalculator();
        System.out.println("MORTAGE");
        System.out.println("_______");
        System.out.println("Monthly payement: " + mortgage);

    }
}
