import java.util.*;

		public class Main {
			public static void main(String[] args) {
//			Ex01.execute();	
			Ex02.execute();
			}
				
//				Scanner s=new Scanner(System.in);
//				boolean run=true;
//				while(run) {
//					System.out.println("\n======================");
//					System.out.println("1.�а�����");
//					System.out.println("2.Ÿ�԰���");
//					System.out.println("3.�л�����");
//					System.out.println("4.��������");
//					System.out.println("0.���α׷�����");
//					System.out.println("======================");
//					int menu=input("����");
//					switch(menu) {
//					case 0:
//						run=false;
//						System.out.println("���α׷��� �����մϴ�.");
//						break;
//					case 1:
//					
//						break;
//					case 2:
//					
//						break;
//					case 3:
//						
//						break;
//					case 4:
//					
//						break;
//					default:
//						System.out.println("0~4 �޴��� �����ϼ���.");
//					}
//				}
//			}//main

			//�����Է¹ޱ�
			public static int input (String title) {
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
		}//class

		

	
	
