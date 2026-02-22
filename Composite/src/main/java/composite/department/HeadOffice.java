package composite.department;

import composite.component.PayableNode;
import java.util.ArrayList;
import java.util.List;

public class HeadOffice implements PayableNode {
    // 본사 역시 그룹 노드(Composite)이므로 공통 인터페이스 리스트 하나로 퉁칩니다.
    private List<PayableNode> groups = new ArrayList<>();

    public void addGroup(PayableNode node) {
        groups.add(node);
    }

    @Override
    public int getCost() {
        int sum = 0;
        for (PayableNode node : groups) {
            sum += node.getCost();
        }
        return sum;
    }
}
