import java.util.*;

public class Ex02 {
public static void execute() {
		
		Scanner s=new Scanner(System.in);
		boolean run=true;
		String tcode = "";
		String tname = "";
		String sel = "";

		TypeVO vo = null;
		TypeDAO dao = new TypeDAO();
		
		
		System.out.println("\n**************************** 타 입 코 드 관 리 **************************** ");
		while(run) {
			System.out.println("\n┌────────────────────────────────────────────────────────────────┐");
			System.out.println("   1.타입등록 | 2.타입목록 | 3.타입수정 | 4.타입삭제 |5. 타입조회 | 0.종료");
			System.out.println("└────────────────────────────────────────────────────────────────┘");
			int menu=Main.input("선택");
			switch(menu) {
			case 0:
				System.out.println("메인페이지로 이동합니다.");
				run=false;
				break;
				 
			case 1://코드등록
				String maxCode = dao.gatMaxCode();
				int code =Integer.parseInt(maxCode.substring(1)) + 10 ;
				String newCode="T" + code;
				System.out.println("타입코드>" + newCode);
				System.out.println("타입 이름 > ");
				tname = s.nextLine();

				
				if(tname.equals("")) {
					System.out.println("등록을 취소합니다.");
				break;
				}
				vo=new TypeVO();
				vo.setTcode(newCode);
				vo.setTname(tname);

				dao.insert(vo);
				System.out.println(vo.getTname() + "등록이 완료 되었습니다.");
				
				break;
			case 2:
				ArrayList<TypeVO> array = dao.list();
				for(TypeVO v:array) {
					System.out.printf("%s\t%s\n" ,v.getTcode(),v.getTname());
				}
				
				break;
			case 3:
				System.out.println("수정할 타입 코드 > ");
				tcode = s.nextLine();
				vo = dao.read(tcode);
				if(vo.getTname()==null) {
					System.out.println(tcode + "가 존재하지 않습니다.");
					break;
				}
				System.out.println("타입 이름 : " + vo.getTname() + ">");
				tname = s.nextLine();
//				System.out.println("\n타입 시간 : " + vo.getTdate() + ">");
//				tdate = s.nextLine();
				if(tname.equals("")) {
					System.out.println("수정이 취소되었씁니다.");
					break;
				}
				vo=new TypeVO();
				vo.setTcode(tcode);
				vo.setTname(tname);


				dao.update(vo);
				System.out.println(vo.getTname() + "으로 수정이 완료되었습니다.");
				break;
			case 4:
				System.out.println("삭제하실 타입 코드 > ");
				tcode = s.nextLine();
				vo=dao.read(tcode);
				if(vo.getTname()==null) {
					System.out.println("해당 타입이 존재하지 않습니다.");
					
				}

				System.out.println("타입 이름 > " + vo.getTname());
				System.out.println(vo.getTname() + "를(을) 삭제하겠습니까? (Y,N) > ");
				sel=s.nextLine();
				if(sel.equals("Y")||sel.endsWith("y")) {

					boolean success = dao.delete(tcode);
					if (success==true) {
						System.out.println("삭제 되었습니다.");
					}else { 
						System.out.println("성적테이블에서 사용중이여서 삭제할 수 없습니다.");
					}
					}else {
						System.out.println("삭제가 취소되었습니다.");
				}
				
				break;
			case 5:
				System.out.println("타입코드 > ");
				tcode = s.nextLine();
				vo = dao.read(tcode);
				
				if(vo.getTname()==null) {
					System.out.println("해당 코드가 존재하지 않습니다.");
				}else {
					System.out.println("학과 이름 :" +vo.getTname());
				}
				break;
				
				default:
				System.out.println("메인메뉴로 돌아갑니다. 매뉴를 재선택 바랍니다.");
				
				
			}
		}
}

}
