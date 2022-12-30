import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex01.execute();
	}
	//숫자만 입력 받기 문자일 경우 Error 없이 넘어가기
	public static int input(String title) {
		Scanner s =new Scanner(System.in);
		boolean isNumber=false;
		String value = "";
		do {													//isNumber이 문자이면 if까지 반복
			System.out.print(title + "> ");			
			value=s.nextLine();
			isNumber=value.matches("-?\\d+(\\.\\d+)?");			//정규식
			if(isNumber==false) System.out.println("숫자로 입력해주세요");
		}while(!isNumber);					//inNumber 가 false인 동안에 계속 입력 받음 ( 숫자이면 value를 int로 변환하여 return함
		return Integer.parseInt(value);
}
}