import java.text.*;
import java.util.*;

public class Ex02 {
	public static void execter() {
		Scanner s =new Scanner(System.in);
		boolean run = true;
		ProductDAO dao = new ProductDAO();
		DecimalFormat df = new DecimalFormat("#,###원");
		ProductVO vo = null;
		SaleDAO sdao = new SaleDAO();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		
		
		while(run) {
			System.out.println("￣￣￣￣￣￣￣￣￣상 품  관 리￣￣￣￣￣￣￣￣￣￣￣");
			System.out.println("1.상품등록 | 2.조회 | 3.목록 | 4.매출등록 | 0.종료 ");
			System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
			System.out.print("메뉴를 선택하여 주세요 > ");
			String menu = s.nextLine();
			System.out.print("\n");

			switch ( menu ) {
			case "1":
				int newCode = dao.getLastNo()+100;
				System.out.println("상품번호 > " + newCode);
				 vo = new ProductVO();
				vo.setNo(newCode);
				
				System.out.print("상품이랑 > ");
				vo.setName(s.nextLine());
				System.out.print("상품단가 > ");
				vo.setPrice(Integer.parseInt(s.nextLine()));
				System.out.print("재고단가 > ");
				vo.setQnt(Integer.parseInt(s.nextLine()));
				dao.insert(vo);
				System.out.println(vo.getName() + "이(가) 등록되었습니다.");
				break;
			case "2":


					System.out.println("검색 하실 학번 > ");
					int sno=s.nextInt(); s.nextLine();
					
					vo=dao.read(sno);
					if(vo.getName()==null) {
						System.out.println("등록된 학생이 없습니다.");
					}else {
						//상품정보
						System.out.println("--------------------------------------------");
						System.out.println("상품번호\t삼풍이름\t상품단가\t재고수량");
						System.out.println("--------------------------------------------");
						System.out.printf("%d\t%s\t %d\t  %d\n",vo.getNo(),vo.getName(),vo.getPrice(),vo.getQnt());
						ArrayList<SalveVO> sarray = sdao.list(sno);
						//상품판매목록
//						if(sarray.size()==0) {
//							System.out.println("판매된 상품이 없습니다.");
//						}
						System.out.println("--------------------------------------------");
						System.out.println("상품번호\t판매날짜\t\t판매수량\t\t재고");
						System.out.println("--------------------------------------------");
						
						if(sarray.size()==0) {
							System.out.println("판매한 상품이 없습니다.");
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
				System.out.println("상품번호\t삼풍이름\t상품단가\t재고수량\t   금액  수량");
				System.out.println("--------------------------------------------");
				
				for(ProductVO v:array) {
					int sum = v.getPrice()*v.getQnt();
					String strSum=df.format(sum);
					String price = df.format(v.getPrice());
					System.out.printf("%d\t%s\t%s\t%d개\t%10s\n",v.getNo(),v.getName(),price,v.getQnt(),strSum);
					
				}
				System.out.println("\n");
				break;
			case "4":
				System.out.println("상품번호 > ");
				sno = s.nextInt();s.nextLine();
				vo=dao.read(sno);
				if(vo.getName()==null) {
					System.out.println("등록된 상품이 없습니다.");
				}else {
					//상품정보
					System.out.println("--------------------------------------------");
					System.out.println("상품번호\t삼풍이름\t상품단가\t재고수량");
					System.out.println("--------------------------------------------");
					System.out.printf("%d\t%s\t %d\t  %d\n",vo.getNo(),vo.getName(),vo.getPrice(),vo.getQnt());
					ArrayList<SalveVO> sarray = sdao.list(sno);
					//상품판매목록

					System.out.println("--------------------------------------------");
					System.out.println("상품번호\t판매날짜\t\t판매수량\t\t재고");
					System.out.println("--------------------------------------------");
				
					for(SalveVO v:sarray) {

						System.out.println(v.toString());
					
						
					
				
					System.out.println("\n");
					SalveVO svo = new SalveVO();
					svo.setNo(sno);
					svo.setDate(sdf.format(new Date()));
					System.out.println("판매날짜>" + svo.getDate());
					System.out.print("판매수량 > ");
					svo.setQnt(s.nextInt());s.nextLine();
					
					//재고량-판매수량
					
					sdao.insert(svo);
					
					break;
					}
					System.out.println("판매등록을 완료하였습니다.");
				
				}
				break;
			case "0":
				System.out.println("종료합니다.");
				run=false;
				break;
					
				default:
					System.out.println("잘못된 입력입니다. 재 선택 바랍니다.");
				}
				
				
		
	}
}
}
