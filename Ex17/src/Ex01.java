import java.util.*;

public class Ex01 {
	public static void execute() {
		Scanner s =new Scanner(System.in);
		boolean run=true;
		CampVO vo= null;
		CampDAO dao = new CampDAO();
		FacilityVO fvo = null;
		FacilityDAO fdao = new FacilityDAO();
		TypeVO tvo = null;
		TypeDAO tdao = new TypeDAO();
		
		
		
		while(run) {
			System.out.println("��������������������������������������������");
			System.out.println("��   1.ķ������        \n��   2.ķ������\n��   3.ķ���� ��ȸ\n��   4.ķ���� �ü��� ���\n��   5.ķ���� �������\n��   0.����");
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
				ArrayList<CampVO> array = dao.list();
				System.out.println("");
//				System.out.println("��������������������������������������������������������������������������������������");
				for(CampVO v:array) {
					System.out.println("����������������������������������������������������������������������������������");
					System.out.println("    ķ���� \t\t  �ּ�                     ");
					System.out.println("=========================================");
					System.out.printf("  %s(%s)\t\t %s\n", v.getCname(),v.getCode(),v.getAddress());
					System.out.print("\n    �ü��� - ");

					
					ArrayList<FacilityVO>farray = fdao.list(v.getCode());
					for(FacilityVO f:farray) {
						
					System.out.printf("  %s( %s)", f.getFname(),f.getFcode());					
				}
					System.out.print("\n    ķ���� ��� - ");
					ArrayList<TypeVO>tarray = tdao.list(v.getCode());
					for(TypeVO t:tarray) {
						System.out.printf("   %s( %s)\t����:%d��" , t.getTname(),t.getTcode(),t.getQnt());
					}
					
				System.out.println("\n����������������������������������������������������������������������������������");
				System.out.println("");
				}
				break;
			case 3: 
				break;
			case 4: 
				Ex02.execute();
				break;
			case 5: 
				break;
			default:
				System.out.println("�޴��� �缱�� �ٶ��ϴ�.");

				
			}
		}
	}
}


























