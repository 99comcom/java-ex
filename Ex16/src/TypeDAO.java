import java.util.*;
import java.sql.*;



public class TypeDAO {
	Connection con = Database.getConnection();
	
	public void update(TypeVO vo) {
		try{
			String sql = "update tbl_type set tname = ? where Tcode = ? ";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, vo.getTname());
			 ps.setString(2, vo.getTcode());

			 
			 ps.execute();
			
		}catch(Exception e ) {
			System.out.println("수정 : " +e.toString());
		}
	}

	
	
	public boolean delete(String tcode) {
		boolean success = false;
		try {
		
		String sql = "delete from tbl_type where tcode = ?";
		PreparedStatement ps =con.prepareCall(sql);
		ps.setString(1, tcode);
		ps.execute();
		success = true;
		
	}catch(Exception e) {
//		System.out.println("삭제" + e.toString());
	}
		
		return success;
	}

	
	public TypeVO read (String tcode) {
		
	
		TypeVO vo = new TypeVO();
		try {
			String sql = "select * from tbl_type where tcode = ?";
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setString(1, tcode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setTcode(rs.getString("tcode"));
				vo.setTname(rs.getString("tname"));

			}

		}catch(Exception e) {
			System.out.println("입력 : " + e.toString());
		}
		return vo;
	}

	
	
	public void insert(TypeVO vo) {
		try {
			String sql = "insert into tbl_type(tcode,tname,tdate) values(?,?)";
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setString(1, vo.getTcode());
			ps.setString(2, vo.getTname());

			ps.execute();


		}catch(Exception e) {
			System.out.println("입력 : " + e.toString());
		}


	}
	
	public String gatMaxCode() {
		String maxCode="";
		try {
			String sql = "select max(tcode) from tbl_type";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				maxCode = rs.getString("max(tcode)");
				
			}
			
		}catch(Exception e) {
			System.out.println("Max code" +e.toString());
		}
		
		return maxCode;
	}
	
		
		public ArrayList<TypeVO> list(){
			ArrayList<TypeVO> array= new ArrayList<TypeVO>();
			try {
				String sql = "select * from tbl_type";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs =ps.executeQuery();
				while(rs.next()) {

					TypeVO vo =new TypeVO();
					vo.setTcode(rs.getString("tcode"));
					vo.setTname(rs.getString("tname"));

					array.add(vo);
				}

			}catch(Exception e) {
				System.out.println("목록 : " + e.toString());
			}




			return array;


		
		
	}
			
}
