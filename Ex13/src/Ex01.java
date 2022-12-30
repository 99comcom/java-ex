import java.util.*;

public class Ex01 {
	
	
	public static void execter () {
		boolean run = true;
		Scanner s = new Scanner (System.in);
		StudentVO vo = null;
		StudentDAO dao = new StudentDAO();
		ScoreDAO sdao = new ScoreDAO();
		ScoreVO svo = null;
		
		
		while(run) {
			System.out.println("�������������������������������л�������������������������������");
			System.out.println("1.�л���� | 2.��ȸ | 3.��� | 4.������� | 0.���� ");
			System.out.println("������������������������������������������������������������������");
			System.out.print("�޴��� �����Ͽ� �ּ��� > ");
			String menu = s.nextLine();
			System.out.print("\n");

			switch ( menu ) {
			case "1":
				int newNo = dao.getMaxNo()+100;
				System.out.println("�й�:" + newNo);
				vo=new StudentVO();
				vo.setNo(newNo);
				
				System.out.print("�̸� > ");
				vo.setName(s.nextLine());
				
				System.out.print("�ּ� > ");
				vo.setAddress(s.nextLine());
				
				dao.insert(vo);
				
				System.out.println(vo.getName()+"��(��) ��ϵǾ����ϴ�.");
				
				break;
			case "2":
				String sno="";
				boolean isNumber=false;
				do {
					System.out.println("�˻� �Ͻ� �й� > ");
					sno=s.nextLine();
					isNumber=sno.matches("-?\\d+(\\.\\d+)?");
				}while(isNumber==false);
				
				vo=dao.read(Integer.parseInt(sno));
				if(vo.getName()==null) {
					System.out.println("�ش� �л��� �����ϴ�.");
					
				}else {
					vo.print();
					ArrayList<ScoreVO> tarray=sdao.list(Integer.parseInt(sno));
					for(ScoreVO v:tarray) {
						v.sprint();
						v.toString();
					}
				}
				break;
			case "3":
				ArrayList<StudentVO> array = dao.list();
				for(StudentVO v:array) {
					v.print();
					
				}
				System.out.println("\n��ü �л���" + array.size() + "�� �Դϴ�.\n");
				break;
			case "4":

				String dno = "";
				isNumber=false;
				do {
					System.out.print("�й� > ");
					dno=s.nextLine();
					isNumber=dno.matches("-?\\d+(\\.\\d+)?");
					
				}while(isNumber==false);
				
				 vo=dao.read(Integer.parseInt(dno));
				if(vo.getName()==null) {
					System.out.println("�ش� �л��� �����ϴ�.");
					
				}else {
					System.out.printf("%s(%s)\n",vo.getName(),vo.getAddress());
					System.out.println("--------------------------------------------------------");
				    System.out.println("����\t����\t����\t����\t����\t���");
				    System.out.println("--------------------------------------------------------");
					ArrayList<ScoreVO> tarray=sdao.list(Integer.parseInt(dno));
					for(ScoreVO v:tarray) {
						v.sprint();

				
					System.out.print("���� > ");
					String type=s.nextLine();
			
					
					
					
						
				
					String kor = "";
					isNumber=false;
					do {
						System.out.print("���� > ");
						kor=s.nextLine();
						isNumber=kor.matches("-?\\d+(\\.\\d+)?");
					}while(isNumber==false);
					
					String eng = "";
					isNumber=false;
					do {
						System.out.print("���� > ");
						eng=s.nextLine();
						isNumber=eng.matches("-?\\d+(\\.\\d+)?");
					}while(isNumber==false);
					
					String mat = "";
					isNumber=false;
					do {
						System.out.print("���� > ");
						mat=s.nextLine();
						isNumber=mat.matches("-?\\d+(\\.\\d+)?");
					}while(isNumber==false);
					
					svo = new ScoreVO();
					svo.setNo(Integer.parseInt(dno));
					svo.setType(type);
					svo.setKor(Integer.parseInt(kor));
					svo.setEng(Integer.parseInt(eng));
					svo.setMat(Integer.parseInt(mat));
					sdao.insert(svo);
					
					
					
					
					
					System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
					
					
					}
					}
					
				break;
				
				
			case "0":
				System.out.println("�����մϴ�.");
				run=false;
				
				break;
				
				default:
					System.out.println("�߸��� �Է��Դϴ�. �� ���� �ٶ��ϴ�.");
			}
			
			
			
			
			
			
		}
		
	
	}
		
}
	

