import java.util.*;
import java.io.*;


public class CampDAO {
	File file = new File("c:/data/java/Ex14/camp.txt");
	
	public void insert(CampVO vo) {
		try {
			FileWriter writer = new FileWriter(file,true);
			writer.write(vo.getCode()+"|"+vo.getName()+"|"+vo.getAddress()+"\n");
			writer.flush();
			writer.close();
			
			
		}catch(Exception e) {
			System.out.println("ķ���� ���" + e.toString());
		}
		
		
	}
	
	
	
	
	public int getLastCode() {
		int code = 0;
		try {
			BufferedReader reader = new BufferedReader (new FileReader(file));
			String line = "";
			while((line=reader.readLine()) !=null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				code=Integer.parseInt(st.nextToken());

				}
			
			reader.close();;
		}catch(Exception e) {
			System.out.println("ķ���帶������ȣ" + e.toString());
		}	
		return code;		
	}
	
	
	
	
	public CampVO read(int code) {
		CampVO vo = new CampVO();
		try {
			BufferedReader reader = new BufferedReader (new FileReader(file));
			String line = "";
			while((line=reader.readLine()) !=null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				int lineCode=Integer.parseInt(st.nextToken());
				if(code==lineCode) {
					vo.setCode(lineCode);
					vo.setName(st.nextToken());
					vo.setAddress(st.nextToken());
				}
			}
			reader.close();
		}catch(Exception e) {
			System.out.println("ķ������ȸ" + e.toString());
		}
		
		return vo;
	}
		
		


	public ArrayList<CampVO> list () {
		ArrayList<CampVO> array = new ArrayList<>();
		
		try {
			BufferedReader reader = new BufferedReader (new FileReader(file));
			String line = "";
			while((line=reader.readLine()) !=null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				CampVO vo = new CampVO();
				vo.setCode(Integer.parseInt(st.nextToken()));
				vo.setName(st.nextToken());
				vo.setAddress(st.nextToken());
				array.add(vo);
				
			}
			
		}catch(Exception e) {
			System.out.println("ķ������" + e.toString());
		}
		
		return array;
	}
	
}
