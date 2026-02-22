package composite.employee;

import composite.component.PayableComponent;

// 2. Leaf (단일 객체)
public class FrontendDeveloperLeaf implements PayableComponent {
    private int salary;

    public FrontendDeveloperLeaf(int salary) {
        this.salary = salary;
    }

    @Override
    public int getCost() {
        return salary;
    }
}
