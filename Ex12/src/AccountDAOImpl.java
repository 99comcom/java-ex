import java.io.*;

import java.util.*;

public class AccountDAOImpl implements AccountDAO {

	File file =  new File ("c:/data/java/Ex12/account.txt");
	public int getLastNo() {
		int getLastNo = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line="";
//			while((line=reader.readLine()!=null)) {
			while((line=reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line,"|");
				getLastNo=Integer.parseInt(st.nextToken());
			}
		}catch(Exception e){

				System.out.println("������ ��ȣ :"  + e.toString());
			
		}
		
		
		return getLastNo;//������ ���¹�ȣ ������ ����
	}
	
	public void trade(int no,int price) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			String lines = "";
			while((line=reader.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(line,"|");
				AccountVO vo = new AccountVO();
				vo.setNo(Integer.parseInt(st.nextToken()))   ;
		        vo.setName(st.nextToken());
				int balance = Integer.parseInt(st.nextToken());
				vo.setBalance(balance + price);
				
				if(no==vo.getNo()) {
					lines = lines + vo.getNo()+"|"+vo.getName()+"|"+vo.getBalance()+"\n";
				}else {
					lines =  lines + "\n";
					 
				}
			}
			FileWriter writer=new FileWriter(file,true);
			writer.write(lines);
			writer.flush();
			writer.close();
			
		}catch(Exception e) {
			System.out.println("��ȣ : " + e.toString());
		}
	}
	
	
	
	@Override
	public ArrayList<AccountVO> list() {                                                //���
		ArrayList<AccountVO> array = new ArrayList<AccountVO>();
		String line="";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while((line=reader.readLine())!=null) { 									//reader ������ �ƴҋ����� �ݺ�
				StringTokenizer st = new StringTokenizer(line,"|");						//���ο� ����ִ� �ڷḦ | �� �����Ѵ�
				AccountVO vo =new AccountVO();
				vo.setNo(Integer.parseInt(st.nextToken()));								//�ڷῡ �ִ� data�� ������ �´�.
				vo.setName(st.nextToken());
				vo.setBalance(Integer.parseInt(st.nextToken()));
				array.add(vo);															//�ڷῡ �ִ� data�� array�� ������ �µ� vo�� �־��ش�.
				
			}
		}catch(Exception e) {
			System.out.println("��� : " + e.toString());
		}
		
		
		return array;
	}

	@Override
	   public void insert(AccountVO vo) {//���»���
	      try {
	         FileWriter writer=new FileWriter(file, true);
	         writer.write(vo.getNo()+"|"+vo.getName()+"|"+vo.getBalance()+"\n");
	         writer.flush();
	         writer.close();
	      }catch(Exception e) {
	         System.out.println("���»���:" + e.toString());
	      }
	      
	      
	   }

	@Override
	public AccountVO read(int no) {														//��ȸ
		AccountVO vo = new AccountVO();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			while((line=reader.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				vo.setNo(Integer.parseInt(st.nextToken()));
				if(no == vo.getNo()) {                                                 // no�� �������� ��� 	  
					vo.setName(st.nextToken());
					vo.setBalance(Integer.parseInt(st.nextToken()));
					break;
				}
			}
			
		}catch(Exception e) {
			System.out.println("��ȸ : " + e.toString());
		}
		
		return vo;
	}

	@Override
	public void update(AccountVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub
		
	}
	
	

}













































