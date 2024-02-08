public class YearlyReportOne {
    private int month;
    private int amount;
    private boolean isExpense;

    public YearlyReportOne(int month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    public int getMonth() {
        return month;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isExpense() {
        return isExpense;
    }
}
