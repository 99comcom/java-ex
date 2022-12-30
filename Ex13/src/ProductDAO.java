
import java.util.*;
import java.io.*;

public class ProductDAO {
	
	File file = new File("c:/data/java/Ex13/product.txt");
	
//	public void update(int no , int qnt) {
//		
//		ProductVO vo = new ProductVO();
//		try {
//			BufferedReader reader = new BufferedReader(new FileReader(file));
//			String lines= "";
//			String line = "";
//			while((line = reader.readLine())!=null) {
//				StringTokenizer st = new StringTokenizer(line,"|");
//				int lineNo = Integer.parseInt(st.nextToken());
//				if(no==lineNo) {
//					vo =new ProductVO();
//					vo.setNo(lineNo);
//					vo.setName(st.nextToken());
//					vo.setPrice(Integer.parseInt(st.nextToken()));
//					vo.setQnt(Integer.parseInt(st.nextToken()));
//					vo.setQnt(vo.getQnt()-qnt);
//					lines = lines + vo.getNo()+"|"+vo.getName()+"|"+vo.getPrice()+"|"+vo.getQnt()+"\n";
//				}else {
//					lines = lines+line;
//					}
//				}
//			
//			FileWriter writer = new FileWriter(file,false);
//			writer.write(lines);
//			writer.flush();
//			writer.close();
//			}catch(Exception e ) {
//				
//				System.out.println("마지막 상품 등록:" + e.toString());
//			}
//	 public void update(int no, int qnt) {
//	      try {
//	         BufferedReader reader=new BufferedReader(new FileReader(file));
//	         String line="";
//	         String lines="";
//	         while((line=reader.readLine()) != null) {
//	            StringTokenizer st=new StringTokenizer(line, "|");
//	            int lineNo=Integer.parseInt(st.nextToken());
//	            if(no==lineNo) {
//	               ProductVO vo=new ProductVO();
//	               vo.setNo(lineNo);
//	               vo.setName(st.nextToken());
//	               vo.setPrice(Integer.parseInt(st.nextToken()));
//	               vo.setQnt(Integer.parseInt(st.nextToken()));
//	               vo.setQnt(vo.getQnt() - qnt);
//	               
//	               lines=lines + vo.getNo()+"|"+vo.getName()
//	                     +"|"+vo.getPrice()+"|"+vo.getQnt()+"\n";
//	            }else {
//	               lines = lines + line ;
//	            }
//	         }
//	         //새로운 파일저장
//	         FileWriter writer=new FileWriter(file, false);
//	         writer.write(lines);
//	         writer.flush();
//	         writer.close();
//	      }catch(Exception e) {
//	         System.out.println("마지막 상품코드:" + e.toString());
//	      }
//	   }
//
//	public ProductVO read(int no) {
//		ProductVO vo = new ProductVO();
//		try {
//			BufferedReader reader = new BufferedReader(new FileReader(file));
//			String line = "";
//			while((line = reader.readLine())!=null) {
//				StringTokenizer st = new StringTokenizer(line,"|");
//				int lineNo = Integer.parseInt(st.nextToken());
//				if(no==lineNo) {
//					vo.setNo(lineNo);
//					vo.setName(st.nextToken());
//					vo.setPrice(Integer.parseInt(st.nextToken()));
//					vo.setQnt(Integer.parseInt(st.nextToken()));
//					break;
//				}
//			}
//			}catch(Exception e ) {
//				System.out.println("마지막 상품 코드:" + e.toString());
//			}	
//		return vo;
//	}
//	
//	
//	
//	public void inset(ProductVO vo) {
//		try {
//			FileWriter writer = new FileWriter(file,true);
//			writer.write(vo.getNo()+"|"+vo.getName()+"|"+vo.getPrice()+"|"+vo.getQnt()+"\n");
//			writer.flush();
//			writer.close();		
//			
//		}catch(Exception e) {
//			System.out.println("상품등록:" + e.toString());
//		}
//	}
	
//	public int getLastNo() {
//		int no=0;
//		try {
//			BufferedReader reader = new BufferedReader(new FileReader(file));
//			String line = "";
//			while((line = reader.readLine())!=null) {
//				StringTokenizer st = new StringTokenizer(line,"|");
//				ProductVO vo = new ProductVO();
//				no=Integer.parseInt(st.nextToken());
//			}
//			}catch(Exception e ) {
//				System.out.println("마지막 상품 코드:" + e.toString());
//			}
//		
//		return no;
//	}
//	
//	public ArrayList<ProductVO> list(){
//		ArrayList<ProductVO> array = new ArrayList<ProductVO>();
//		
//		try {
//			BufferedReader reader = new BufferedReader(new FileReader(file));
//			String line = "";
//			while((line = reader.readLine())!=null) {
//				StringTokenizer st = new StringTokenizer(line,"|");
//				ProductVO vo = new ProductVO();
//				vo.setNo(Integer.parseInt(st.nextToken()));
//				vo.setName(st.nextToken());
//				vo.setPrice(Integer.parseInt(st.nextToken()));
//				vo.setQnt(Integer.parseInt(st.nextToken()));
//				array.add(vo);
//			}
//			}catch(Exception e ) {
//				System.out.println("상품목록:" + e.toString());
//			}
//		return array;
//	
//		
//		}
//}
	
	
	


