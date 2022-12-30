import java.util.*;
public class Ex02 {
	public static void execute() {
		
		Scanner s = new Scanner(System.in);
		boolean run = true;
		CampDAO cdao = new CampDAO();
		CampVO vo = null;
		String[] facility = {"화장실","전기", "수도","와이파이","놀이터","수영장","편의점"};
		FacilDAO fdao = new FacilDAO();
		
		
		while(run) {
			System.out.println("┌───────────────────────────────────┐");
			System.out.println("│1.시설물등록 | 2. 시설물삭제 | 0.이전메뉴 │ ");
			System.out.println("└───────────────────────────────────┘");
			int menu=Main.input("메뉴선택 ");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
				
			case 1:
				int code = Main.input("캠핑장번호 ");
				vo = cdao.read(code);
				if(vo.getName()==null) {
					System.out.println("해당 캠핑장이 없습니다.");
					break;
				}			
				
				System.out.println("캠핑장이름 : " + vo.getAddress());
				System.out.println("----------------------------------------------------");
				
				ArrayList<String> farray = fdao.list(code);
				ArrayList<String> check = new ArrayList<>();
					for(int i=0;i<facility.length;i++) {
//						System.out.printf("[%d]%s\n" , i ,facility[i]);
						boolean isFind=false;
						for(String f:farray) {
							if(facility[i].equals(f)) isFind=true;
							
							}
							if(isFind==true) check.add("O");
						
							else check.add("X");
							System.out.printf("[%d]%s(%s)\n",i,facility[i],check.get(i));
							
							
						}
						System.out.println("-------------------------------");
						int sel=Main.input("시설물선택 ");
						if(sel==0)break;
						if(check.get(sel).equals("O")){
							System.out.println("등록된 시설물 입니다.");
							break;
						}
					fdao.insert(code, facility[sel]);
					System.out.println(facility[sel] + "이 등록되었습니다.");
				
				break;
					
			
				
			case 2:
				code = Main.input("캠핑장번호 ");
				vo = cdao.read(code);
				if(vo.getName()==null) {
					System.out.println("해당 캠핑장이 없습니다.");
					break;
				}			
				
				System.out.println("캠핑장이름 : " + vo.getAddress());
				System.out.println("----------------------------------------------------");
				
				farray = fdao.list(code);
			   check = new ArrayList<>();
					for(int i=0;i<facility.length;i++) {
//						System.out.printf("[%d]%s\n" , i ,facility[i]);
						boolean isFind=false;
						for(String f:farray) {
							if(facility[i].equals(f)) isFind=true;
							
							}
							if(isFind==true) check.add("O");
						
							else check.add("X");
							
							System.out.printf("취소는 0을 눌러주세요 \n[%d]%s(%s)\n",i,facility[i],check.get(i));
							
							
						}
						System.out.println("-------------------------------");
						sel=Main.input("시설물선택 ");
						if(sel==0)break;
						if(check.get(sel).equals("X")){
							System.out.println("등록되지 않은 시설물 입니다. 등록된 시설물은 선택바랍니다.");
							break;
						}
						fdao.delete(code, facility[sel]);
						System.out.println(facility[sel] + "이 삭제되었습니다.");
				break;
				
				default:
					System.out.println("0~2번 메뉴를 선택하세요.");
			
			
			
			}
		}
		
		
		
	}

}
