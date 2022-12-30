package ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Example1 {
	public static void execute() {
		Scanner s=new Scanner(System.in);
		boolean run=true;
		DeptDAO dao=new DeptDAO();
		DeptVO vo=null;
		String dcode="", dname="";
		
		System.out.println("\n************************ 학 과 코 드 관 리 ********************");
		while(run) {
			System.out.println("\n===========================================================");
			System.out.println("1.코드등록 | 2.코드목록 | 3.코드수정 | 4.코드삭제 | 5.코드조회 | 0.종료");
			System.out.println("===========================================================");
			int menu=Main.input("선택");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("메인메뉴로 돌아갑니다.");
				break;
			case 1://코드등록
				String maxCode=dao.getMaxCode();
				int code=Integer.parseInt(maxCode.substring(1)) + 10;
				String newCode ="D" + code;
				System.out.println("학과코드>" + newCode);
				System.out.print("학과이름>");
				dname=s.nextLine();
				
				System.out.print("등록하실래요?");
				String sel=s.nextLine();
				if(sel.equals("Y")|| sel.equals("y") || sel.equals("ㅛ")) {
					vo=new DeptVO();
					vo.setDcode(newCode);
					vo.setDname(dname);
					dao.insert(vo);
					System.out.println("새로운 학과가 등록되었습니다.");
				}
				break;
			case 2://코드목록
				ArrayList<DeptVO> array=dao.list();
				for(DeptVO v:array) {
					System.out.printf("%s\t%s\n", v.getDcode(),
									v.getDname());
				}
				break;
			case 3://수정
				System.out.print("수정할 학과코드>");
				dcode=s.nextLine();
				vo=dao.read(dcode);
				if(vo.getDname()==null) {
					System.out.println("해당학과가 존재하지 않습니다.");
				}else {
					System.out.print("학과명:" + vo.getDname()+">");
					dname=s.nextLine();
					if(dname.equals("")) {
						System.out.println("수정이 취소되었습니다.");
					}else {
						System.out.print("수정하실래요?");
						sel=s.nextLine();
						if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							vo=new DeptVO();
							vo.setDcode(dcode);
							vo.setDname(dname);
							dao.update(vo);
							System.out.println("수정이 완료되었습니다.");
						}else {
							System.out.println("수정이 취소되었습니다.");
						}
					}
				}
				break;
			case 4://삭제
				System.out.print("학과코드>");
				dcode=s.nextLine();
				vo=dao.read(dcode);
				if(vo.getDname() == null) {
					System.out.println("해당학과가 존재하지 않습니다.");
				}else {//해당학과가 존재하는 경우
					System.out.println("학과이름>" + vo.getDname());
					System.out.print("정말로 삭제하실래요?");
					sel=s.nextLine();
					if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
						boolean success=dao.delete(dcode);
						if(success==true) {
							System.out.println("삭제가 완료되었습니다.");
						}else {
							System.out.println("이학과에 학생이 있어서 삭제할 수 없습니다.");
						}
					}else {
						System.out.println("삭제가 취소되었습니다.");
					}
				}
				break;
			case 5://조회
				System.out.print("학과코드>");
				dcode=s.nextLine();
				vo=dao.read(dcode);
				if(vo.getDname()==null) {
					System.out.println("해당학과가 존재하지 않습니다.");
				}else {
					System.out.println("학과이름>" + vo.getDname());
				}
				break;
			default:
				System.out.println("0~5번 메뉴를 선택하세요.");
			}
		}
	}
}