		//재고수량 - 판매수량
		public void update(int no, int qnt) {
			try {
				BufferedReader reader=new BufferedReader(new FileReader(file));
				String line="";
				String lines="";
				while((line=reader.readLine()) != null) {
					StringTokenizer st=new StringTokenizer(line, "|");
					int lineNo=Integer.parseInt(st.nextToken());
					if(no==lineNo) {
						ProductVO vo=new ProductVO();
						vo.setNo(lineNo);
						vo.setName(st.nextToken());
						vo.setPrice(Integer.parseInt(st.nextToken()));
						vo.setQnt(Integer.parseInt(st.nextToken()));
						vo.setQnt(vo.getQnt()-qnt);
						
						lines=lines + vo.getNo()+"|"+vo.getName()
								+"|"+vo.getPrice()+"|"+vo.getQnt()+"\n";
					}else {
						lines = lines + line +"\n";
					}
				}
				//새로운 파일저장
				FileWriter writer=new FileWriter(file, false);
				writer.write(lines);
				writer.flush();
				writer.close();
			}catch(Exception e) {
				System.out.println("마지막 상품코드:" + e.toString());
			}
		}
		
		//상품조회
		public ProductVO read(int no) {
			ProductVO vo=new ProductVO();
			try {
				BufferedReader reader=new BufferedReader(new FileReader(file));
				String line="";
				
				while((line=reader.readLine()) != null) {
					StringTokenizer st=new StringTokenizer(line, "|");
					int lineNo=Integer.parseInt(st.nextToken());
					if(no==lineNo) {
						vo.setNo(lineNo);
						vo.setName(st.nextToken());
						vo.setPrice(Integer.parseInt(st.nextToken()));
						vo.setQnt(Integer.parseInt(st.nextToken()));
						break;
					}
				}
			}catch(Exception e) {
				System.out.println("마지막 상품코드:" + e.toString());
			}
			return vo;
		}
		
		//상품입력
		public void insert(ProductVO vo) {
			try {
				FileWriter writer=new FileWriter(file, true);
				writer.write(vo.getNo()+"|"+vo.getName()+"|"+vo.getPrice()+"|"+vo.getQnt()+"\n");
				writer.flush();
				writer.close();
			}catch(Exception e) {
				System.out.println("상품등록:" + e.toString());
			}
		}
		
		//마지막 상품코드 가져오기
		public int getLastNo() {
			int no=0;
			try {
				BufferedReader reader=new BufferedReader(new FileReader(file));
				String line="";
				while((line=reader.readLine()) != null) {
					StringTokenizer st=new StringTokenizer(line, "|");
					no=Integer.parseInt(st.nextToken());
				}
			}catch(Exception e) {
				System.out.println("마지막 상품코드:" + e.toString());
			}
			return no;
		}
		
		//상품목록
		public ArrayList<ProductVO> list(){
			ArrayList<ProductVO> array=new ArrayList<ProductVO>();
			try {
				BufferedReader reader=new BufferedReader(new FileReader(file));
				String line="";
				while((line=reader.readLine()) != null) {
					StringTokenizer st=new StringTokenizer(line, "|");
					ProductVO vo=new ProductVO();
					vo.setNo(Integer.parseInt(st.nextToken()));
					vo.setName(st.nextToken());
					vo.setPrice(Integer.parseInt(st.nextToken()));
					vo.setQnt(Integer.parseInt(st.nextToken()));
					array.add(vo);
				}
			}catch(Exception e) {
				System.out.println("상품목록:" + e.toString());
			}
			return array;
		}
	}
