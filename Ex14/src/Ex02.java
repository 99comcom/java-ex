import java.util.*;
public class Ex02 {
	public static void execute() {
		
		Scanner s = new Scanner(System.in);
		boolean run = true;
		CampDAO cdao = new CampDAO();
		CampVO vo = null;
		String[] facility = {"ȭ���","����", "����","��������","������","������","������"};
		FacilDAO fdao = new FacilDAO();
		
		
		while(run) {
			System.out.println("��������������������������������������������������������������������������");
			System.out.println("��1.�ü������ | 2. �ü������� | 0.�����޴� �� ");
			System.out.println("��������������������������������������������������������������������������");
			int menu=Main.input("�޴����� ");
			switch(menu) {
			case 0:
				run=false;
				System.out.println("���� �޴��� ���ư��ϴ�.");
				break;
				
			case 1:
				int code = Main.input("ķ�����ȣ ");
				vo = cdao.read(code);
				if(vo.getName()==null) {
					System.out.println("�ش� ķ������ �����ϴ�.");
					break;
				}			
				
				System.out.println("ķ�����̸� : " + vo.getAddress());
				System.out.println("----------------------------------------------------");
				
				ArrayList<String> farray = fdao.list(code);
				ArrayList<String> check = new ArrayList<>();
					for(int i=0;i<facility.length;i++) {
//						System.out.printf("[%d]%s\n" , i ,facility[i]);
						boolean isFind=false;
						for(String f:farray) {
							if(facility[i].equals(f)) isFind=true;
							
							}
							if(isFind==true) check.add("O");
						
							else check.add("X");
							System.out.printf("[%d]%s(%s)\n",i,facility[i],check.get(i));
							
							
						}
						System.out.println("-------------------------------");
						int sel=Main.input("�ü������� ");
						if(sel==0)break;
						if(check.get(sel).equals("O")){
							System.out.println("��ϵ� �ü��� �Դϴ�.");
							break;
						}
					fdao.insert(code, facility[sel]);
					System.out.println(facility[sel] + "�� ��ϵǾ����ϴ�.");
				
				break;
					
			
				
			case 2:
				code = Main.input("ķ�����ȣ ");
				vo = cdao.read(code);
				if(vo.getName()==null) {
					System.out.println("�ش� ķ������ �����ϴ�.");
					break;
				}			
				
				System.out.println("ķ�����̸� : " + vo.getAddress());
				System.out.println("----------------------------------------------------");
				
				farray = fdao.list(code);
			   check = new ArrayList<>();
					for(int i=0;i<facility.length;i++) {
//						System.out.printf("[%d]%s\n" , i ,facility[i]);
						boolean isFind=false;
						for(String f:farray) {
							if(facility[i].equals(f)) isFind=true;
							
							}
							if(isFind==true) check.add("O");
						
							else check.add("X");
							
							System.out.printf("��Ҵ� 0�� �����ּ��� \n[%d]%s(%s)\n",i,facility[i],check.get(i));
							
							
						}
						System.out.println("-------------------------------");
						sel=Main.input("�ü������� ");
						if(sel==0)break;
						if(check.get(sel).equals("X")){
							System.out.println("��ϵ��� ���� �ü��� �Դϴ�. ��ϵ� �ü����� ���ùٶ��ϴ�.");
							break;
						}
						fdao.delete(code, facility[sel]);
						System.out.println(facility[sel] + "�� �����Ǿ����ϴ�.");
				break;
				
				default:
					System.out.println("0~2�� �޴��� �����ϼ���.");
			
			
			
			}
		}
		
		
		
	}

}
