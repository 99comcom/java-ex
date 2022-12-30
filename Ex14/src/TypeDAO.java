import java.util.*;
import java.io.*;

public class TypeDAO {
	File file = new File("c:/data/java/Ex14/type.txt");
	
	
	public void delete(int code, String type) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			String lines="";
			while((line=reader.readLine())!=null) {
				StringTokenizer st =  new StringTokenizer(line,"|");
				int lineCode=Integer.parseInt(st.nextToken());
				String lineFacil = st.nextToken();
				
				if(code!=lineCode||!lineFacil.equals(type)) {
					lines= lines + line + "\n";
					
				}
			}
			FileWriter writer = new FileWriter(file, false);
			writer.write(lines);
			writer.flush();
			writer.close();
			
		}catch(Exception e) {
			System.out.println("유형삭제 : " + e.toString());
		}
	}
	
	
	
	
	public void insert(int code,String type) {
		try {
			FileWriter writer = new FileWriter(file,true);
			writer.write(code + "|"+type+"\n");
			writer.flush();
			writer.close();
		}catch(Exception e) {
			System.out.println("시설 유형 : " + e.toString());
		}
		
	}
	
	
	
	
	
	//특정 캠핑장의 type 목록
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
			
		}catch(Exception e ){
			System.out.println("Type 목록 : " + e.toString());
			
		}
		
		
		
		
		return array;
		
		
		
		
		
	}

}
