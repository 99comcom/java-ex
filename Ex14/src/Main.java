import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex01.execute();
	}
	//���ڸ� �Է� �ޱ� ������ ��� Error ���� �Ѿ��
	public static int input(String title) {
		Scanner s =new Scanner(System.in);
		boolean isNumber=false;
		String value = "";
		do {													//isNumber�� �����̸� if���� �ݺ�
			System.out.print(title + "> ");			
			value=s.nextLine();
			isNumber=value.matches("-?\\d+(\\.\\d+)?");			//���Խ�
			if(isNumber==false) System.out.println("���ڷ� �Է����ּ���");
		}while(!isNumber);					//inNumber �� false�� ���ȿ� ��� �Է� ���� ( �����̸� value�� int�� ��ȯ�Ͽ� return��
		return Integer.parseInt(value);
}
}