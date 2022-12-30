package ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner s=new Scanner(System.in);
		boolean run=true;
		TypeDAO dao=new TypeDAO();
		TypeVO vo=null;
		String tcode="";
		String tname="";
		
		System.out.println("\n************************ 타 입 코 드 관 리 ********************");
		while(run) {
			System.out.println("\n===========================================================");
			System.out.println("1.타입등록 | 2.타입목록 | 3.타입수정 | 4.타입삭제 | 5.타입조회 | 0.종료");
			System.out.println("===========================================================");
			int menu=Main.input("선택");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("메인메뉴로 돌아갑니다.");
				break;
			case 1://타입등록
				String maxCode=dao.getMaxCode();
				int code=Integer.parseInt(maxCode.substring(1)) + 10;
				String newCode="T" + code;
				System.out.println("타입코드>" + newCode);
				System.out.print("타입이름>");
				tname=s.nextLine();
				if(tname.equals("")) {
					System.out.println("등록을 취소합니다.");
					break;
				}
				//타입등록
				vo=new TypeVO();
				vo.setTcode(newCode);
				vo.setTname(tname);
				dao.insert(vo);
				System.out.println("새로운 타입이 등록되었습니다.");
				break;
			case 2://타입목록
				ArrayList<TypeVO> array=dao.list();
				for(TypeVO v:array) {
					System.out.printf("%s\t%s\t\t%s\n",v.getTcode(),
							v.getTname(), v.getTdate());
				}
				break;
			case 3://타입수정
				System.out.print("수정할 타입코드>");
				tcode=s.nextLine();
				vo=dao.read(tcode); //옛날값
				if(vo.getTname()==null) {
					System.out.println("해당 코드가 존재하지 않습니다."); //1
					break;
				}
				System.out.print("타입이름:" + vo.getTname() + ">");
				tname=s.nextLine();
				if(!tname.equals("")) vo.setTname(tname);//이름을 변경한경우
				
				System.out.print("시험일:" + vo.getTdate() + ">");
				String tdate=s.nextLine();
				if(!tdate.equals("")) vo.setTdate(tdate);//날짜를 변경한 경우
				
				//수정
				dao.update(vo);
				System.out.println("수정이 완료되었습니다."); //3
				break;
			case 4://타입삭제
				System.out.print("삭제할 타입코드>");
				tcode=s.nextLine();
				vo=dao.read(tcode);
				if(vo.getTname()==null) {
					System.out.println("해당 코드가 존재하지 않습니다."); //1
					break;
				}
				System.out.println("타입이름>" + vo.getTname());
				System.out.print("삭제하실래요?");
				String sel=s.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
					boolean success=dao.delete(tcode);
					if(success==true) {
						System.out.println("삭제가 완료되었습니다."); //2
					}else {
						System.out.println("성적테이블에서 사용중이여서 삭제할 수 없습니다.");//3
					}
				}else {
					System.out.println("삭제가 취소되었습니다.");//4
				}
				break;
			case 5://조회
				System.out.print("타입코드>");
				tcode=s.nextLine();
				vo=dao.read(tcode);
				if(vo.getTname()==null) {
					System.out.println("해당 코드가 존재하지 않습니다.");
					break;
				}
				System.out.println("타입이름>" + vo.getTname());
				System.out.println("시험일>" + vo.getTdate());
				
				
				
				
				
				
				break;
			default:
				System.out.println("0~5번 메뉴를 선택하세요.");
				
				
				
				
			}
		}
	}
}
