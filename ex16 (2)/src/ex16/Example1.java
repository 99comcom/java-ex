package ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Example1 {
	public static void execute() {
		Scanner s=new Scanner(System.in);
		boolean run=true;
		DeptDAO dao=new DeptDAO();
		DeptVO vo=null;
		String dcode="", dname="";
		
		System.out.println("\n************************ �� �� �� �� �� �� ********************");
		while(run) {
			System.out.println("\n===========================================================");
			System.out.println("1.�ڵ��� | 2.�ڵ��� | 3.�ڵ���� | 4.�ڵ���� | 5.�ڵ���ȸ | 0.����");
			System.out.println("===========================================================");
			int menu=Main.input("����");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("���θ޴��� ���ư��ϴ�.");
				break;
			case 1://�ڵ���
				String maxCode=dao.getMaxCode();
				int code=Integer.parseInt(maxCode.substring(1)) + 10;
				String newCode ="D" + code;
				System.out.println("�а��ڵ�>" + newCode);
				System.out.print("�а��̸�>");
				dname=s.nextLine();
				
				System.out.print("����ϽǷ���?");
				String sel=s.nextLine();
				if(sel.equals("Y")|| sel.equals("y") || sel.equals("��")) {
					vo=new DeptVO();
					vo.setDcode(newCode);
					vo.setDname(dname);
					dao.insert(vo);
					System.out.println("���ο� �а��� ��ϵǾ����ϴ�.");
				}
				break;
			case 2://�ڵ���
				ArrayList<DeptVO> array=dao.list();
				for(DeptVO v:array) {
					System.out.printf("%s\t%s\n", v.getDcode(),
									v.getDname());
				}
				break;
			case 3://����
				System.out.print("������ �а��ڵ�>");
				dcode=s.nextLine();
				vo=dao.read(dcode);
				if(vo.getDname()==null) {
					System.out.println("�ش��а��� �������� �ʽ��ϴ�.");
				}else {
					System.out.print("�а���:" + vo.getDname()+">");
					dname=s.nextLine();
					if(dname.equals("")) {
						System.out.println("������ ��ҵǾ����ϴ�.");
					}else {
						System.out.print("�����ϽǷ���?");
						sel=s.nextLine();
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							vo=new DeptVO();
							vo.setDcode(dcode);
							vo.setDname(dname);
							dao.update(vo);
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						}else {
							System.out.println("������ ��ҵǾ����ϴ�.");
						}
					}
				}
				break;
			case 4://����
				System.out.print("�а��ڵ�>");
				dcode=s.nextLine();
				vo=dao.read(dcode);
				if(vo.getDname() == null) {
					System.out.println("�ش��а��� �������� �ʽ��ϴ�.");
				}else {//�ش��а��� �����ϴ� ���
					System.out.println("�а��̸�>" + vo.getDname());
					System.out.print("������ �����ϽǷ���?");
					sel=s.nextLine();
					if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
						boolean success=dao.delete(dcode);
						if(success==true) {
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						}else {
							System.out.println("���а��� �л��� �־ ������ �� �����ϴ�.");
						}
					}else {
						System.out.println("������ ��ҵǾ����ϴ�.");
					}
				}
				break;
			case 5://��ȸ
				System.out.print("�а��ڵ�>");
				dcode=s.nextLine();
				vo=dao.read(dcode);
				if(vo.getDname()==null) {
					System.out.println("�ش��а��� �������� �ʽ��ϴ�.");
				}else {
					System.out.println("�а��̸�>" + vo.getDname());
				}
				break;
			default:
				System.out.println("0~5�� �޴��� �����ϼ���.");
			}
		}
	}
}
