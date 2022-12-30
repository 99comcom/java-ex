import java.util.*;


public class Ex01 {
	public static void execute() {
		Scanner s =new Scanner(System.in);
		boolean run = true;
		AccountVO vo= null;
		AccountDAO dao = new AccountDAO();
		
		
		
		
		while(run) {
			System.out.println("┌────────────────────┐");
			System.out.println("│ 11  1.계좌등록        \n│   2.계좌목록\n│   3.계좌조회\n│   4.입금\n│   5.출금\n│   0.종료");
			System.out.println("└────────────────────┘");
			System.out.print("메뉴 선택 > ");
			int menu=s.nextInt();s.nextLine();
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			case 1:
				break;
				
			case 2:
				ArrayList<AccountVO> array = dao.list();
				for(AccountVO a:array) {
					System.out.printf("계좌주명 : %s \t잔액 : %d \t계좌생성일 : %s",a.getAname(),a.getBalance(),a.getOdate());
					
					
				}
				
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
				default:
					System.out.println("메뉴를 재선택 바랍니다.");
					
				
			
			
		}
		
	}
	}
}
