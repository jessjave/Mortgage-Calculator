public class Calculator {
    final static int MONTHS_IN_YEAR = 12;
    final static int PERCENT = 100;
    private long principle;
    private double interest;
    public int period;


    public Calculator(long principle, double interest, int period) {
        this.principle = principle;
        this.interest = interest;
        this.period = period;
    }

    public double calculateMortgage() {

        double interestMonthly = getInterestMonthly();
        int periodMonths = getPeriodMonths();

        double initialMortgageCalculation = principle
                * (interestMonthly * Math.pow(interestMonthly + 1, periodMonths))
                / (Math.pow(interestMonthly + 1, periodMonths) - 1);
        return initialMortgageCalculation;
    }

    public double calculateBalance(short numberOfPaymentsMade) {

        double interestMonthly = getInterestMonthly();
        int periodMonths = getPeriodMonths();

        double balance = principle
                * (Math.pow(1 + interestMonthly, periodMonths) - Math.pow(1 + interestMonthly, numberOfPaymentsMade))
                / (Math.pow(1 + interestMonthly, periodMonths) - 1);
        return balance;
    }

    private int getPeriodMonths() {
        return period * MONTHS_IN_YEAR;
    }

    private double getInterestMonthly() {
        return interest / PERCENT / MONTHS_IN_YEAR;
    }

    public double[] getRemainingBalances() {
        var balances = new double [getPeriodMonths()];
        for (short month = 1; month <= balances.length; month++)
            balances [month -1] = calculateBalance(month);
        return balances;
    }
}
