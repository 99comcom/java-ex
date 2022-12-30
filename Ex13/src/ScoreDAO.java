
import java.io.*;
import java.util.*;

public class ScoreDAO {
	File file= new File("c:/data/java/Ex13/score.txt");
	
	
	public void insert(ScoreVO vo) {
		
		try {
			FileWriter writer=new FileWriter(file,true);
			writer.write(vo.getNo()+"|"+vo.getType()+"|"+vo.getKor()+"|"+vo.getEng()+"|"+vo.getMat()+"\n");
			writer.flush();
			writer.close();	
			
		}catch(Exception e) {
			System.out.println("己利殿废" + e.toString());
		}
	}
	
	
	

	public ArrayList<ScoreVO> list (int no){
		
		ArrayList<ScoreVO> array = new ArrayList<ScoreVO>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line = "";
			while((line=reader.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(line,"|");
				int lineNo=Integer.parseInt(st.nextToken());
				if(no==lineNo) {
					ScoreVO vo = new ScoreVO();
					vo.setNo(lineNo);
					vo.setType(st.nextToken());
					vo.setKor(Integer.parseInt(st.nextToken()));
					vo.setEng(Integer.parseInt(st.nextToken()));
					vo.setMat(Integer.parseInt(st.nextToken()));
					array.add(vo);
					
				}
			}
		}catch(Exception e) {
			System.out.println("己利 格废 : " + e.toString());
		}
		
		return array;
		
	
	
}
}
