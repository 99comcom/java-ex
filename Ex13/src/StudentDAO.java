import java.io.*;
import java.util.*;

public class StudentDAO {
	
	File file= new File("c:/data/java/Ex13/student.txt");
	String line = "";
	String lines = "";
	public ArrayList<StudentVO> list () {			//목록
		ArrayList<StudentVO> array=new ArrayList<StudentVO>();
		try {
			BufferedReader readr = new BufferedReader(new FileReader(file));
			line = "";
			while((line=readr.readLine())!=null) {		//값이 없을때까지
				StringTokenizer st = new StringTokenizer(line, "|");
				StudentVO vo = new StudentVO();
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setName(st.nextToken());
				vo.setAddress(st.nextToken());
				array.add(vo);
				
				
			}
		}catch(Exception e) {
			System.out.println("학생목록:" + e.toString());
		}
		return array;	
	}
	
	
	public int getMaxNo() {
		int no = 0;
		try {
			BufferedReader readr = new BufferedReader(new FileReader(file));
			line = "";
			while((line=readr.readLine())!=null) {		//값이 없을때까지
				StringTokenizer st = new StringTokenizer(line, "|");
				no=Integer.parseInt(st.nextToken());
				
				
			}
		}catch(Exception e) {
			System.out.println("마지막 등록 학생:" + e.toString());
		}
		return no;
	}
	
	public void insert(StudentVO vo) {
		try {
			FileWriter writer = new FileWriter(file,true);
			writer.write(vo.getNo()+"|"+vo.getName()+"|"+vo.getAddress()+"\n");
			writer.flush();
			writer.close();
				
			
		}catch(Exception e) {
			System.out.println("검색:" + e.toString());
		}

	}
	
	public StudentVO read (int no ) {
		StudentVO vo = new StudentVO();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			line = "";
			while((line=reader.readLine())!=null){
			StringTokenizer st = new StringTokenizer(line,"|");
			int lineNo=Integer.parseInt(st.nextToken());
			if(no==lineNo) {
				vo.setNo(lineNo);
				vo.setName(st.nextToken());
				vo.setAddress(st.nextToken());
				break;
				}
			}
			
		}catch(Exception e) {
			System.out.println("찾기:" + e.toString());
		}
		return vo;
		
	}
}


