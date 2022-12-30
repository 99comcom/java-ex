import java.text.*;
import java.util.*;



public class Ex01 {
	public static void execter () {
		Scanner s =new Scanner(System.in);
		boolean run = true;
		AccountDAOImpl dao = new AccountDAOImpl();
		AccountVO vo = null;
		DecimalFormat df =new DecimalFormat("#.###원");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		TradeDAO tdao = new TradeDAO();
		TradeVO tvo = null;
		
		
		
		while(run) {
		

		System.out.println("\n============================= 통 장 관 리========== ");
		System.out.println("1.생성 | 2.조회 | 3.입금 | 4.츌굼 | 5.목록 | 0.종료 |");
		System.out.println("================================================+");
		
		System.out.print("메뉴를 선택하여 주세요 > ");
		String mun = s.nextLine();
		System.out.print("\n");

		switch(mun) {
		case "0":
			System.out.println("종료합니다.");
			run=false;
			
			break;
		case "1":
			int newno = dao.getLastNo() + 100;
			System.out.println("계좌번호 : " + newno);
			
			vo= new AccountVO();
			vo.setNo(newno);
			System.out.println("이름 > ");
			vo.setName(s.nextLine());
			
			boolean isNumber = false;
			String balnace = "";
			
			do {
				System.out.println("입금액 > ");
				balnace = s.nextLine();

				isNumber=balnace.matches("-?\\d+(\\.\\d+)?");
				if(isNumber == false) System.out.println("숫자만 입력 가능합니다.");
			
				
			}while(isNumber==false);
				
			
//			vo.setBalance(s.nextInt());s.nextLine();
			vo.setBalance(Integer.parseInt(balnace));
			dao.insert(vo);
			System.out.println(vo.getName() + "이(가)등록이 완료되었습니다.");
			
			//거래내역등록
			tvo=new TradeVO();
			tvo.setNo(newno);
			tvo.setDate(sdf.format(new Date()));
			tvo.setType("입금");
			tvo.setAmount(Integer.parseInt(balnace));
			tdao.insert(tvo);
			
			System.out.println("입금이 종료되었습니다.");
			
			break;
			
		case "3" :
//			isNumber = false;
//			String sno = "";
//			do {
//				System.out.print("입금하실 계좌를 입력바랍니다. > ");
//				sno =s.nextLine();
//				System.out.print("\n");
//				isNumber=sno.matches("-?\\d+(\\.\\d+)?");
//				if(isNumber==false) 
//					System.out.println("숫자로 입력 바랍니다.");
//			}while(isNumber == false);
//			
//			
//			vo = dao.read(Integer.parseInt(sno));
//		
//			if(vo.getName()==null) {
//				System.out.println("해당 구좌가 없습니다.");
//			}else {
//				System.out.println("계좌주명 > " + vo.getNo());
//				System.out.println("계좌주명 > " + vo.getBalance());
//				
//				String price="";
//				isNumber=false;
//				
//				do {
//				System.out.println("입금액 > ");
//				price=s.nextLine();
//				isNumber=sno.matches("-?\\d+(\\.\\d+)?");
//				if(isNumber==false) 
//					System.out.println("숫자로 입력 바랍니다.");
//			}while(isNumber == false);
//			
//				
//				//잔액에 입금액추가
//				dao.trade(Integer.parseInt(sno), Integer.parseInt(price));
//				//거래내역등록
//				tvo=new TradeVO();
//				tvo.setNo(Integer.parseInt(sno));
//				tvo.setDate(sdf.format(new Date()));
//				tvo.setType("입금");
//				tvo.setAmount(Integer.parseInt(price));
//				tdao.insert(tvo);
//				
//				System.out.println("입금이 종료되었습니다.");
//				
//				
//				
//			}
//			
//			
//			break;
		    isNumber=false;
            String sno="";
            do {
               System.out.print("입금할 계좌번호>");
               sno=s.nextLine();
               isNumber=sno.matches("-?\\d+(\\.\\d+)?");//숫자인지 판별하는 정규식
               if(isNumber==false) 
                  System.out.println("계좌번호를 숫자로 입력하세요!");
            }while(isNumber==false);
            
            vo=dao.read(Integer.parseInt(sno));
            if(vo.getName()==null) {
               System.out.println("입금할 계좌가 존재하지 않습니다.");
            }else {
               System.out.println("계좌주명>" + vo.getName());
               System.out.println("현재잔액>" + df.format(vo.getBalance()));
               
               String price="";
               isNumber=false;
               do {
                  System.out.print("입금액>");
                  price=s.nextLine();
                  isNumber=price.matches("-?\\d+(\\.\\d+)?");
               }while(isNumber==false);
               
               //잔액에 입금액추가
               dao.trade(Integer.parseInt(sno), Integer.parseInt(price));
               
               //거래내역등록
               tvo=new TradeVO();
               tvo.setNo(Integer.parseInt(sno));
               tvo.setDate(sdf.format(new Date()));
               tvo.setType("입금");
               tvo.setAmount(Integer.parseInt(price));
               tdao.insert(tvo);
               
               System.out.println("입금이 성공했습니다.");
            }
            break;
			
		case "2":
			isNumber = false;
			sno = "";
			do {
				System.out.print("조회하실 계좌를 입력바랍니다. > ");
				sno =s.nextLine();
				System.out.print("\n");
				isNumber=sno.matches("-?\\d+(\\.\\d+)?");
				if(isNumber==false) 
					System.out.println("숫자로 입력 바랍니다.");
			}while(isNumber == false);
			
			
			vo =dao.read(Integer.parseInt(sno));
		
			if(vo.getName()==null) {
				System.out.println("해당 구좌가 없습니다.");
			}else {
				vo.print();
				System.out.println("---------------------------------------");
				ArrayList<TradeVO> tarray = tdao.list(Integer.parseInt(sno));
				for(TradeVO t:tarray) {
					t.print();
				}
			}
			
			
			break;
			
		case "4":
			isNumber=false;
            sno="";
            do {
               System.out.print("출금할 계좌번호>");
               sno=s.nextLine();
               isNumber=sno.matches("-?\\d+(\\.\\d+)?");//숫자인지 판별하는 정규식
               if(isNumber==false) 
                  System.out.println("계좌번호를 숫자로 입력하세요!");
            }while(isNumber==false);
            
            vo=dao.read(Integer.parseInt(sno));
            if(vo.getName()==null) {
               System.out.println("출금할 계좌가 존재하지 않습니다.");
            }else {
               System.out.println("계좌주명>" + vo.getName());
               System.out.println("현재잔액>" + df.format(vo.getBalance()));
               
               isNumber=false;
               String price="";
               do {
                  System.out.print("출금액>");
                  price=s.nextLine();
                  isNumber=price.matches("-?\\d+(\\.\\d+)?");
               }while(isNumber==false);
               
               dao.trade(Integer.parseInt(sno), Integer.parseInt(price) * -1);
               
               //거래내역 등록
               tvo=new TradeVO();
               tvo.setNo(Integer.parseInt(sno));
               tvo.setDate(sdf.format(new Date()));
               tvo.setType("출금");
               tvo.setAmount(Integer.parseInt(price));
               tdao.insert(tvo);
               
               System.out.println("출금이 성공했습니다.");
            }
            break;
			
		case "5":
			ArrayList<AccountVO> array = dao.list();
			for(AccountVO v:array) {
				
				v.print();
				
			}
			System.out.println("\n현재 등록된 계좌는 " + array.size()+"구좌 입니다.");
			
			
			break;
			
			default:
				System.out.println("매뉴를 재선택하여 주세요.");
				
		
		
		
			}//switch
		}//while
	}//excute
}//class