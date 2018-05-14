package CoR;

public class ExpenseReport implements IExpenseReport {
    private double _total;

    public ExpenseReport(double total){
        _total=total;
    }

    @Override
    public double getTotal() {
        return _total;
    }
}
