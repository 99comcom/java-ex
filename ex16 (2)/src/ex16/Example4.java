package ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Example4 {
	public static void execute() {
		Scanner s=new Scanner(System.in);
		boolean run=true;
		
		StudentDAO sdao=new StudentDAO();
		ScoreDAO dao=new ScoreDAO();
		TypeDAO tdao=new TypeDAO();
			
		System.out.println("\n**************** �� ��  �� �� **************");
		while(run) {
			System.out.println("\n============================================");
			System.out.println("1.������ȸ | 2.�����Է� | 3.�������� | 0.����");
			System.out.println("============================================");
			int menu=Main.input("����");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("���θ޴��� ���ư��ϴ�.");
				break;
			case 1:
				System.out.print("��ȸ�� �й�>");
				String sno=s.nextLine();
				if(sno.equals("")) {
					System.out.println("��ȸ�� ����մϴ�.");//1
					break;
				}
				StudentVO svo=sdao.read(sno);
				if(svo.getSname()==null) {
					System.out.println("�ش��л��� �������� �ʽ��ϴ�.");//2
					break;
				}
				System.out.printf("%s(%s)\n",svo.getSname(),svo.getDname());//3
				ArrayList<ScoreVO> array=dao.list(sno);
				for(ScoreVO v:array) {
					System.out.printf("%s(%s)\t%s\t%d\n",
						v.getTname(),v.getTcode(),v.getTdate(),v.getGrade());
				}
				break;
			case 2://�������
				System.out.print("����� �й�>");
				sno=s.nextLine();
				if(sno.equals("")) {
					System.out.println("��������� ����մϴ�.");
					break;
				}
				svo=sdao.read(sno);
				if(svo.getSname()==null) {
					System.out.println("�ش��л��� �������� �ʽ��ϴ�.");//2
					break;
				}
				
				//�л��������
				System.out.printf("%s(%s)\n",svo.getSname(),svo.getDname());//3
				array=dao.list(sno);
				for(ScoreVO v:array) {
					System.out.printf("%s(%s)\t%s\t%d\n",
						v.getTname(),v.getTcode(),v.getTdate(),v.getGrade());
				}
				System.out.println("");
				//�����Է�
				ArrayList<TypeVO> tarray=tdao.list();
				for(TypeVO v:tarray) {
					System.out.printf("%s:%s|",v.getTcode(),v.getTname());
				}
				System.out.println("");
				
				String tcode="";
				int count=0;
				do {
					System.out.print("��������>");
					tcode=s.nextLine();
					if(tcode.equals("")) break;
					
					count=dao.read(sno, tcode);
					if(count==1) break;
					
					TypeVO tvo=tdao.read(tcode);
					if(tvo.getTname()!=null) break;
				}while(true);
				
				if(tcode.equals("")) {
					System.out.println("��������� ����մϴ�."); //1
					break;
				}
				
				if(count==1) {
					System.out.println("�̹� ��ϵ� �����Դϴ�.");//2
					break;
				}
				
				//�������
				int grade=Main.input("����");
				ScoreVO vo=new ScoreVO();
				vo.setSno(sno);
				vo.setTcode(tcode);
				vo.setGrade(grade);
				//System.out.println(vo.toString()); //3
				dao.insert(vo);
				System.out.println("������ ��ϵǾ����ϴ�.");
				break;
			case 3://����
				System.out.print("�������й�>");
				sno=s.nextLine();
				svo=sdao.read(sno);
				if(svo.getSname()==null) {
					System.out.println("�ش��л��� �������� �ʽ��ϴ�.");//2
					break;
				}
				//�л��������
				System.out.printf("%s(%s)\n",svo.getSname(),svo.getDname());//3
				array=dao.list(sno);
				for(ScoreVO v:array) {
					System.out.printf("%s(%s)\t%s\t%d\n",
						v.getTname(),v.getTcode(),v.getTdate(),v.getGrade());
				}
				System.out.println("");
				
				count=0;
				do {
					System.out.print("��������>");
					tcode=s.nextLine();
					
					if(tcode.equals("")) break;
					
					count=dao.read(sno, tcode);
					if(count==0) System.out.println("������ �����Ͱ� �����ϴ�.");//1
					else break;
				}while(true);
				
				if(tcode.equals("")) {
					System.out.println("������ ����մϴ�.");//2
					break;
				}
				
				//����
				System.out.print("�����ϽǷ���?"); //3
				String sel=s.nextLine();
				if(sel.equals("Y") || sel.equals("y") || sel.equals("��")){
					dao.delete(sno, tcode);
					System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
				}else {
					System.out.println("������ ��ҵǾ����ϴ�.");
				}
				break;
			default:
				System.out.println("0~3 �޴��� �����ϼ���.");
			}
		}
	}
}
