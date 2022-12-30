package ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner s=new Scanner(System.in);
		boolean run=true;
		TypeDAO dao=new TypeDAO();
		TypeVO vo=null;
		String tcode="";
		String tname="";
		
		System.out.println("\n************************ Ÿ �� �� �� �� �� ********************");
		while(run) {
			System.out.println("\n===========================================================");
			System.out.println("1.Ÿ�Ե�� | 2.Ÿ�Ը�� | 3.Ÿ�Լ��� | 4.Ÿ�Ի��� | 5.Ÿ����ȸ | 0.����");
			System.out.println("===========================================================");
			int menu=Main.input("����");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("���θ޴��� ���ư��ϴ�.");
				break;
			case 1://Ÿ�Ե��
				String maxCode=dao.getMaxCode();
				int code=Integer.parseInt(maxCode.substring(1)) + 10;
				String newCode="T" + code;
				System.out.println("Ÿ���ڵ�>" + newCode);
				System.out.print("Ÿ���̸�>");
				tname=s.nextLine();
				if(tname.equals("")) {
					System.out.println("����� ����մϴ�.");
					break;
				}
				//Ÿ�Ե��
				vo=new TypeVO();
				vo.setTcode(newCode);
				vo.setTname(tname);
				dao.insert(vo);
				System.out.println("���ο� Ÿ���� ��ϵǾ����ϴ�.");
				break;
			case 2://Ÿ�Ը��
				ArrayList<TypeVO> array=dao.list();
				for(TypeVO v:array) {
					System.out.printf("%s\t%s\t\t%s\n",v.getTcode(),
							v.getTname(), v.getTdate());
				}
				break;
			case 3://Ÿ�Լ���
				System.out.print("������ Ÿ���ڵ�>");
				tcode=s.nextLine();
				vo=dao.read(tcode); //������
				if(vo.getTname()==null) {
					System.out.println("�ش� �ڵ尡 �������� �ʽ��ϴ�."); //1
					break;
				}
				System.out.print("Ÿ���̸�:" + vo.getTname() + ">");
				tname=s.nextLine();
				if(!tname.equals("")) vo.setTname(tname);//�̸��� �����Ѱ��
				
				System.out.print("������:" + vo.getTdate() + ">");
				String tdate=s.nextLine();
				if(!tdate.equals("")) vo.setTdate(tdate);//��¥�� ������ ���
				
				//����
				dao.update(vo);
				System.out.println("������ �Ϸ�Ǿ����ϴ�."); //3
				break;
			case 4://Ÿ�Ի���
				System.out.print("������ Ÿ���ڵ�>");
				tcode=s.nextLine();
				vo=dao.read(tcode);
				if(vo.getTname()==null) {
					System.out.println("�ش� �ڵ尡 �������� �ʽ��ϴ�."); //1
					break;
				}
				System.out.println("Ÿ���̸�>" + vo.getTname());
				System.out.print("�����ϽǷ���?");
				String sel=s.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
					boolean success=dao.delete(tcode);
					if(success==true) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�."); //2
					}else {
						System.out.println("�������̺��� ������̿��� ������ �� �����ϴ�.");//3
					}
				}else {
					System.out.println("������ ��ҵǾ����ϴ�.");//4
				}
				break;
			case 5://��ȸ
				System.out.print("Ÿ���ڵ�>");
				tcode=s.nextLine();
				vo=dao.read(tcode);
				if(vo.getTname()==null) {
					System.out.println("�ش� �ڵ尡 �������� �ʽ��ϴ�.");
					break;
				}
				System.out.println("Ÿ���̸�>" + vo.getTname());
				System.out.println("������>" + vo.getTdate());
				
				
				
				
				
				
				break;
			default:
				System.out.println("0~5�� �޴��� �����ϼ���.");
				
				
				
				
			}
		}
	}
}
