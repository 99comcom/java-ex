import java.text.*;
import java.util.*;



public class Ex01 {
	public static void execter () {
		Scanner s =new Scanner(System.in);
		boolean run = true;
		AccountDAOImpl dao = new AccountDAOImpl();
		AccountVO vo = null;
		DecimalFormat df =new DecimalFormat("#.###��");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		TradeDAO tdao = new TradeDAO();
		TradeVO tvo = null;
		
		
		
		while(run) {
		

		System.out.println("\n============================= �� �� �� ��========== ");
		System.out.println("1.���� | 2.��ȸ | 3.�Ա� | 4.���� | 5.��� | 0.���� |");
		System.out.println("================================================+");
		
		System.out.print("�޴��� �����Ͽ� �ּ��� > ");
		String mun = s.nextLine();
		System.out.print("\n");

		switch(mun) {
		case "0":
			System.out.println("�����մϴ�.");
			run=false;
			
			break;
		case "1":
			int newno = dao.getLastNo() + 100;
			System.out.println("���¹�ȣ : " + newno);
			
			vo= new AccountVO();
			vo.setNo(newno);
			System.out.println("�̸� > ");
			vo.setName(s.nextLine());
			
			boolean isNumber = false;
			String balnace = "";
			
			do {
				System.out.println("�Աݾ� > ");
				balnace = s.nextLine();

				isNumber=balnace.matches("-?\\d+(\\.\\d+)?");
				if(isNumber == false) System.out.println("���ڸ� �Է� �����մϴ�.");
			
				
			}while(isNumber==false);
				
			
//			vo.setBalance(s.nextInt());s.nextLine();
			vo.setBalance(Integer.parseInt(balnace));
			dao.insert(vo);
			System.out.println(vo.getName() + "��(��)����� �Ϸ�Ǿ����ϴ�.");
			
			//�ŷ��������
			tvo=new TradeVO();
			tvo.setNo(newno);
			tvo.setDate(sdf.format(new Date()));
			tvo.setType("�Ա�");
			tvo.setAmount(Integer.parseInt(balnace));
			tdao.insert(tvo);
			
			System.out.println("�Ա��� ����Ǿ����ϴ�.");
			
			break;
			
		case "3" :
//			isNumber = false;
//			String sno = "";
//			do {
//				System.out.print("�Ա��Ͻ� ���¸� �Է¹ٶ��ϴ�. > ");
//				sno =s.nextLine();
//				System.out.print("\n");
//				isNumber=sno.matches("-?\\d+(\\.\\d+)?");
//				if(isNumber==false) 
//					System.out.println("���ڷ� �Է� �ٶ��ϴ�.");
//			}while(isNumber == false);
//			
//			
//			vo = dao.read(Integer.parseInt(sno));
//		
//			if(vo.getName()==null) {
//				System.out.println("�ش� ���°� �����ϴ�.");
//			}else {
//				System.out.println("�����ָ� > " + vo.getNo());
//				System.out.println("�����ָ� > " + vo.getBalance());
//				
//				String price="";
//				isNumber=false;
//				
//				do {
//				System.out.println("�Աݾ� > ");
//				price=s.nextLine();
//				isNumber=sno.matches("-?\\d+(\\.\\d+)?");
//				if(isNumber==false) 
//					System.out.println("���ڷ� �Է� �ٶ��ϴ�.");
//			}while(isNumber == false);
//			
//				
//				//�ܾ׿� �Աݾ��߰�
//				dao.trade(Integer.parseInt(sno), Integer.parseInt(price));
//				//�ŷ��������
//				tvo=new TradeVO();
//				tvo.setNo(Integer.parseInt(sno));
//				tvo.setDate(sdf.format(new Date()));
//				tvo.setType("�Ա�");
//				tvo.setAmount(Integer.parseInt(price));
//				tdao.insert(tvo);
//				
//				System.out.println("�Ա��� ����Ǿ����ϴ�.");
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
               System.out.print("�Ա��� ���¹�ȣ>");
               sno=s.nextLine();
               isNumber=sno.matches("-?\\d+(\\.\\d+)?");//�������� �Ǻ��ϴ� ���Խ�
               if(isNumber==false) 
                  System.out.println("���¹�ȣ�� ���ڷ� �Է��ϼ���!");
            }while(isNumber==false);
            
            vo=dao.read(Integer.parseInt(sno));
            if(vo.getName()==null) {
               System.out.println("�Ա��� ���°� �������� �ʽ��ϴ�.");
            }else {
               System.out.println("�����ָ�>" + vo.getName());
               System.out.println("�����ܾ�>" + df.format(vo.getBalance()));
               
               String price="";
               isNumber=false;
               do {
                  System.out.print("�Աݾ�>");
                  price=s.nextLine();
                  isNumber=price.matches("-?\\d+(\\.\\d+)?");
               }while(isNumber==false);
               
               //�ܾ׿� �Աݾ��߰�
               dao.trade(Integer.parseInt(sno), Integer.parseInt(price));
               
               //�ŷ��������
               tvo=new TradeVO();
               tvo.setNo(Integer.parseInt(sno));
               tvo.setDate(sdf.format(new Date()));
               tvo.setType("�Ա�");
               tvo.setAmount(Integer.parseInt(price));
               tdao.insert(tvo);
               
               System.out.println("�Ա��� �����߽��ϴ�.");
            }
            break;
			
		case "2":
			isNumber = false;
			sno = "";
			do {
				System.out.print("��ȸ�Ͻ� ���¸� �Է¹ٶ��ϴ�. > ");
				sno =s.nextLine();
				System.out.print("\n");
				isNumber=sno.matches("-?\\d+(\\.\\d+)?");
				if(isNumber==false) 
					System.out.println("���ڷ� �Է� �ٶ��ϴ�.");
			}while(isNumber == false);
			
			
			vo =dao.read(Integer.parseInt(sno));
		
			if(vo.getName()==null) {
				System.out.println("�ش� ���°� �����ϴ�.");
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
               System.out.print("����� ���¹�ȣ>");
               sno=s.nextLine();
               isNumber=sno.matches("-?\\d+(\\.\\d+)?");//�������� �Ǻ��ϴ� ���Խ�
               if(isNumber==false) 
                  System.out.println("���¹�ȣ�� ���ڷ� �Է��ϼ���!");
            }while(isNumber==false);
            
            vo=dao.read(Integer.parseInt(sno));
            if(vo.getName()==null) {
               System.out.println("����� ���°� �������� �ʽ��ϴ�.");
            }else {
               System.out.println("�����ָ�>" + vo.getName());
               System.out.println("�����ܾ�>" + df.format(vo.getBalance()));
               
               isNumber=false;
               String price="";
               do {
                  System.out.print("��ݾ�>");
                  price=s.nextLine();
                  isNumber=price.matches("-?\\d+(\\.\\d+)?");
               }while(isNumber==false);
               
               dao.trade(Integer.parseInt(sno), Integer.parseInt(price) * -1);
               
               //�ŷ����� ���
               tvo=new TradeVO();
               tvo.setNo(Integer.parseInt(sno));
               tvo.setDate(sdf.format(new Date()));
               tvo.setType("���");
               tvo.setAmount(Integer.parseInt(price));
               tdao.insert(tvo);
               
               System.out.println("����� �����߽��ϴ�.");
            }
            break;
			
		case "5":
			ArrayList<AccountVO> array = dao.list();
			for(AccountVO v:array) {
				
				v.print();
				
			}
			System.out.println("\n���� ��ϵ� ���´� " + array.size()+"���� �Դϴ�.");
			
			
			break;
			
			default:
				System.out.println("�Ŵ��� �缱���Ͽ� �ּ���.");
				
		
		
		
			}//switch
		}//while
	}//excute
}//class