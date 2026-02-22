package composite.department;

import composite.component.PayableNode;
import java.util.ArrayList;
import java.util.List;

public class DevelopmentTeam implements PayableNode {
    // ⭐️ 직원이든 매니저든, 모두 공통 인터페이스 배열 하나로 수용!
    private List<PayableNode> members = new ArrayList<>();

    public void addMember(PayableNode node) {
        members.add(node);
    }

    @Override
    public int getCost() {
        int sum = 0;
        // 💫 내부에 들어있는게 매니저인지 개발자인지 알 필요 없이 getCost() 하나로 위임!
        for (PayableNode node : members) {
            sum += node.getCost();
        }
        return sum;
    }
}
