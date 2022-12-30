//import java.util.*;
//import java.io.*;
//public class SaleDAO {
//	
//	File file = new File("c:/data/java/Ex13/updata.txt");
//	public void insert(SalveVO vo) {
//		try {
//			FileWriter writer = new FileWriter(file,true);
//			writer.write(vo.getNo()+"|"+vo.getDate()+"|"+vo.getQnt()+"\n");
//			writer.flush();
//			writer.close();
//		}catch(Exception e) {
//			
//			System.out.println("판매등록:" + e.toString());
//		}
//	}
//	
//	

import java.util.*;
import java.io.*;

public class SaleDAO {
	File file=new File("c:/data/java/Ex13/updata.txt");
	//판매등록
	public void insert(SalveVO vo) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(vo.getNo()+"|"+vo.getDate()+"|"+vo.getQnt()+"\n");
			writer.flush();
			writer.close();
		}catch(Exception e) {
			System.out.println("판매등록:" + e.toString());
		}
	}
	
	//특정 상품에대한 판매목록
	public ArrayList<SalveVO> list(int no){
		ArrayList<SalveVO> array=new ArrayList<SalveVO>();
		try {
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line="";
			while((line=reader.readLine()) != null) {
				StringTokenizer st=new StringTokenizer(line, "|");
				int lineNo=Integer.parseInt(st.nextToken());
				if(no==lineNo) {
					SalveVO vo=new SalveVO();
					vo.setNo(lineNo);
					vo.setDate(st.nextToken());
					vo.setQnt(Integer.parseInt(st.nextToken()));
					array.add(vo);
				}
			}
		}catch(Exception e) {
			System.out.println("판매목록:" + e.toString());
		}
		return array;
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public ArrayList<SalveVO> list (int no){
//		ArrayList<SalveVO> array = new ArrayList<SalveVO>();
//		
//		
//		try {
//		
//			BufferedReader reader = new BufferedReader ( new FileReader ( file ));
//			String line = "";
//			while((line = reader.readLine())!=null) {
//				StringTokenizer st = new StringTokenizer(line,"|");
//				int lineNo=Integer.parseInt(st.nextToken());
//				if(no==lineNo) {
//					SalveVO vo = new SalveVO();
//					vo.setNo(lineNo);
//					vo.setDate(st.nextToken());
//					vo.setQnt(Integer.parseInt(st.nextToken()));
//					array.add(vo);	
//					
//				}
//			}
//		}catch(Exception e ) {
//			System.out.println("판매목록" + e.toString());
//		}	
//		return array;
//	}
//}
