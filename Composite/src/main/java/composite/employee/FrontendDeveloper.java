package composite.employee;

import composite.component.PayableNode;

public class FrontendDeveloper implements PayableNode {
    private int salary;

    public FrontendDeveloper(int salary) {
        this.salary = salary;
    }

    @Override
    public int getCost() {
        return salary;
    }
}
