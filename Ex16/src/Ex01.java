import java.util.*;



public class Ex01 {

	public static void execute() {
		
		Scanner s=new Scanner(System.in);
		boolean run=true;
		DeptDAO dao = new DeptDAO();
		DeptVO vo = null;
		String dcode = "";
		
		System.out.println("\n****************** 학 과 코 드 관 리 **************");
		while(run) {
			System.out.println("\n┌────────────────────────────────────────────────────────────────┐");
			System.out.println("   1.코드등록 | 2.코드목록 | 3.코드수정 | 4.학과삭제 |5. 학과조회 | 0.종료");
			System.out.println("└────────────────────────────────────────────────────────────────┘");
			int menu=Main.input("선택");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("메인페이지로 이동합니다.");
				
				 break;
			case 1://코드등록
				String maxCode=dao.getMaxCode();
				int code =Integer.parseInt(maxCode.substring(1)) + 10 ;
				String newCode = "D" + code;
				System.out.println("학과 코드 > "+ newCode);
				System.out.print("학과 이름 > ");
				String dname =s.nextLine();
				
				System.out.println("등록하겠습니까? (Y,N) > ");
				String sel = s.nextLine();
				if(sel.equals("y")||sel.equals("Y")) {
				
				vo=new DeptVO();
				vo.setDcode(newCode);
				vo.setDname(dname);
				dao.insert(vo);
				System.out.println("새로운 <" + vo.getDname()+  "> 학과가 등록이 완료되었습니다.");
				}else {
					System.out.println("등록이 취소되었습니다.");
				}
				break;
				
			case 2:
				ArrayList<DeptVO> array  = dao.list();
				for(DeptVO v:array) {
					System.out.printf("%s\t%s\n" ,v.getDcode(),v.getDname());
					
					
				}
				break;
			case 3:
				System.out.println("수정할 학과 코드");
				dcode = s.nextLine();
				vo = dao.read(dcode);
				if(vo.getDname()==null) {
					System.out.println(dcode + "학과가 존재하지 않습니다.");
					
				}else {
					System.out.print("현재 학과명:" + vo.getDname() + "\t 변경하실 학과명 > ");
					dname=s.nextLine();
					if(dname.equals("")) {
						System.out.println("수정이 취소 되었습니다.");
					}else {
						System.out.println("수정하겠습니까? (Y,N) > ");
						sel = s.nextLine();
						if(sel.equals("y")||sel.equals("Y")) {
							vo=new DeptVO();
							vo.setDcode(dcode);
							vo.setDname(dname);
							dao.update(vo);
							System.out.println(dname + "으로 수정이 완료되었습니다.");
							
							
						}
			
					}
				}
				
				
				
				
				
				break;
				
			case 4:
				System.out.println("삭제하실 학과 코드 > ");
				dcode = s.nextLine();
				vo = dao.read(dcode);
				if(vo.getDname()==null) {
					System.out.println("해당 학과가 존재하지 않습니다.");
				}else {
					System.out.println(vo.getDname() + "학과를 삭제하겠습니까? (Y,N) > ");
					sel=s.nextLine();
					if(sel.equals("Y")||sel.endsWith("y")) {
						
						boolean success = dao.delete(dcode);
						if (success==true) {
							
						
							System.out.println("삭제되었습니다.");
						
					}else {
						System.out.println("해당 학과에 학생이 존재하여 삭제가 불가능합니다.");
					}
						
					}else {
					System.out.println("삭제가 취소되었습니다.");
					}
					
				}
				break;
				
			case 5:
				System.out.println("학과코드 > ");
				dcode = s.nextLine();
				vo=dao.read(dcode);
				if(vo.getDname()==null) {
					System.out.println("해당 학과가 존재하지 않습니다.");
				}else {
					System.out.println("학과 이름 : " + vo.getDname());
				}
				break;
				

				default:
					System.out.println("메뉴를 재선택 바랍니다.");
				
		
			}
	
		}
	}
}