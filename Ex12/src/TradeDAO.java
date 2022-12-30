import java.io.*;
import java.util.*;

public class TradeDAO {

	File file =  new File ("c:/data/java/Ex12/trade.txt");
	String line = "";
	String lines = "";
	
	public void insert(TradeVO vo) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(vo.getNo()+"|"+vo.getDate()+"|"+vo.getType()+"|"+vo.getAmount()+"\n");
			writer.flush();
			writer.close();			
		}catch(Exception e) {
			System.out.println("�ŷ�������� : " + e.toString());
		}
		
	}
	
	public ArrayList<TradeVO> list(int no) {
		ArrayList<TradeVO> array = new ArrayList<TradeVO>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			line = "";
			while((line=reader.readLine()) !=null) {
				StringTokenizer st = new StringTokenizer(line,"|");
				int lineNo=Integer.parseInt(st.nextToken());
				
//				TradeVO vo = new TradeVO();
//				vo.setNo(Integer.parseInt(st.nextToken()));
//				if(vo.getNo()==no) {
//				vo.setDate(st.nextToken());
//				vo.setType(st.nextToken());
//				vo.setAmount(Integer.parseInt(st.nextToken()));
				
				if(lineNo==no) {
					TradeVO vo = new TradeVO();
					vo.setNo(lineNo);
					vo.setDate(st.nextToken());
					vo.setType(st.nextToken());
					vo.setAmount(Integer.parseInt(st.nextToken()));
					array.add(vo);					
				}				
			}	
			
		}catch(Exception e) {
			System.out.println("�ŷ����� : " + e.toString());
		}	
	return array;
	}
}


//public class TradeDAO {
//	   File file=new File("c:/data/java/ex12/trade.txt");
//	   
//	   //�ŷ��������
//	   public void insert(TradeVO vo) {
//	      try {
//	         FileWriter writer=new FileWriter(file, true);
//	         writer.write(vo.getNo()+"|"+vo.getDate()+"|"+vo.getType()
//	                  +"|"+vo.getAmount()+"\n");
//	         writer.flush();
//	         writer.close();
//	      }catch(Exception e) {
//	         System.out.println("�ŷ��������:" + e.toString());
//	      }
//	   }
//	   
//	   //Ư�������� �ŷ����� ���
//	   public ArrayList<TradeVO> list(int no){
//	      ArrayList<TradeVO> array=new ArrayList<TradeVO>();
//	      try {
//	         BufferedReader reader=new BufferedReader(new FileReader(file));
//	         String line="";
//	         while((line=reader.readLine()) != null) {
//	            StringTokenizer st=new StringTokenizer(line, "|");
//	            int lineNo=Integer.parseInt(st.nextToken());
//	            if(lineNo==no) {
//	               TradeVO vo=new TradeVO();
//	               vo.setNo(lineNo);
//	               vo.setDate(st.nextToken());
//	               vo.setType(st.nextToken());
//	               vo.setAmount(Integer.parseInt(st.nextToken()));
//	               array.add(vo);
//	            }
//	         }
//	      }catch(Exception e) {
//	         System.out.println("�ŷ�����:" + e.toString());
//	      }
//	      return array;
//	   }
//	}
