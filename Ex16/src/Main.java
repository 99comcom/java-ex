import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
		System.out.println("=======================================");
		System.out.println("1.�а�����");
		System.out.println("2.����Ÿ�԰���");		
		System.out.println("3.�л�����");
		System.out.println("4.��������");
		System.out.println("0.���α׷�����");
		System.out.println("=======================================");
		int meun = input("���� ");
		switch(meun) {
		case 0 :
			System.out.println("���α׷� ����");
			break;
		case 1 :
			Ex01.execute();
			break;
		case 2:
			Ex02.execute();
			break;
		case 3:
			
		break;
		case 4:
			break;
		case 5:
			break;
			default:
				System.out.println("�޴��� �缱�� �ٶ��ϴ�.");
		
		
		
		}
		}
		

	}
	//�����Է¹ޱ�
		public static int input(String title) {
			Scanner s=new Scanner(System.in);
			String value="";
			boolean isNumber=false;
			do {
				System.out.print(title + ">");
				value=s.nextLine();
				isNumber=value.matches("-?\\d+(\\.\\d+)?");
				if(isNumber==false) System.out.println("���ڷ��Է��ϼ���!");
			}while(isNumber==false);
			
			return Integer.parseInt(value);
		}
}
