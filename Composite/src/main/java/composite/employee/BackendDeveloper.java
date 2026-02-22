package composite.employee;

import composite.component.PayableNode;

public class BackendDeveloper implements PayableNode {
    private int salary;

    public BackendDeveloper(int salary) {
        this.salary = salary;
    }

    @Override
    public int getCost() {
        return salary;
    }
}
