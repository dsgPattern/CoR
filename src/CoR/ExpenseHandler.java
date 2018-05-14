package CoR;

public class ExpenseHandler implements IExpenseHandler {
    private IExpenseHandler _next;
    private IExpenseApprover _approver;

    public ExpenseHandler(IExpenseApprover approver){
        _approver=approver;
    }


    @Override
    public ApprovalResponse ApproveResponse(IExpenseReport expenseReport) {
        ApprovalResponse response = _approver.ApproveResponse(expenseReport);
        if(response== ApprovalResponse.BeyondLimits)
        {
            if(_next==null)
                return ApprovalResponse.MissingApprover;
            return _next.ApproveResponse(expenseReport);
        }

        return response;
    }

    @Override
    public void RegisterNext(IExpenseHandler handler) {
        _next=handler;
    }
}
