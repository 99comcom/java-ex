import java.text.*;
import java.util.*;



public class Ex01 {
	public static void execute() {
		Scanner s =new Scanner(System.in);
		boolean run = true;
		DecimalFormat df = new DecimalFormat("#,###��"); 

		AccountVO vo= null;
		AccountDAO dao = new AccountDAO();
		String ano = "";
		StatementDAO sdao= new StatementDAO();
		StatementVO svo = null;
		
		
		
		
		while(run) {
			System.out.println("��������������������������������������������");
			System.out.println("��   1.���µ��        \n��   2.���¸��\n��   3.������ȸ\n��   4.�Ա�\n��   5.���\n��   0.����");
			System.out.println("��������������������������������������������");
			System.out.print("�޴� ���� > ");
			int menu=s.nextInt();s.nextLine();
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� �����մϴ�.");
				break;
			case 1:
				String mno = dao.newMaxNo();
				int newNo=Integer.parseInt(mno) + 100; 
				System.out.println("���¹�ȣ : " + newNo);
				String aano = Integer.toString(newNo);
				System.out.print("������ : ");
				String accname = s.nextLine();
				System.out.print("�Աݾ� : ");
				int balance = s.nextInt(); s.nextLine();
				System.out.println("123");
				
				vo=new AccountVO();
				vo.setAno(aano);
				vo.setAname(accname);
				vo.setBalance(balance);
				dao.insert(vo);
				System.out.println(vo.getAname() +"���� ��ϵǼ̽��ϴ�.");
				
				
				break;
				
			case 2:
				
				ArrayList<AccountVO> array = dao.list();

				for(AccountVO a:array) {
					String b = df.format(a.getBalance());
					System.out.printf(" %s\t %s \t�ܾ�:%s \t���»�����:%s\n",a.getAno(),a.getAname(),b,a.getOdate());
	
					
					
				}
			
				
				break;
			case 3:
				System.out.print("��ȸ�Ͻ� ���¹�ȣ�� �����ּ��� > ");
				ano=s.nextLine();
				vo=dao.read(ano);
				svo=sdao.read(ano);

				if(vo.getAname()==null) {
					System.out.println("��ϵ��� ���� �����Դϴ�.");
				}else {
					String b = df.format(vo.getBalance());
					System.out.printf("  %s\t%s\t\t%s\n",vo.getAname(),b,vo.getOdate());

					
					System.out.println("---����� ����------------------------------");
					ArrayList<StatementVO> sarray = sdao.list(ano);
					
					for(StatementVO ss:sarray) {
						
						
						String bb = df.format(ss.getAmount());
						System.out.printf(" %s\t %s \t:%s \t%s\n",ss.getAno(),ss.getTtype(),ss.getSdate(),bb);
					
						}
				}

					
				
				break;
			case 4:
				System.out.print("�Ա��� ���¹�ȣ�� �����ּ��� > ");
				ano=s.nextLine();
				vo=dao.read(ano);
				if(vo.getAname()==null) {
					System.out.println("��ϵ��� ���� �����Դϴ�.");
				}else {
					String b = df.format(vo.getBalance());
					System.out.printf(" �����ָ�:%s\n �ܾ�:%s\n",vo.getAname(),b);
					
				}
				System.out.println("�Ա� �Ͻ� �ݾ� > ");
				int amount = s.nextInt(); s.nextLine();
				System.out.print("�Ա��Ͻðڽ��ϱ�? (Y/N)");
				String sel=s.nextLine();
				if(sel.equals("Y")|| sel.equals("y") || sel.equals("��")) {
					svo=new StatementVO();
					svo.setAno(ano);
					svo.setSdate("");
					svo.setTtype("�Ա�");
					svo.setAmount(amount);
					sdao.insert(svo);
					System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");
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
				System.out.print("�Ա��� ���¹�ȣ�� �����ּ��� > ");
				ano=s.nextLine();
				vo=dao.read(ano);
				
				if(vo.getAname()==null) {
					System.out.println("��ϵ��� ���� �����Դϴ�.");
				}else {
					String b = df.format(vo.getBalance());
					System.out.printf(" �����ָ�:%s\n �ܾ�:%s\n",vo.getAname(),b);
					
				}
				System.out.println("��� �Ͻ� �ݾ� > ");
				amount = s.nextInt(); s.nextLine();
				System.out.print("����Ͻðڽ��ϱ�? (Y/N)");
				sel=s.nextLine();
				if(sel.equals("Y")|| sel.equals("y") || sel.equals("��")) {
					if(vo.getBalance()<amount) {
						 System.out.println("�ܾ��� �����մϴ�.");
					}else {
					
					svo=new StatementVO();
					svo.setAno(ano);
					svo.setSdate("");
					svo.setTtype("���");
					svo.setAmount(amount);
					sdao.insert(svo);
					System.out.println("����� �Ϸ�Ǿ����ϴ�.");

					
					//�ܾ� ����
					sum = vo.getBalance() - amount ;
					vo.setAno(ano);
					vo.setBalance(sum);
					dao.update(vo);

//					
					}
				}
		
				
				
				
				
				
				break;
				default:
					System.out.println("�޴��� �缱�� �ٶ��ϴ�.");
					
				
			
			
		}
		
	}
	}
}

