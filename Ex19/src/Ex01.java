import java.util.*;


public class Ex01 {
	public static void execute() {
		Scanner s =new Scanner(System.in);
		boolean run = true;
		AccountVO vo= null;
		AccountDAO dao = new AccountDAO();
		
		
		
		
		while(run) {
			System.out.println("��������������������������������������������");
			System.out.println("�� 11  1.���µ��        \n��   2.���¸��\n��   3.������ȸ\n��   4.�Ա�\n��   5.���\n��   0.����");
			System.out.println("��������������������������������������������");
			System.out.print("�޴� ���� > ");
			int menu=s.nextInt();s.nextLine();
			switch(menu) {
			case 0:
				run = false;
				System.out.println("���α׷��� �����մϴ�.");
				break;
			case 1:
				break;
				
			case 2:
				ArrayList<AccountVO> array = dao.list();
				for(AccountVO a:array) {
					System.out.printf("�����ָ� : %s \t�ܾ� : %d \t���»����� : %s",a.getAname(),a.getBalance(),a.getOdate());
					
					
				}
				
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
				default:
					System.out.println("�޴��� �缱�� �ٶ��ϴ�.");
					
				
			
			
		}
		
	}
	}
}
