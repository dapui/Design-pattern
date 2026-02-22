package composite.department;

import composite.component.PayableComponent;
import java.util.ArrayList;
import java.util.List;

// 3. Composite (복합 객체)
public class HeadOfficeComposite implements PayableComponent {
    // 본사 역시 Composite 이므로 공통 컴포넌트 리스트 하나로 퉁칩니다.
    private List<PayableComponent> components = new ArrayList<>();

    public void addComponent(PayableComponent component) {
        components.add(component);
    }

    @Override
    public int getCost() {
        int sum = 0;
        for (PayableComponent component : components) {
            sum += component.getCost();
        }
        return sum;
    }
}
