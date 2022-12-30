import java.util.*;

public class Ex01 {

		public static void execute() {
//			int eng = Main.input("��������");
			CampDAO cdao = new CampDAO();
			CampVO vo = null;
			TypeDAO tdao = new TypeDAO();
			FacilDAO fdao= new FacilDAO();
			
			
			Scanner s =new Scanner(System.in);
			boolean run = true;
			while(run) {
				System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
				System.out.println("��1.ķ������ | 2. ķ������ȸ | 3.ķ������ | 4.�ü������� | 5.�������� | 0. ���� �� ");
				System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������");
				int menu = Main.input("���� > ");
				switch (menu) {
				case 0:
					run = false;
					System.out.println("�����մϴ�.");
					break;
				case 1:
					int newCode = cdao.getLastCode()+100;
					System.out.println("ķ�����ڵ� : " + newCode);
					vo=new CampVO();
					vo.setCode(newCode);
					System.out.println("ķ���� �̸� > ");
					vo.setName(s.nextLine());
					System.out.println("ķ���� �ּ� > ");
					vo.setAddress(s.nextLine());
					cdao.insert(vo);
					System.out.println(vo.getName() + "�� ��ϵǾ����ϴ�.");
					
					
					
					break;
				case 2:
					int code = Main.input("��ȸ�� ķ���� �ڵ带 �Է¹ٶ��ϴ�. ");
					
					vo = cdao.read(code);
					if(vo.getName()==null) {
						System.out.println("�ش� �������� �����ϴ�.");
					}else {
						System.out.print("ķ�����̸� : " + vo.getName());
						System.out.println("\t\t\tķ�����ּ� : "+ vo.getAddress());
						ArrayList<String> tarray = tdao.list(code);
						System.out.print("ķ����Ÿ�� : ");
						if(tarray.size()==0)System.out.print("����");
						for(String t:tarray) {
							System.out.print(t+"  ");
							
						}
						ArrayList<String> farray = fdao.list(code);
						System.out.print("\t�ü��� : ");
						if(farray.size()==0)System.out.print("����");
						for(String f:farray) {
							System.out.print(f + "  ");
						
					}
					System.out.println("");
					}
					
					break;
				case 3:
					
					System.out.println("====================================");
					System.out.println("�ڵ�\t ķ�����̸�\t ķ�����ּ�");
					System.out.println("====================================");
					ArrayList<CampVO> carray = cdao.list();
					for(CampVO c:carray) {
						c.printing();
						//�� ķ���庰 type���
						
						ArrayList<String> tarray = tdao.list(c.getCode());
						if(tarray.size()==0) System.out.println("ķ���� Ÿ�� : ����"); 
						for(String t:tarray) {
							
							System.out.println("\n��������������������������������������������");
							System.out.println("��"+c.getName() + "�� Ÿ�� : "+t);
							System.out.println("��������������������������������������������");
						}
						ArrayList<String> farray = fdao.list(c.getCode());
						System.out.print("ķ���� �ü��� : ");
						if(farray.size()==0)System.out.print("����");
						for (String f:farray) {
							System.out.print( f + "   ");
							}			
						System.out.println("\n=======================================");
						System.out.println("�ڵ�\t ķ�����̸�\t ķ�����ּ�");
						System.out.println("=======================================");
						
							
						}
		
					
					System.out.println("\t\t\t\t\t\t\t ��ϵ� ķ����� : " + carray.size());
					
					
					
					break;
				case 4:
					Ex02.execute();
					
					
					break;
				case 5:
					Ex03.execute();
					break;
					
					default:
						System.out.println("�޴��� �缱�� �ٶ��ϴ�.");
				
				}
				
			}			
		}
}





