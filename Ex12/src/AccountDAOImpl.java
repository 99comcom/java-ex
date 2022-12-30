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

				System.out.println("마지막 번호 :"  + e.toString());
			
		}
		
		
		return getLastNo;//마지막 계좌번호 가지고 오기
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
			System.out.println("번호 : " + e.toString());
		}
	}
	
	
	
	@Override
	public ArrayList<AccountVO> list() {                                                //목록
		ArrayList<AccountVO> array = new ArrayList<AccountVO>();
		String line="";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while((line=reader.readLine())!=null) { 									//reader 공란이 아닐떄까지 반복
				StringTokenizer st = new StringTokenizer(line,"|");						//라인에 들어있는 자료를 | 로 구분한다
				AccountVO vo =new AccountVO();
				vo.setNo(Integer.parseInt(st.nextToken()));								//자료에 있는 data를 가지고 온다.
				vo.setName(st.nextToken());
				vo.setBalance(Integer.parseInt(st.nextToken()));
				array.add(vo);															//자료에 있는 data를 array로 가지고 온뒤 vo에 넣어준다.
				
			}
		}catch(Exception e) {
			System.out.println("목록 : " + e.toString());
		}
		
		
		return array;
	}

	@Override
	   public void insert(AccountVO vo) {//계좌생성
	      try {
	         FileWriter writer=new FileWriter(file, true);
	         writer.write(vo.getNo()+"|"+vo.getName()+"|"+vo.getBalance()+"\n");
	         writer.flush();
	         writer.close();
	      }catch(Exception e) {
	         System.out.println("계좌생성:" + e.toString());
	      }
	      
	      
	   }

	@Override
	public AccountVO read(int no) {														//조회
		AccountVO vo = new AccountVO();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			while((line=reader.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				vo.setNo(Integer.parseInt(st.nextToken()));
				if(no == vo.getNo()) {                                                 // no가 같을때만 출력 	  
					vo.setName(st.nextToken());
					vo.setBalance(Integer.parseInt(st.nextToken()));
					break;
				}
			}
			
		}catch(Exception e) {
			System.out.println("조회 : " + e.toString());
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













































