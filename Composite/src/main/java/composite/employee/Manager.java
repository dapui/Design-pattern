package composite.employee;

import composite.component.PayableNode;

public class Manager implements PayableNode {
    private int salary;

    public Manager(int salary) {
        this.salary = salary;
    }

    @Override
    public int getCost() {
        return salary;
    }
}
