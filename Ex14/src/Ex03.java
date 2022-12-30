import java.util.*;

import javax.sound.sampled.BooleanControl.Type;

public class Ex03 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		boolean run = true;
		CampDAO cdao = new CampDAO();
		CampVO vo = null;
		TypeDAO tdao = new TypeDAO();
		String[] type = {"취소","오토캠핑장","카라반","글램핑","펜션"};
		
		
		while(run) {
			System.out.println("┌─────────────────────────────────────────┐");
			System.out.println("│1.시설물종류등록 | 2. 시설물종료삭제 | 0.이전메뉴 │ ");
			System.out.println("└─────────────────────────────────────────┘");
			int menu=Main.input("메뉴선택 ");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
			case 1:
				int code = Main.input("캠핑장번호 선택 ");
				vo=cdao.read(code);
				if(vo.getName()==null) {
					System.out.println("해당 캠핑장이 존재하지 않습니다.");
					break;
				}
				System.out.println("캠핑장이름:" + vo.getName());
				System.out.println("------------------------------------------------------");

				ArrayList<String> check = new ArrayList<>();
				ArrayList<String> tarray = tdao.list(code);
				for(int i=0;i<type.length;i++) {
					boolean isFind=false;
					for(String t:tarray) {
						if(t.equals(type[i])) isFind = true;
					}
					if(isFind) check.add("O");
						else check.add("X");
					
					System.out.printf("[%d] %s(%s)\n",i,type[i],check.get(i));
					
				}
				
				int sel=Main.input("종류번호");
				if(sel==0) break;
				if(check.get(sel).equals("0")) {
					System.out.println(type[sel]+"종류가 이미 등록되어있습니다.");
					break;
				}
				tdao.insert(code, type[sel]);
				System.out.println(type[sel] + "유형이 등록되었습니다.");
						
				
				break;
			case 2:
				code = Main.input("캠핑장번호 선택 ");
				vo=cdao.read(code);
				if(vo.getName()==null) {
					System.out.println("해당 캠핑장이 존재하지 않습니다.");
					break;
				}
				System.out.println("캠핑장이름:" + vo.getName());
				System.out.println("------------------------------------------------------");

				check = new ArrayList<>();
				 tarray = tdao.list(code);
				for(int i=0;i<type.length;i++) {
					boolean isFind=false;
					for(String t:tarray) {
						if(t.equals(type[i])) isFind = true;
					}
					if(isFind) check.add("O");
						else check.add("X");
					
					System.out.printf("[%d] %s(%s)\n",i,type[i],check.get(i));
					
				}
				sel=Main.input("종류번호");
				if(sel==0) break;
				if(check.get(sel).equals("X")) {
					System.out.println(type[sel]+"종류가 등록되어 있지 않아 삭제가 불가능합니다. 재 선택바랍니다.");
					break;
				}
				tdao.delete(code, type[sel]);
				System.out.println(type[sel] + "유형이 삭제되었습니다.");
				break;
				
				default:
					System.out.println("0~2번 메뉴를 선택하세요.");
				
				
			}
	}
}
}