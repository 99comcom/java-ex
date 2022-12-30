import java.util.*;
import java.io.*;



public class FacilDAO {
	File file = new File("c:/data/java/Ex14/facil.txt");
	
	//시설물삭제
	public void delete(int code, String facil) {
	
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			String lines="";
			while((line=reader.readLine())!=null) {
				StringTokenizer st =  new StringTokenizer(line,"|");
				int lineCode=Integer.parseInt(st.nextToken());
				String lineFacil = st.nextToken();
				
				if(code!=lineCode||!lineFacil.equals(facil)) {
					lines= lines + line + "\n";
					
				}
			}
			FileWriter writer = new FileWriter(file, false);
			writer.write(lines);
			writer.flush();
			writer.close();
			
		}catch(Exception e) {
			System.out.println("시설물 목록 : " + e.toString());
		}
	}
	
	
	
	
	
	
	
	
	
	public void insert(int code,String facil) {
		try {
			FileWriter writer = new FileWriter(file,true);
			writer.write(code + "|"+facil+"\n");
			writer.flush();
			writer.close();
		}catch(Exception e) {
			System.out.println("시설물 등록" + e.toString());
		}
		
	}
	
	
	
	
	//시설물 목록
	public ArrayList<String> list(int code){
		ArrayList<String> array = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			while((line=reader.readLine())!=null) {
				StringTokenizer st =  new StringTokenizer(line,"|");
				int lineCode=Integer.parseInt(st.nextToken());
				if(code==lineCode) {
					array.add(st.nextToken());
				}
			}
			
		}catch(Exception e) {
			System.out.println("시설물 목록 : " + e.toString());
		}
	
		
		
		
		return array;
	
	}
}
