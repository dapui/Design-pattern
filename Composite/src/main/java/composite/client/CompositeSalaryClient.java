package composite.client;

import composite.department.DevelopmentTeam;
import composite.department.HeadOffice;
import composite.employee.BackendDeveloper;
import composite.employee.FrontendDeveloper;
import composite.employee.Manager;

/**
 * 💡 비즈니스 로직을 담당하는 실행 클래스 (Client)
 */
public class CompositeSalaryClient {

    public static void main(String[] args) {
        System.out.println("=== 🌟 패턴 적용 후 (재귀와 위임) 총 급여 계산 ===");

        // 본사 생성
        HeadOffice headOffice = new HeadOffice();
        headOffice.addGroup(new Manager(10000));
        headOffice.addGroup(new Manager(9000));

        // 백엔드 팀 추가
        DevelopmentTeam backendTeam = new DevelopmentTeam();
        backendTeam.addMember(new BackendDeveloper(5000));
        backendTeam.addMember(new BackendDeveloper(6000));

        // 프론트엔드 팀 추가 (Basic에서는 HeadOffice 수정이 필요했지만, 여긴 아닙니다!)
        DevelopmentTeam frontendTeam = new DevelopmentTeam();
        frontendTeam.addMember(new FrontendDeveloper(5500));

        // 트리에 조립
        headOffice.addGroup(backendTeam);
        headOffice.addGroup(frontendTeam);

        // 🌟 마법 같은 한 줄!
        // 파라미터로 넘어온 rootNode가 '본사'이든 단일 '백엔드팀'이든 상관없습니다.
        // 그리고 내일 디자인 팀, 인사팀이 추가되어도
        // 서비스 코드는 단 1줄도 수정될 필요가 없습니다. (OCP 준수)
        int total = headOffice.getCost();

        System.out.println("회사 전체 총 급여 요약: " + total + "만 원\n");
    }
}
