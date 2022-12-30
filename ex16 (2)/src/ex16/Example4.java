package ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Example4 {
	public static void execute() {
		Scanner s=new Scanner(System.in);
		boolean run=true;
		
		StudentDAO sdao=new StudentDAO();
		ScoreDAO dao=new ScoreDAO();
		TypeDAO tdao=new TypeDAO();
			
		System.out.println("\n**************** 성 적  관 리 **************");
		while(run) {
			System.out.println("\n============================================");
			System.out.println("1.성적조회 | 2.성적입력 | 3.성적삭제 | 0.종료");
			System.out.println("============================================");
			int menu=Main.input("선택");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("메인메뉴로 돌아갑니다.");
				break;
			case 1:
				System.out.print("조회할 학번>");
				String sno=s.nextLine();
				if(sno.equals("")) {
					System.out.println("조회를 취소합니다.");//1
					break;
				}
				StudentVO svo=sdao.read(sno);
				if(svo.getSname()==null) {
					System.out.println("해당학생이 존재하지 않습니다.");//2
					break;
				}
				System.out.printf("%s(%s)\n",svo.getSname(),svo.getDname());//3
				ArrayList<ScoreVO> array=dao.list(sno);
				for(ScoreVO v:array) {
					System.out.printf("%s(%s)\t%s\t%d\n",
						v.getTname(),v.getTcode(),v.getTdate(),v.getGrade());
				}
				break;
			case 2://성적등록
				System.out.print("등록할 학번>");
				sno=s.nextLine();
				if(sno.equals("")) {
					System.out.println("성적등록을 취소합니다.");
					break;
				}
				svo=sdao.read(sno);
				if(svo.getSname()==null) {
					System.out.println("해당학생이 존재하지 않습니다.");//2
					break;
				}
				
				//학생정보출력
				System.out.printf("%s(%s)\n",svo.getSname(),svo.getDname());//3
				array=dao.list(sno);
				for(ScoreVO v:array) {
					System.out.printf("%s(%s)\t%s\t%d\n",
						v.getTname(),v.getTcode(),v.getTdate(),v.getGrade());
				}
				System.out.println("");
				//성적입력
				ArrayList<TypeVO> tarray=tdao.list();
				for(TypeVO v:tarray) {
					System.out.printf("%s:%s|",v.getTcode(),v.getTname());
				}
				System.out.println("");
				
				String tcode="";
				int count=0;
				do {
					System.out.print("시험유형>");
					tcode=s.nextLine();
					if(tcode.equals("")) break;
					
					count=dao.read(sno, tcode);
					if(count==1) break;
					
					TypeVO tvo=tdao.read(tcode);
					if(tvo.getTname()!=null) break;
				}while(true);
				
				if(tcode.equals("")) {
					System.out.println("성적등록을 취소합니다."); //1
					break;
				}
				
				if(count==1) {
					System.out.println("이미 등록된 성적입니다.");//2
					break;
				}
				
				//성적등록
				int grade=Main.input("성적");
				ScoreVO vo=new ScoreVO();
				vo.setSno(sno);
				vo.setTcode(tcode);
				vo.setGrade(grade);
				//System.out.println(vo.toString()); //3
				dao.insert(vo);
				System.out.println("성적이 등록되었습니다.");
				break;
			case 3://삭제
				System.out.print("삭제할학번>");
				sno=s.nextLine();
				svo=sdao.read(sno);
				if(svo.getSname()==null) {
					System.out.println("해당학생이 존재하지 않습니다.");//2
					break;
				}
				//학생정보출력
				System.out.printf("%s(%s)\n",svo.getSname(),svo.getDname());//3
				array=dao.list(sno);
				for(ScoreVO v:array) {
					System.out.printf("%s(%s)\t%s\t%d\n",
						v.getTname(),v.getTcode(),v.getTdate(),v.getGrade());
				}
				System.out.println("");
				
				count=0;
				do {
					System.out.print("삭제유형>");
					tcode=s.nextLine();
					
					if(tcode.equals("")) break;
					
					count=dao.read(sno, tcode);
					if(count==0) System.out.println("삭제할 데이터가 없습니다.");//1
					else break;
				}while(true);
				
				if(tcode.equals("")) {
					System.out.println("삭제를 취소합니다.");//2
					break;
				}
				
				//삭제
				System.out.print("삭제하실래요?"); //3
				String sel=s.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")){
					dao.delete(sno, tcode);
					System.out.println("성적 삭제가 완료되었습니다.");
				}else {
					System.out.println("삭제가 취소되었습니다.");
				}
				break;
			default:
				System.out.println("0~3 메뉴를 선택하세요.");
			}
		}
	}
}
