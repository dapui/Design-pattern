package composite.department;

import composite.component.PayableComponent;
import java.util.ArrayList;
import java.util.List;

// 3. Composite (복합 객체)
public class DevelopmentTeamComposite implements PayableComponent {
    // ⭐️ Leaf(직원)든 또 다른 Composite(하위 팀)이든 공통 컴포넌트(PayableComponent) 리스트 하나로 수용!
    private List<PayableComponent> components = new ArrayList<>();

    public void addComponent(PayableComponent component) {
        components.add(component);
    }

    @Override
    public int getCost() {
        int sum = 0;
        // 💫 내부에 들어있는게 Leaf인지 Composite인지 알 필요 없이 getCost() 하나로 위임!
        for (PayableComponent component : components) {
            sum += component.getCost(); // 만약 Composite라면 이 안에서 재귀 호출!
        }
        return sum;
    }
}
