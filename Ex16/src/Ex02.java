import java.util.*;

public class Ex02 {
public static void execute() {
		
		Scanner s=new Scanner(System.in);
		boolean run=true;
		String tcode = "";
		String tname = "";
		String sel = "";

		TypeVO vo = null;
		TypeDAO dao = new TypeDAO();
		
		
		System.out.println("\n**************************** Ÿ �� �� �� �� �� **************************** ");
		while(run) {
			System.out.println("\n������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("   1.Ÿ�Ե�� | 2.Ÿ�Ը�� | 3.Ÿ�Լ��� | 4.Ÿ�Ի��� |5. Ÿ����ȸ | 0.����");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
			int menu=Main.input("����");
			switch(menu) {
			case 0:
				System.out.println("������������ �̵��մϴ�.");
				run=false;
				break;
				 
			case 1://�ڵ���
				String maxCode = dao.gatMaxCode();
				int code =Integer.parseInt(maxCode.substring(1)) + 10 ;
				String newCode="T" + code;
				System.out.println("Ÿ���ڵ�>" + newCode);
				System.out.println("Ÿ�� �̸� > ");
				tname = s.nextLine();

				
				if(tname.equals("")) {
					System.out.println("����� ����մϴ�.");
				break;
				}
				vo=new TypeVO();
				vo.setTcode(newCode);
				vo.setTname(tname);

				dao.insert(vo);
				System.out.println(vo.getTname() + "����� �Ϸ� �Ǿ����ϴ�.");
				
				break;
			case 2:
				ArrayList<TypeVO> array = dao.list();
				for(TypeVO v:array) {
					System.out.printf("%s\t%s\n" ,v.getTcode(),v.getTname());
				}
				
				break;
			case 3:
				System.out.println("������ Ÿ�� �ڵ� > ");
				tcode = s.nextLine();
				vo = dao.read(tcode);
				if(vo.getTname()==null) {
					System.out.println(tcode + "�� �������� �ʽ��ϴ�.");
					break;
				}
				System.out.println("Ÿ�� �̸� : " + vo.getTname() + ">");
				tname = s.nextLine();
//				System.out.println("\nŸ�� �ð� : " + vo.getTdate() + ">");
//				tdate = s.nextLine();
				if(tname.equals("")) {
					System.out.println("������ ��ҵǾ����ϴ�.");
					break;
				}
				vo=new TypeVO();
				vo.setTcode(tcode);
				vo.setTname(tname);


				dao.update(vo);
				System.out.println(vo.getTname() + "���� ������ �Ϸ�Ǿ����ϴ�.");
				break;
			case 4:
				System.out.println("�����Ͻ� Ÿ�� �ڵ� > ");
				tcode = s.nextLine();
				vo=dao.read(tcode);
				if(vo.getTname()==null) {
					System.out.println("�ش� Ÿ���� �������� �ʽ��ϴ�.");
					
				}

				System.out.println("Ÿ�� �̸� > " + vo.getTname());
				System.out.println(vo.getTname() + "��(��) �����ϰڽ��ϱ�? (Y,N) > ");
				sel=s.nextLine();
				if(sel.equals("Y")||sel.endsWith("y")) {

					boolean success = dao.delete(tcode);
					if (success==true) {
						System.out.println("���� �Ǿ����ϴ�.");
					}else { 
						System.out.println("�������̺��� ������̿��� ������ �� �����ϴ�.");
					}
					}else {
						System.out.println("������ ��ҵǾ����ϴ�.");
				}
				
				break;
			case 5:
				System.out.println("Ÿ���ڵ� > ");
				tcode = s.nextLine();
				vo = dao.read(tcode);
				
				if(vo.getTname()==null) {
					System.out.println("�ش� �ڵ尡 �������� �ʽ��ϴ�.");
				}else {
					System.out.println("�а� �̸� :" +vo.getTname());
				}
				break;
				
				default:
				System.out.println("���θ޴��� ���ư��ϴ�. �Ŵ��� �缱�� �ٶ��ϴ�.");
				
				
			}
		}
}

}
