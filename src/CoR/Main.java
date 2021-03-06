package CoR;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Andrei", 1000));
        employees.add(new Employee("Vlad manager", 20000));
        employees.add(new Employee("Roxana Area Manager", 100000));

        IExpenseReport expense=new ExpenseReport(4000);
        boolean approved=false;
        for (Employee employee: employees
                ) {
            ApprovalResponse response = employee.ApproveResponse(expense);
            if(response !=ApprovalResponse.BeyondLimits)
            {
                System.out.println("The expense has been approved by "+employee.get_name());
                approved=true;
                break;
            }
        }

        if(!approved){
            System.out.println("Nobody was able to approve the expense");
        }


        //using the pattern
        ExpenseHandler handler1=new ExpenseHandler(new Employee("Andrei", 1000));
        ExpenseHandler handler2=new ExpenseHandler(new Employee("Vlad manager", 20000));
        ExpenseHandler handler3=new ExpenseHandler(new Employee("Roxana Area Manager", 100000));

        handler1.RegisterNext(handler2);
        handler2.RegisterNext(handler3);

        System.out.println("Pattern implementation: " + handler1.ApproveResponse( new ExpenseReport((30000))));

    }
}
