package CoR;

public interface IExpenseHandler {
    ApprovalResponse ApproveResponse(IExpenseReport expenseReport);
    void RegisterNext(IExpenseHandler handler);

}
