import java.util.*;

public class Ex01 {

		public static void execute() {
//			int eng = Main.input("영어점수");
			CampDAO cdao = new CampDAO();
			CampVO vo = null;
			TypeDAO tdao = new TypeDAO();
			FacilDAO fdao= new FacilDAO();
			
			
			Scanner s =new Scanner(System.in);
			boolean run = true;
			while(run) {
				System.out.println("┌─────────────────────────────────────────────────────────────────────┐");
				System.out.println("│1.캠핑장등록 | 2. 캠핑장조회 | 3.캠핑장목록 | 4.시설물관리 | 5.종류관리 | 0. 종료 │ ");
				System.out.println("└─────────────────────────────────────────────────────────────────────┘");
				int menu = Main.input("선택 > ");
				switch (menu) {
				case 0:
					run = false;
					System.out.println("종료합니다.");
					break;
				case 1:
					int newCode = cdao.getLastCode()+100;
					System.out.println("캠핑장코드 : " + newCode);
					vo=new CampVO();
					vo.setCode(newCode);
					System.out.println("캠핑장 이름 > ");
					vo.setName(s.nextLine());
					System.out.println("캠핑장 주소 > ");
					vo.setAddress(s.nextLine());
					cdao.insert(vo);
					System.out.println(vo.getName() + "이 등록되었습니다.");
					
					
					
					break;
				case 2:
					int code = Main.input("조회할 캠핑장 코드를 입력바랍니다. ");
					
					vo = cdao.read(code);
					if(vo.getName()==null) {
						System.out.println("해당 갬핑장이 없습니다.");
					}else {
						System.out.print("캠핑장이름 : " + vo.getName());
						System.out.println("\t\t\t캠핑장주소 : "+ vo.getAddress());
						ArrayList<String> tarray = tdao.list(code);
						System.out.print("캠핑장타입 : ");
						if(tarray.size()==0)System.out.print("없음");
						for(String t:tarray) {
							System.out.print(t+"  ");
							
						}
						ArrayList<String> farray = fdao.list(code);
						System.out.print("\t시설물 : ");
						if(farray.size()==0)System.out.print("없음");
						for(String f:farray) {
							System.out.print(f + "  ");
						
					}
					System.out.println("");
					}
					
					break;
				case 3:
					
					System.out.println("====================================");
					System.out.println("코드\t 캠핑장이름\t 캠핑장주소");
					System.out.println("====================================");
					ArrayList<CampVO> carray = cdao.list();
					for(CampVO c:carray) {
						c.printing();
						//각 캠핑장별 type목록
						
						ArrayList<String> tarray = tdao.list(c.getCode());
						if(tarray.size()==0) System.out.println("캠핑장 타입 : 없음"); 
						for(String t:tarray) {
							
							System.out.println("\n┌────────────────────┐");
							System.out.println("│"+c.getName() + "의 타입 : "+t);
							System.out.println("└────────────────────┘");
						}
						ArrayList<String> farray = fdao.list(c.getCode());
						System.out.print("캠핑장 시설물 : ");
						if(farray.size()==0)System.out.print("없음");
						for (String f:farray) {
							System.out.print( f + "   ");
							}			
						System.out.println("\n=======================================");
						System.out.println("코드\t 캠핑장이름\t 캠핑장주소");
						System.out.println("=======================================");
						
							
						}
		
					
					System.out.println("\t\t\t\t\t\t\t 등록된 캠핑장수 : " + carray.size());
					
					
					
					break;
				case 4:
					Ex02.execute();
					
					
					break;
				case 5:
					Ex03.execute();
					break;
					
					default:
						System.out.println("메뉴를 재선택 바랍니다.");
				
				}
				
			}			
		}
}





