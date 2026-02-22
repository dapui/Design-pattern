package basic.department;

import basic.employee.BackendDeveloper;
import java.util.ArrayList;
import java.util.List;

public class BackendTeam {
    // ⚠️ 특정 직군인 '백엔드 개발자'만 담을 수 있는 전용 리스트
    private List<BackendDeveloper> developers = new ArrayList<>();

    public void addBackendDev(BackendDeveloper dev) {
        developers.add(dev);
    }

    public List<BackendDeveloper> getDevelopers() {
        return developers;
    }

    // 예산을 구하려면 내부에서 명시적인 루프를 돌아야 합니다.
    public int getBackendTeamBudget() {
        int sum = 0;
        for (BackendDeveloper dev : developers) {
            sum += dev.getBackendSalary(); // ⬅️ 백엔드 전용 메서드 호출
        }
        return sum;
    }
}
