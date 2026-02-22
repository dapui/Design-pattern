package basic.department;

import basic.employee.Manager;
import java.util.ArrayList;
import java.util.List;

public class HeadOffice {
    // ⚠️ 본사는 다양한 팀과 직군을 가져야 하므로, 리스트가 계속 늘어납니다.
    private List<Manager> headManagers = new ArrayList<>();
    private List<BackendTeam> backendTeams = new ArrayList<>();

    public void addManager(Manager m) {
        headManagers.add(m);
    }

    public void addBackendTeam(BackendTeam t) {
        backendTeams.add(t);
    }

    public List<Manager> getHeadManagers() {
        return headManagers;
    }

    public List<BackendTeam> getBackendTeams() {
        return backendTeams;
    }
}
