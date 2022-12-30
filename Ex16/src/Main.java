import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
		System.out.println("=======================================");
		System.out.println("1.학과관리");
		System.out.println("2.시험타입관리");		
		System.out.println("3.학생관리");
		System.out.println("4.성적관리");
		System.out.println("0.프로그램종료");
		System.out.println("=======================================");
		int meun = input("선택 ");
		switch(meun) {
		case 0 :
			System.out.println("프로그램 종료");
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
				System.out.println("메뉴를 재선택 바랍니다.");
		
		
		
		}
		}
		

	}
	//숫자입력받기
		public static int input(String title) {
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
}
