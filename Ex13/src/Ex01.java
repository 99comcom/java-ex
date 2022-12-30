import java.util.*;

public class Ex01 {
	
	
	public static void execter () {
		boolean run = true;
		Scanner s = new Scanner (System.in);
		StudentVO vo = null;
		StudentDAO dao = new StudentDAO();
		ScoreDAO sdao = new ScoreDAO();
		ScoreVO svo = null;
		
		
		while(run) {
			System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣학생성적관리￣￣￣￣￣￣￣￣￣￣￣");
			System.out.println("1.학생등록 | 2.조회 | 3.목록 | 4.성적등록 | 0.종료 ");
			System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
			System.out.print("메뉴를 선택하여 주세요 > ");
			String menu = s.nextLine();
			System.out.print("\n");

			switch ( menu ) {
			case "1":
				int newNo = dao.getMaxNo()+100;
				System.out.println("학번:" + newNo);
				vo=new StudentVO();
				vo.setNo(newNo);
				
				System.out.print("이름 > ");
				vo.setName(s.nextLine());
				
				System.out.print("주소 > ");
				vo.setAddress(s.nextLine());
				
				dao.insert(vo);
				
				System.out.println(vo.getName()+"이(가) 등록되었습니다.");
				
				break;
			case "2":
				String sno="";
				boolean isNumber=false;
				do {
					System.out.println("검색 하실 학번 > ");
					sno=s.nextLine();
					isNumber=sno.matches("-?\\d+(\\.\\d+)?");
				}while(isNumber==false);
				
				vo=dao.read(Integer.parseInt(sno));
				if(vo.getName()==null) {
					System.out.println("해당 학생이 없습니다.");
					
				}else {
					vo.print();
					ArrayList<ScoreVO> tarray=sdao.list(Integer.parseInt(sno));
					for(ScoreVO v:tarray) {
						v.sprint();
						v.toString();
					}
				}
				break;
			case "3":
				ArrayList<StudentVO> array = dao.list();
				for(StudentVO v:array) {
					v.print();
					
				}
				System.out.println("\n전체 학생은" + array.size() + "명 입니다.\n");
				break;
			case "4":

				String dno = "";
				isNumber=false;
				do {
					System.out.print("학번 > ");
					dno=s.nextLine();
					isNumber=dno.matches("-?\\d+(\\.\\d+)?");
					
				}while(isNumber==false);
				
				 vo=dao.read(Integer.parseInt(dno));
				if(vo.getName()==null) {
					System.out.println("해당 학생이 없습니다.");
					
				}else {
					System.out.printf("%s(%s)\n",vo.getName(),vo.getAddress());
					System.out.println("--------------------------------------------------------");
				    System.out.println("구분\t국어\t영어\t수학\t총점\t평균");
				    System.out.println("--------------------------------------------------------");
					ArrayList<ScoreVO> tarray=sdao.list(Integer.parseInt(dno));
					for(ScoreVO v:tarray) {
						v.sprint();

				
					System.out.print("구분 > ");
					String type=s.nextLine();
			
					
					
					
						
				
					String kor = "";
					isNumber=false;
					do {
						System.out.print("국어 > ");
						kor=s.nextLine();
						isNumber=kor.matches("-?\\d+(\\.\\d+)?");
					}while(isNumber==false);
					
					String eng = "";
					isNumber=false;
					do {
						System.out.print("영어 > ");
						eng=s.nextLine();
						isNumber=eng.matches("-?\\d+(\\.\\d+)?");
					}while(isNumber==false);
					
					String mat = "";
					isNumber=false;
					do {
						System.out.print("수학 > ");
						mat=s.nextLine();
						isNumber=mat.matches("-?\\d+(\\.\\d+)?");
					}while(isNumber==false);
					
					svo = new ScoreVO();
					svo.setNo(Integer.parseInt(dno));
					svo.setType(type);
					svo.setKor(Integer.parseInt(kor));
					svo.setEng(Integer.parseInt(eng));
					svo.setMat(Integer.parseInt(mat));
					sdao.insert(svo);
					
					
					
					
					
					System.out.println("성적 변경이 완료되었습니다.");
					
					
					}
					}
					
				break;
				
				
			case "0":
				System.out.println("종료합니다.");
				run=false;
				
				break;
				
				default:
					System.out.println("잘못된 입력입니다. 재 선택 바랍니다.");
			}
			
			
			
			
			
			
		}
		
	
	}
		
}
	

