import java.text.NumberFormat;

public class MortgageReport {

    private Calculator calculator;

    public MortgageReport(Calculator calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(getCurrencyInstance().format(balance));
        }

    private static NumberFormat getCurrencyInstance() {
        return NumberFormat.getCurrencyInstance();
    }

    public void printMonthlyMortgagePayment() {
        double initialMortgageCalculation = calculator.calculateMortgage();
        NumberFormat monthlyMortgage = getCurrencyInstance();
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + monthlyMortgage.format(initialMortgageCalculation));
    }
}
