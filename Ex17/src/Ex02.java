

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {
	public static void execute() {
		Scanner s=new Scanner(System.in);
		boolean run=true;
		FacilityDAO fdao=new FacilityDAO();
		CampDAO cdao = new CampDAO();
		
		while(run) {
			System.out.println("\n************************ �� �� �� �� �� ************************");
			System.out.println("-------------------------------------------------------------");
			System.out.println("1.��� | 2.��� | 3.���� | 4.���(ķ����) | 5.����(ķ����) | 0.����");
			System.out.println("-------------------------------------------------------------");
			System.out.print("����>");
			int menu=s.nextInt();s.nextLine();
			switch(menu) {
			case 0:
				run=false;
				System.out.println("���θ޴��� ���ư��ϴ�.");
				break;
			case 1://���
				String newCode=fdao.getNewCode();
				System.out.println("�ü����ڵ�>" +  newCode);
				System.out.print("�ü����̸�>");
				String fname=s.nextLine();
				if(fname.equals("")) {
					System.out.println("����� ����մϴ�.");
					break;
				}
				//���ο� �ü��� ���
				fdao.insert(newCode, fname);
				System.out.println("���ο� �ü����� ��ϵǾ����ϴ�.");
				break;
			case 2://���
				ArrayList<FacilityVO> farray=fdao.list();
				for(FacilityVO f:farray) {
					System.out.printf("%s\t%s\n",f.getFcode(),f.getFname());
				}
				break;
			case 3:
				System.out.println("�����ҽü����ڵ� > ");
				String fcode = s.nextLine();
				if(fcode.equals("")) {
					System.out.println("������ ����մϴ�.");
					break;
				}
				FacilityVO vo = fdao.read(fcode);
				if(vo.getFname()==null) {
					System.out.println("�ش� �ü����� �������� �ʽ��ϴ�.");
					break;
				}
				System.out.println("�����Ͻ� " + vo.getFname()+ "��(��) �����Ͻðڽ��ϱ�? (Y/N)");
				String sel=s.nextLine();
				if(sel.equals("��")||sel.equals("Y")||sel.equals("y")) {
					boolean success=fdao.delete(fcode);
					if(success==true) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					}else {
						System.out.println("�� �ü����� ������� ķ������ �ֽ��ϴ�.");
					}
					
				}else {
				System.out.println("������ ����մϴ�.");
				}
				
				
				break;
			case 4:

				System.out.print("ķ���� �ڵ� > ");
				String code = s.nextLine();
				if(code.equals("")) {
					System.out.println("�ü��� ����� ����մϴ�.");
					break;
				}
				
				CampVO cvo = cdao.read(code);
				if(cvo.getCname()==null) {
					System.out.println("��ϵ� ķ������ �����ϴ�.");
					break;
				}
				//ķ��������
				System.out.printf("ķ���� �̸� : %s(%s)\t�ּ� : %s \n", cvo.getCname(),cvo.getCode(),cvo.getAddress());
				//ķ���� �ü����
				farray = fdao.list(code);
				System.out.printf("\n------���� ��ϵ� �ü���--------------------------\n");
				for(FacilityVO f:farray) {
					System.out.printf("%s(%s) \t",f.getFname(),f.getFcode());
				}
				System.out.printf("\n\n------��� ������ ���--------------------------\n");
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
				System.out.println("��� �Ͻ� �ü��� �ڵ� > ");
				fcode=s.nextLine();
				if(fcode.equals("")) {
					System.out.println(" �ü��� ����� ��� �մϴ�."); break;
				}
				FacilityVO fvo= fdao.read(fcode);
				if(fvo.getFname()==null) {
					System.out.println(" �ü����� ã�� �� �����ϴ�."); break;
				}
				fvo=fdao.read(code, fcode);
				if(fvo.getFname()==null) {
					fvo= new FacilityVO();
					fvo.setCode(code);
					fvo.setFcode(fcode);
					fdao.insert(fvo);	
					System.out.printf("%s(%s)�� ��ϵǾ����ϴ�.",fvo,fcode);
				}else {
					System.out.println(" ["+fvo.getFname() + "] �� �̹� ��ϵ� �ü����Դϴ�.");
				}
						

				break;
			case 5:
				break;
			default:
				System.out.println("0~5�� �޴��� �����ϼ���.");
			}
		}
	}
}

























































































