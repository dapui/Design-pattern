package basic.client;

import basic.department.BackendTeam;
import basic.department.HeadOffice;
import basic.employee.BackendDeveloper;
import basic.employee.Manager;

/**
 * [문제점 확인] 비즈니스 로직을 담당하는 실행 클래스 (Client)
 */
public class BasicSalaryClient {

    public static void main(String[] args) {
        System.out.println("=== 🚨 패턴 적용 전 총 급여 계산 ===");

        // 조직도 세팅
        HeadOffice headOffice = new HeadOffice();
        headOffice.addManager(new Manager(10000));
        headOffice.addManager(new Manager(9000));

        BackendTeam backendTeam = new BackendTeam();
        backendTeam.addBackendDev(new BackendDeveloper(5000));
        backendTeam.addBackendDev(new BackendDeveloper(6000));

        headOffice.addBackendTeam(backendTeam);

        // 총 급여 계산
        int total = 0;

        // 1. 본사 매니저들 급여 합산 (호출 메서드: getManagerSalary)
        for (Manager manager : headOffice.getHeadManagers()) {
            total += manager.getManagerSalary();
        }

        // 2. 본사 산하 백엔드 팀 예산 합산 (호출 메서드: getBackendTeamBudget)
        for (BackendTeam team : headOffice.getBackendTeams()) {
            total += team.getBackendTeamBudget();
        }

        /*
         * ❌ 치명적인 단점 (OCP 위반):
         * 만약 내일 회사 조직도에 '프론트엔드 팀', '데이터 팀'이 새로 생긴다면?
         * HeadOffice에 List를 추가해야 하고, 이 main 파일에도 for문 분기가 N개씩 늘어납니다.
         */

        System.out.println("회사 전체 총 급여 요약: " + total + "만 원\n");
    }
}
