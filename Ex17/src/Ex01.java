import java.util.*;

public class Ex01 {
	public static void execute() {
		Scanner s =new Scanner(System.in);
		boolean run=true;
		CampVO vo= null;
		CampDAO dao = new CampDAO();
		FacilityVO fvo = null;
		FacilityDAO fdao = new FacilityDAO();
		TypeVO tvo = null;
		TypeDAO tdao = new TypeDAO();
		
		
		
		while(run) {
			System.out.println("┌────────────────────┐");
			System.out.println("│   1.캠핑장등록        \n│   2.캠핑장목록\n│   3.캠핑장 조회\n│   4.캠핑장 시설물 등록\n│   5.캠핑장 유형등록\n│   0.종료");
			System.out.println("└────────────────────┘");
			System.out.print("메뉴 선택 > ");
			int menu=s.nextInt();s.nextLine();
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			case 1:
				break;
			case 2:
				ArrayList<CampVO> array = dao.list();
				System.out.println("");
//				System.out.println("┌─────────────────────────────────────────┐");
				for(CampVO v:array) {
					System.out.println("─────────────────────────────────────────");
					System.out.println("    캠핑장 \t\t  주소                     ");
					System.out.println("=========================================");
					System.out.printf("  %s(%s)\t\t %s\n", v.getCname(),v.getCode(),v.getAddress());
					System.out.print("\n    시설물 - ");

					
					ArrayList<FacilityVO>farray = fdao.list(v.getCode());
					for(FacilityVO f:farray) {
						
					System.out.printf("  %s( %s)", f.getFname(),f.getFcode());					
				}
					System.out.print("\n    캠핑장 목록 - ");
					ArrayList<TypeVO>tarray = tdao.list(v.getCode());
					for(TypeVO t:tarray) {
						System.out.printf("   %s( %s)\t수량:%d개" , t.getTname(),t.getTcode(),t.getQnt());
					}
					
				System.out.println("\n─────────────────────────────────────────");
				System.out.println("");
				}
				break;
			case 3: 
				break;
			case 4: 
				Ex02.execute();
				break;
			case 5: 
				break;
			default:
				System.out.println("메뉴를 재선택 바랍니다.");

				
			}
		}
	}
}


























