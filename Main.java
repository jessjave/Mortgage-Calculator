public class MortgageCalculator {


    public static void main(String[] args) {

        int principle = (int) Console.readNumber("Principle: ", 1000, 1000000);
        double interest = Console.readNumber("Annual Interest: ", 0, 30);
        int period = (int) Console.readNumber("Period (Years?): ", 1, 30);

        var calculator = new Calculator(principle, interest, period);
        new MortgageReport(calculator).printMonthlyMortgagePayment();
        new MortgageReport(calculator).printPaymentSchedule();
    }
}
