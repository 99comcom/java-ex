package ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Example3 {
	public static void execute() {
		Scanner s=new Scanner(System.in);
		boolean run=true;
		StudentDAO dao=new StudentDAO();
		StudentVO vo=null;
		String sno="";
		
		DeptDAO ddao=new DeptDAO();
		
		System.out.println("\n************************ 학 생  관 리 ********************");
		while(run) {
			System.out.println("\n===========================================================");
			System.out.println("1.학생등록 | 2.학생목록 | 3.학생수정 | 4.학생삭제 | 5.학생조회 | 0.종료");
			System.out.println("===========================================================");
			int menu=Main.input("선택");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("메인메뉴로 돌아갑니다.");
				break;
			case 1://학생등록
				String maxNo=dao.maxNo();
				int newNo=Integer.parseInt(maxNo) + 100;
				System.out.println("학번>" + newNo);
				

				System.out.print("이름>");
				String sname=s.nextLine();
				if(sname.equals("")) {
					System.out.println("학생등록을 취소합니다.");
					break;
				}
				
				//학과목록
				ArrayList<DeptVO> darray=ddao.list();
				for(DeptVO v:darray) {
					System.out.printf("%s:%s|",v.getDcode(),v.getDname());
				}
				System.out.println("");
				
				//학과입력
				boolean isFind=false;
				String dcode="";
				do {
					System.out.print("학과코드>");
					dcode=s.nextLine();
					if(dcode.equals("")) break;
					DeptVO v=ddao.read(dcode);
					if(v.getDname()!=null) isFind=true;
					if(isFind==false) System.out.println("해당되는 학과가 없습니다.");
				}while(isFind==false);
				
				if(dcode.equals("")) {
					System.out.println("학생등록을 취소합니다.");
					break;
				}
				//저장
				vo=new StudentVO();
				vo.setSno(String.valueOf(newNo));
				vo.setSname(sname);
				vo.setDcode(dcode);
				dao.insert(vo);
				System.out.println("새로운 학생이 등록되었습니다.");
				break;
			case 2:	//학생목록
				ArrayList<StudentVO> array=dao.list();
				for(StudentVO v:array) {
					System.out.printf("%s\t%s\t%s(%s)\n",
					v.getSno(),v.getSname(),v.getDcode(),v.getDname());
				}
				break;
			case 3://학생수정
				System.out.print("수정할 학번>");
				sno=s.nextLine();
				if(sno.equals("")) {
					System.out.println("수정을 취소합니다.");
					break;
				}
				vo=dao.read(sno);
				if(vo.getSname()==null) {
					System.out.println("해당 학생이 존재하지 않습니다.");
					break;
				}
				System.out.print("이름:" + vo.getSname() + ">");
				sname=s.nextLine();
				if(!sname.equals("")) vo.setSname(sname);
				
				//학과목록
				System.out.println("");
				darray=ddao.list();
				for(DeptVO v:darray) {
					System.out.printf("%s:%s|",v.getDcode(),v.getDname());
				}
				System.out.println("");
				
				isFind=false;
				do {
					System.out.printf("학과:%s(%s)>",vo.getDcode(),vo.getDname());
					dcode=s.nextLine();
					if(dcode.equals("")) break;
					DeptVO dvo=ddao.read(dcode);
					if(dvo.getDname()!=null) isFind=true;
					if(isFind==false) System.out.println("해당학과가 없습니다.");
				}while(isFind==false);
				
				if(!dcode.equals("")) vo.setDcode(dcode);
				//System.out.println(vo.toString());
				dao.update(vo);
				System.out.println("수정이 완료되었습니다.");
				break;
			case 4://학생삭제
				System.out.print("삭제할 학번>");
				sno=s.nextLine();
				if(sno.equals("")) {
					System.out.println("삭제를 취소합니다.");
					break;
				}
				vo=dao.read(sno);
				if(vo.getSname()==null) {
					System.out.println("해당 학생이 존재하지 않습니다.");
					break;
				}
				System.out.printf("%s(%s)\n",vo.getSname(),vo.getDname());
				System.out.print("삭제하실래요?");
				String sel=s.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
					//삭제
					boolean success=dao.delete(sno);
					if(success) {
						System.out.println("삭제가 완료되었습니다.");
					}else {
						System.out.println("성적 데이터가 존재해서 삭제할수없습니다.");
					}
				}
				break;
			case 5://학생조회
				System.out.print("조회할 학번>");
				sno=s.nextLine();
				vo=dao.read(sno);
				if(vo.getSname()==null) {
					System.out.println("해당 학생이 존재하지 않습니다.");
					break;
				}
				System.out.println("학생이름>" + vo.getSname());
				System.out.printf("학생학과>%s(%s)\n",vo.getDcode(),vo.getDname());
				break;
			default:
				System.out.println("0~5번 메뉴를 선택하세요.");
			}
		}
	}
}
