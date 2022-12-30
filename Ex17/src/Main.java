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
//					System.out.println("1.학과관리");
//					System.out.println("2.타입관리");
//					System.out.println("3.학생관리");
//					System.out.println("4.성적관리");
//					System.out.println("0.프로그램종료");
//					System.out.println("======================");
//					int menu=input("선택");
//					switch(menu) {
//					case 0:
//						run=false;
//						System.out.println("프로그램을 종료합니다.");
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
//						System.out.println("0~4 메뉴를 선택하세요.");
//					}
//				}
//			}//main

			//숫자입력받기
			public static int input (String title) {
				Scanner s=new Scanner(System.in);
				String value="";
				boolean isNumber=false;
				do {
					System.out.print(title + ">");
					value=s.nextLine();
					isNumber=value.matches("-?\\d+(\\.\\d+)?");
					if(isNumber==false) System.out.println("숫자로입력하세요!");
				}while(isNumber==false);
				
				return Integer.parseInt(value);
			}
		}//class

		

	
	
