package ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Example3 {
	public static void execute() {
		Scanner s=new Scanner(System.in);
		boolean run=true;
		StudentDAO dao=new StudentDAO();
		StudentVO vo=null;
		String sno="";
		
		DeptDAO ddao=new DeptDAO();
		
		System.out.println("\n************************ �� ��  �� �� ********************");
		while(run) {
			System.out.println("\n===========================================================");
			System.out.println("1.�л���� | 2.�л���� | 3.�л����� | 4.�л����� | 5.�л���ȸ | 0.����");
			System.out.println("===========================================================");
			int menu=Main.input("����");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("���θ޴��� ���ư��ϴ�.");
				break;
			case 1://�л����
				String maxNo=dao.maxNo();
				int newNo=Integer.parseInt(maxNo) + 100;
				System.out.println("�й�>" + newNo);
				

				System.out.print("�̸�>");
				String sname=s.nextLine();
				if(sname.equals("")) {
					System.out.println("�л������ ����մϴ�.");
					break;
				}
				
				//�а����
				ArrayList<DeptVO> darray=ddao.list();
				for(DeptVO v:darray) {
					System.out.printf("%s:%s|",v.getDcode(),v.getDname());
				}
				System.out.println("");
				
				//�а��Է�
				boolean isFind=false;
				String dcode="";
				do {
					System.out.print("�а��ڵ�>");
					dcode=s.nextLine();
					if(dcode.equals("")) break;
					DeptVO v=ddao.read(dcode);
					if(v.getDname()!=null) isFind=true;
					if(isFind==false) System.out.println("�ش�Ǵ� �а��� �����ϴ�.");
				}while(isFind==false);
				
				if(dcode.equals("")) {
					System.out.println("�л������ ����մϴ�.");
					break;
				}
				//����
				vo=new StudentVO();
				vo.setSno(String.valueOf(newNo));
				vo.setSname(sname);
				vo.setDcode(dcode);
				dao.insert(vo);
				System.out.println("���ο� �л��� ��ϵǾ����ϴ�.");
				break;
			case 2:	//�л����
				ArrayList<StudentVO> array=dao.list();
				for(StudentVO v:array) {
					System.out.printf("%s\t%s\t%s(%s)\n",
					v.getSno(),v.getSname(),v.getDcode(),v.getDname());
				}
				break;
			case 3://�л�����
				System.out.print("������ �й�>");
				sno=s.nextLine();
				if(sno.equals("")) {
					System.out.println("������ ����մϴ�.");
					break;
				}
				vo=dao.read(sno);
				if(vo.getSname()==null) {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
					break;
				}
				System.out.print("�̸�:" + vo.getSname() + ">");
				sname=s.nextLine();
				if(!sname.equals("")) vo.setSname(sname);
				
				//�а����
				System.out.println("");
				darray=ddao.list();
				for(DeptVO v:darray) {
					System.out.printf("%s:%s|",v.getDcode(),v.getDname());
				}
				System.out.println("");
				
				isFind=false;
				do {
					System.out.printf("�а�:%s(%s)>",vo.getDcode(),vo.getDname());
					dcode=s.nextLine();
					if(dcode.equals("")) break;
					DeptVO dvo=ddao.read(dcode);
					if(dvo.getDname()!=null) isFind=true;
					if(isFind==false) System.out.println("�ش��а��� �����ϴ�.");
				}while(isFind==false);
				
				if(!dcode.equals("")) vo.setDcode(dcode);
				//System.out.println(vo.toString());
				dao.update(vo);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				break;
			case 4://�л�����
				System.out.print("������ �й�>");
				sno=s.nextLine();
				if(sno.equals("")) {
					System.out.println("������ ����մϴ�.");
					break;
				}
				vo=dao.read(sno);
				if(vo.getSname()==null) {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
					break;
				}
				System.out.printf("%s(%s)\n",vo.getSname(),vo.getDname());
				System.out.print("�����ϽǷ���?");
				String sel=s.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
					//����
					boolean success=dao.delete(sno);
					if(success) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					}else {
						System.out.println("���� �����Ͱ� �����ؼ� �����Ҽ������ϴ�.");
					}
				}
				break;
			case 5://�л���ȸ
				System.out.print("��ȸ�� �й�>");
				sno=s.nextLine();
				vo=dao.read(sno);
				if(vo.getSname()==null) {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
					break;
				}
				System.out.println("�л��̸�>" + vo.getSname());
				System.out.printf("�л��а�>%s(%s)\n",vo.getDcode(),vo.getDname());
				break;
			default:
				System.out.println("0~5�� �޴��� �����ϼ���.");
			}
		}
	}
}
