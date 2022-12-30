

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {
	public static void execute() {
		Scanner s=new Scanner(System.in);
		boolean run=true;
		FacilityDAO fdao=new FacilityDAO();
		CampDAO cdao = new CampDAO();
		
		while(run) {
			System.out.println("\n************************ 시 설 물 관 리 ************************");
			System.out.println("-------------------------------------------------------------");
			System.out.println("1.등록 | 2.목록 | 3.삭제 | 4.등록(캠핑장) | 5.삭제(캠핑장) | 0.종료");
			System.out.println("-------------------------------------------------------------");
			System.out.print("선택>");
			int menu=s.nextInt();s.nextLine();
			switch(menu) {
			case 0:
				run=false;
				System.out.println("메인메뉴로 돌아갑니다.");
				break;
			case 1://등록
				String newCode=fdao.getNewCode();
				System.out.println("시설물코드>" +  newCode);
				System.out.print("시설물이름>");
				String fname=s.nextLine();
				if(fname.equals("")) {
					System.out.println("등록을 취소합니다.");
					break;
				}
				//새로운 시설물 등록
				fdao.insert(newCode, fname);
				System.out.println("새로운 시설물이 등록되었습니다.");
				break;
			case 2://목록
				ArrayList<FacilityVO> farray=fdao.list();
				for(FacilityVO f:farray) {
					System.out.printf("%s\t%s\n",f.getFcode(),f.getFname());
				}
				break;
			case 3:
				System.out.println("삭제할시설물코드 > ");
				String fcode = s.nextLine();
				if(fcode.equals("")) {
					System.out.println("삭제를 취소합니다.");
					break;
				}
				FacilityVO vo = fdao.read(fcode);
				if(vo.getFname()==null) {
					System.out.println("해당 시설물이 존재하지 않습니다.");
					break;
				}
				System.out.println("선택하신 " + vo.getFname()+ "을(를) 삭제하시겠습니까? (Y/N)");
				String sel=s.nextLine();
				if(sel.equals("ㅛ")||sel.equals("Y")||sel.equals("y")) {
					boolean success=fdao.delete(fcode);
					if(success==true) {
						System.out.println("삭제가 완료되었습니다.");
					}else {
						System.out.println("이 시설물을 사용중인 캠핑장이 있습니다.");
					}
					
				}else {
				System.out.println("삭제를 취소합니다.");
				}
				
				
				break;
			case 4:

				System.out.print("캠핑장 코드 > ");
				String code = s.nextLine();
				if(code.equals("")) {
					System.out.println("시설물 등록을 취소합니다.");
					break;
				}
				
				CampVO cvo = cdao.read(code);
				if(cvo.getCname()==null) {
					System.out.println("등록된 캠핑장이 없습니다.");
					break;
				}
				//캠핑장정보
				System.out.printf("캠핑장 이름 : %s(%s)\t주소 : %s \n", cvo.getCname(),cvo.getCode(),cvo.getAddress());
				//캠핑장 시설목록
				farray = fdao.list(code);
				System.out.printf("\n------현재 등록된 시설물--------------------------\n");
				for(FacilityVO f:farray) {
					System.out.printf("%s(%s) \t",f.getFname(),f.getFcode());
				}
				System.out.printf("\n\n------등록 가능한 목록--------------------------\n");
				ArrayList<FacilityVO> allArray = fdao.list();
				for(FacilityVO a:allArray) {
					boolean find = false;
					for(FacilityVO f:farray) {
						if(a.getFcode().equals(f.getFcode()))find=true;
					}
					if(find==false) {
						System.out.printf("%s(%s) \t",a.getFname(),a.getFcode());
					}
				

				}
				System.out.println("---------------------------------------------");
				System.out.println("등록 하실 시설물 코드 > ");
				fcode=s.nextLine();
				if(fcode.equals("")) {
					System.out.println(" 시설물 등록을 취소 합니다."); break;
				}
				FacilityVO fvo= fdao.read(fcode);
				if(fvo.getFname()==null) {
					System.out.println(" 시설물을 찾을 수 없습니다."); break;
				}
				fvo=fdao.read(code, fcode);
				if(fvo.getFname()==null) {
					fvo= new FacilityVO();
					fvo.setCode(code);
					fvo.setFcode(fcode);
					fdao.insert(fvo);	
					System.out.printf("%s(%s)이 등록되었습니다.",fvo,fcode);
				}else {
					System.out.println(" ["+fvo.getFname() + "] 는 이미 등록된 시설물입니다.");
				}
						

				break;
			case 5:
				break;
			default:
				System.out.println("0~5번 메뉴를 선택하세요.");
			}
		}
	}
}

























































































