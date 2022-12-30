import java.text.*;
import java.util.*;



public class Ex01 {
	public static void execute() {
		Scanner s =new Scanner(System.in);
		boolean run = true;
		DecimalFormat df = new DecimalFormat("#,###원"); 

		AccountVO vo= null;
		AccountDAO dao = new AccountDAO();
		String ano = "";
		StatementDAO sdao= new StatementDAO();
		StatementVO svo = null;
		
		
		
		
		while(run) {
			System.out.println("┌────────────────────┐");
			System.out.println("│   1.계좌등록        \n│   2.계좌목록\n│   3.계좌조회\n│   4.입금\n│   5.출금\n│   0.종료");
			System.out.println("└────────────────────┘");
			System.out.print("메뉴 선택 > ");
			int menu=s.nextInt();s.nextLine();
			switch(menu) {
			case 0:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			case 1:
				String mno = dao.newMaxNo();
				int newNo=Integer.parseInt(mno) + 100; 
				System.out.println("계좌번호 : " + newNo);
				String aano = Integer.toString(newNo);
				System.out.print("계좌주 : ");
				String accname = s.nextLine();
				System.out.print("입금액 : ");
				int balance = s.nextInt(); s.nextLine();
				System.out.println("123");
				
				vo=new AccountVO();
				vo.setAno(aano);
				vo.setAname(accname);
				vo.setBalance(balance);
				dao.insert(vo);
				System.out.println(vo.getAname() +"님이 등록되셨습니다.");
				
				
				break;
				
			case 2:
				
				ArrayList<AccountVO> array = dao.list();

				for(AccountVO a:array) {
					String b = df.format(a.getBalance());
					System.out.printf(" %s\t %s \t잔액:%s \t계좌생성일:%s\n",a.getAno(),a.getAname(),b,a.getOdate());
	
					
					
				}
			
				
				break;
			case 3:
				System.out.print("조회하실 계좌번호를 눌러주세요 > ");
				ano=s.nextLine();
				vo=dao.read(ano);
				svo=sdao.read(ano);

				if(vo.getAname()==null) {
					System.out.println("등록되자 않은 계좌입니다.");
				}else {
					String b = df.format(vo.getBalance());
					System.out.printf("  %s\t%s\t\t%s\n",vo.getAname(),b,vo.getOdate());

					
					System.out.println("---입출금 내역------------------------------");
					ArrayList<StatementVO> sarray = sdao.list(ano);
					
					for(StatementVO ss:sarray) {
						
						
						String bb = df.format(ss.getAmount());
						System.out.printf(" %s\t %s \t:%s \t%s\n",ss.getAno(),ss.getTtype(),ss.getSdate(),bb);
					
						}
				}

					
				
				break;
			case 4:
				System.out.print("입금할 계좌번호를 눌러주세요 > ");
				ano=s.nextLine();
				vo=dao.read(ano);
				if(vo.getAname()==null) {
					System.out.println("등록되자 않은 계좌입니다.");
				}else {
					String b = df.format(vo.getBalance());
					System.out.printf(" 계좌주명:%s\n 잔액:%s\n",vo.getAname(),b);
					
				}
				System.out.println("입금 하실 금액 > ");
				int amount = s.nextInt(); s.nextLine();
				System.out.print("입금하시겠습니까? (Y/N)");
				String sel=s.nextLine();
				if(sel.equals("Y")|| sel.equals("y") || sel.equals("ㅛ")) {
					svo=new StatementVO();
					svo.setAno(ano);
					svo.setSdate("");
					svo.setTtype("입금");
					svo.setAmount(amount);
					sdao.insert(svo);
					System.out.println("입금이 완료되었습니다.");
				}
				

				int sum = vo.getBalance() + amount ;
				System.out.println(sum);
				vo.setAno(ano);
				vo.setBalance(sum);
				System.out.println("1");
				dao.update(vo);

				System.out.println("2");
				
				
				break;
			case 5:
				System.out.print("입금할 계좌번호를 눌러주세요 > ");
				ano=s.nextLine();
				vo=dao.read(ano);
				
				if(vo.getAname()==null) {
					System.out.println("등록되자 않은 계좌입니다.");
				}else {
					String b = df.format(vo.getBalance());
					System.out.printf(" 계좌주명:%s\n 잔액:%s\n",vo.getAname(),b);
					
				}
				System.out.println("출금 하실 금액 > ");
				amount = s.nextInt(); s.nextLine();
				System.out.print("출금하시겠습니까? (Y/N)");
				sel=s.nextLine();
				if(sel.equals("Y")|| sel.equals("y") || sel.equals("ㅛ")) {
					if(vo.getBalance()<amount) {
						 System.out.println("잔액이 부족합니다.");
					}else {
					
					svo=new StatementVO();
					svo.setAno(ano);
					svo.setSdate("");
					svo.setTtype("출금");
					svo.setAmount(amount);
					sdao.insert(svo);
					System.out.println("출금이 완료되었습니다.");

					
					//잔액 변경
					sum = vo.getBalance() - amount ;
					vo.setAno(ano);
					vo.setBalance(sum);
					dao.update(vo);

//					
					}
				}
		
				
				
				
				
				
				break;
				default:
					System.out.println("메뉴를 재선택 바랍니다.");
					
				
			
			
		}
		
	}
	}
}

