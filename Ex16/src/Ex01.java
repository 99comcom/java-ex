import java.util.*;



public class Ex01 {

	public static void execute() {
		
		Scanner s=new Scanner(System.in);
		boolean run=true;
		DeptDAO dao = new DeptDAO();
		DeptVO vo = null;
		String dcode = "";
		
		System.out.println("\n****************** �� �� �� �� �� �� **************");
		while(run) {
			System.out.println("\n������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("   1.�ڵ��� | 2.�ڵ��� | 3.�ڵ���� | 4.�а����� |5. �а���ȸ | 0.����");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������");
			int menu=Main.input("����");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("������������ �̵��մϴ�.");
				
				 break;
			case 1://�ڵ���
				String maxCode=dao.getMaxCode();
				int code =Integer.parseInt(maxCode.substring(1)) + 10 ;
				String newCode = "D" + code;
				System.out.println("�а� �ڵ� > "+ newCode);
				System.out.print("�а� �̸� > ");
				String dname =s.nextLine();
				
				System.out.println("����ϰڽ��ϱ�? (Y,N) > ");
				String sel = s.nextLine();
				if(sel.equals("y")||sel.equals("Y")) {
				
				vo=new DeptVO();
				vo.setDcode(newCode);
				vo.setDname(dname);
				dao.insert(vo);
				System.out.println("���ο� <" + vo.getDname()+  "> �а��� ����� �Ϸ�Ǿ����ϴ�.");
				}else {
					System.out.println("����� ��ҵǾ����ϴ�.");
				}
				break;
				
			case 2:
				ArrayList<DeptVO> array  = dao.list();
				for(DeptVO v:array) {
					System.out.printf("%s\t%s\n" ,v.getDcode(),v.getDname());
					
					
				}
				break;
			case 3:
				System.out.println("������ �а� �ڵ�");
				dcode = s.nextLine();
				vo = dao.read(dcode);
				if(vo.getDname()==null) {
					System.out.println(dcode + "�а��� �������� �ʽ��ϴ�.");
					
				}else {
					System.out.print("���� �а���:" + vo.getDname() + "\t �����Ͻ� �а��� > ");
					dname=s.nextLine();
					if(dname.equals("")) {
						System.out.println("������ ��� �Ǿ����ϴ�.");
					}else {
						System.out.println("�����ϰڽ��ϱ�? (Y,N) > ");
						sel = s.nextLine();
						if(sel.equals("y")||sel.equals("Y")) {
							vo=new DeptVO();
							vo.setDcode(dcode);
							vo.setDname(dname);
							dao.update(vo);
							System.out.println(dname + "���� ������ �Ϸ�Ǿ����ϴ�.");
							
							
						}
			
					}
				}
				
				
				
				
				
				break;
				
			case 4:
				System.out.println("�����Ͻ� �а� �ڵ� > ");
				dcode = s.nextLine();
				vo = dao.read(dcode);
				if(vo.getDname()==null) {
					System.out.println("�ش� �а��� �������� �ʽ��ϴ�.");
				}else {
					System.out.println(vo.getDname() + "�а��� �����ϰڽ��ϱ�? (Y,N) > ");
					sel=s.nextLine();
					if(sel.equals("Y")||sel.endsWith("y")) {
						
						boolean success = dao.delete(dcode);
						if (success==true) {
							
						
							System.out.println("�����Ǿ����ϴ�.");
						
					}else {
						System.out.println("�ش� �а��� �л��� �����Ͽ� ������ �Ұ����մϴ�.");
					}
						
					}else {
					System.out.println("������ ��ҵǾ����ϴ�.");
					}
					
				}
				break;
				
			case 5:
				System.out.println("�а��ڵ� > ");
				dcode = s.nextLine();
				vo=dao.read(dcode);
				if(vo.getDname()==null) {
					System.out.println("�ش� �а��� �������� �ʽ��ϴ�.");
				}else {
					System.out.println("�а� �̸� : " + vo.getDname());
				}
				break;
				

				default:
					System.out.println("�޴��� �缱�� �ٶ��ϴ�.");
				
		
			}
	
		}
	}
}