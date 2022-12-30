import java.util.*;

import javax.sound.sampled.BooleanControl.Type;

public class Ex03 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		boolean run = true;
		CampDAO cdao = new CampDAO();
		CampVO vo = null;
		TypeDAO tdao = new TypeDAO();
		String[] type = {"���","����ķ����","ī���","�۷���","���"};
		
		
		while(run) {
			System.out.println("��������������������������������������������������������������������������������������");
			System.out.println("��1.�ü���������� | 2. �ü���������� | 0.�����޴� �� ");
			System.out.println("��������������������������������������������������������������������������������������");
			int menu=Main.input("�޴����� ");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("���� �޴��� ���ư��ϴ�.");
				break;
			case 1:
				int code = Main.input("ķ�����ȣ ���� ");
				vo=cdao.read(code);
				if(vo.getName()==null) {
					System.out.println("�ش� ķ������ �������� �ʽ��ϴ�.");
					break;
				}
				System.out.println("ķ�����̸�:" + vo.getName());
				System.out.println("------------------------------------------------------");

				ArrayList<String> check = new ArrayList<>();
				ArrayList<String> tarray = tdao.list(code);
				for(int i=0;i<type.length;i++) {
					boolean isFind=false;
					for(String t:tarray) {
						if(t.equals(type[i])) isFind = true;
					}
					if(isFind) check.add("O");
						else check.add("X");
					
					System.out.printf("[%d] %s(%s)\n",i,type[i],check.get(i));
					
				}
				
				int sel=Main.input("������ȣ");
				if(sel==0) break;
				if(check.get(sel).equals("0")) {
					System.out.println(type[sel]+"������ �̹� ��ϵǾ��ֽ��ϴ�.");
					break;
				}
				tdao.insert(code, type[sel]);
				System.out.println(type[sel] + "������ ��ϵǾ����ϴ�.");
						
				
				break;
			case 2:
				code = Main.input("ķ�����ȣ ���� ");
				vo=cdao.read(code);
				if(vo.getName()==null) {
					System.out.println("�ش� ķ������ �������� �ʽ��ϴ�.");
					break;
				}
				System.out.println("ķ�����̸�:" + vo.getName());
				System.out.println("------------------------------------------------------");

				check = new ArrayList<>();
				 tarray = tdao.list(code);
				for(int i=0;i<type.length;i++) {
					boolean isFind=false;
					for(String t:tarray) {
						if(t.equals(type[i])) isFind = true;
					}
					if(isFind) check.add("O");
						else check.add("X");
					
					System.out.printf("[%d] %s(%s)\n",i,type[i],check.get(i));
					
				}
				sel=Main.input("������ȣ");
				if(sel==0) break;
				if(check.get(sel).equals("X")) {
					System.out.println(type[sel]+"������ ��ϵǾ� ���� �ʾ� ������ �Ұ����մϴ�. �� ���ùٶ��ϴ�.");
					break;
				}
				tdao.delete(code, type[sel]);
				System.out.println(type[sel] + "������ �����Ǿ����ϴ�.");
				break;
				
				default:
					System.out.println("0~2�� �޴��� �����ϼ���.");
				
				
			}
	}
}
}