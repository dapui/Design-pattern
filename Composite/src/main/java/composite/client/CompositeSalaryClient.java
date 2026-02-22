package composite.client;

import composite.department.DevelopmentTeamComposite;
import composite.department.HeadOfficeComposite;
import composite.employee.BackendDeveloperLeaf;
import composite.employee.FrontendDeveloperLeaf;
import composite.employee.ManagerLeaf;

/**
 * 💡 비즈니스 로직을 담당하는 실행 클래스 (Client)
 */
public class CompositeSalaryClient {

    public static void main(String[] args) {
        System.out.println("=== 🌟 패턴 적용 후 (재귀와 위임) 총 급여 계산 ===");

        // 본사 (Composite) 생성
        HeadOfficeComposite headOffice = new HeadOfficeComposite();
        headOffice.addComponent(new ManagerLeaf(10000));
        headOffice.addComponent(new ManagerLeaf(9000)); // Manager (Leaf) 추가

        // 백엔드 팀 (Composite) 추가
        DevelopmentTeamComposite backendTeam = new DevelopmentTeamComposite();
        backendTeam.addComponent(new BackendDeveloperLeaf(5000));
        backendTeam.addComponent(new BackendDeveloperLeaf(6000)); // BackendDeveloper (Leaf) 추가

        // 프론트엔드 팀 (Composite) 추가
        DevelopmentTeamComposite frontendTeam = new DevelopmentTeamComposite();
        frontendTeam.addComponent(new FrontendDeveloperLeaf(5500)); // FrontendDeveloper (Leaf) 추가

        // 트리에 조립 (Composite 안에 Composite 과 Leaf 모두 제한 없이 동일하게 추가)
        headOffice.addComponent(backendTeam);
        headOffice.addComponent(frontendTeam);

        // 🌟 마법 같은 한 줄!
        // 파라미터로 넘어온 rootNode가 '본사(Composite)'이든 '단일직원(Leaf)'이든 상관없습니다.
        // 클라이언트 코드는 아무런 타입 비교도 없이 딱 한 줄의 위임만으로 이 모든 계층을 재귀 돌립니다! (OCP 준수)
        int total = headOffice.getCost();

        System.out.println("회사 전체 총 급여 요약: " + total + "만 원\n");
    }
}
