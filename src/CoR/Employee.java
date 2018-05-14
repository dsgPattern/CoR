package CoR;

public class Employee implements IExpenseApprover {
    private double _approvalLimit;
    private String _name;

    public Employee(String name, double approvalLimit){
        _name=name;
        _approvalLimit = approvalLimit;
    }

    @Override
    public ApprovalResponse ApproveResponse(IExpenseReport expenseReport) {
        return expenseReport.getTotal() > _approvalLimit? ApprovalResponse.BeyondLimits : ApprovalResponse.Approved;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}
