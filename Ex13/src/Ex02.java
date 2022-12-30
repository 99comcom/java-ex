import java.text.*;
import java.util.*;

public class Ex02 {
	public static void execter() {
		Scanner s =new Scanner(System.in);
		boolean run = true;
		ProductDAO dao = new ProductDAO();
		DecimalFormat df = new DecimalFormat("#,###��");
		ProductVO vo = null;
		SaleDAO sdao = new SaleDAO();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		
		
		while(run) {
			System.out.println("�������������������� ǰ  �� ������������������������");
			System.out.println("1.��ǰ��� | 2.��ȸ | 3.��� | 4.������ | 0.���� ");
			System.out.println("������������������������������������������������������");
			System.out.print("�޴��� �����Ͽ� �ּ��� > ");
			String menu = s.nextLine();
			System.out.print("\n");

			switch ( menu ) {
			case "1":
				int newCode = dao.getLastNo()+100;
				System.out.println("��ǰ��ȣ > " + newCode);
				 vo = new ProductVO();
				vo.setNo(newCode);
				
				System.out.print("��ǰ�̶� > ");
				vo.setName(s.nextLine());
				System.out.print("��ǰ�ܰ� > ");
				vo.setPrice(Integer.parseInt(s.nextLine()));
				System.out.print("���ܰ� > ");
				vo.setQnt(Integer.parseInt(s.nextLine()));
				dao.insert(vo);
				System.out.println(vo.getName() + "��(��) ��ϵǾ����ϴ�.");
				break;
			case "2":


					System.out.println("�˻� �Ͻ� �й� > ");
					int sno=s.nextInt(); s.nextLine();
					
					vo=dao.read(sno);
					if(vo.getName()==null) {
						System.out.println("��ϵ� �л��� �����ϴ�.");
					}else {
						//��ǰ����
						System.out.println("--------------------------------------------");
						System.out.println("��ǰ��ȣ\t��ǳ�̸�\t��ǰ�ܰ�\t������");
						System.out.println("--------------------------------------------");
						System.out.printf("%d\t%s\t %d\t  %d\n",vo.getNo(),vo.getName(),vo.getPrice(),vo.getQnt());
						ArrayList<SalveVO> sarray = sdao.list(sno);
						//��ǰ�ǸŸ��
//						if(sarray.size()==0) {
//							System.out.println("�Ǹŵ� ��ǰ�� �����ϴ�.");
//						}
						System.out.println("--------------------------------------------");
						System.out.println("��ǰ��ȣ\t�Ǹų�¥\t\t�Ǹż���\t\t���");
						System.out.println("--------------------------------------------");
						
						if(sarray.size()==0) {
							System.out.println("�Ǹ��� ��ǰ�� �����ϴ�.");
						}else {
							for(SalveVO v:sarray) {
								System.out.println(v.toString());
							}
						
							
						}
						
					}
							
					System.out.println("\n");


				break;
			case "3":
				ArrayList<ProductVO> array=dao.list();
				System.out.println("--------------------------------------------");
				System.out.println("��ǰ��ȣ\t��ǳ�̸�\t��ǰ�ܰ�\t������\t   �ݾ�  ����");
				System.out.println("--------------------------------------------");
				
				for(ProductVO v:array) {
					int sum = v.getPrice()*v.getQnt();
					String strSum=df.format(sum);
					String price = df.format(v.getPrice());
					System.out.printf("%d\t%s\t%s\t%d��\t%10s\n",v.getNo(),v.getName(),price,v.getQnt(),strSum);
					
				}
				System.out.println("\n");
				break;
			case "4":
				System.out.println("��ǰ��ȣ > ");
				sno = s.nextInt();s.nextLine();
				vo=dao.read(sno);
				if(vo.getName()==null) {
					System.out.println("��ϵ� ��ǰ�� �����ϴ�.");
				}else {
					//��ǰ����
					System.out.println("--------------------------------------------");
					System.out.println("��ǰ��ȣ\t��ǳ�̸�\t��ǰ�ܰ�\t������");
					System.out.println("--------------------------------------------");
					System.out.printf("%d\t%s\t %d\t  %d\n",vo.getNo(),vo.getName(),vo.getPrice(),vo.getQnt());
					ArrayList<SalveVO> sarray = sdao.list(sno);
					//��ǰ�ǸŸ��

					System.out.println("--------------------------------------------");
					System.out.println("��ǰ��ȣ\t�Ǹų�¥\t\t�Ǹż���\t\t���");
					System.out.println("--------------------------------------------");
				
					for(SalveVO v:sarray) {

						System.out.println(v.toString());
					
						
					
				
					System.out.println("\n");
					SalveVO svo = new SalveVO();
					svo.setNo(sno);
					svo.setDate(sdf.format(new Date()));
					System.out.println("�Ǹų�¥>" + svo.getDate());
					System.out.print("�Ǹż��� > ");
					svo.setQnt(s.nextInt());s.nextLine();
					
					//���-�Ǹż���
					
					sdao.insert(svo);
					
					break;
					}
					System.out.println("�Ǹŵ���� �Ϸ��Ͽ����ϴ�.");
				
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
