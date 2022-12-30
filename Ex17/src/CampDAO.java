import java.sql.*;
import java.util.*;


public class CampDAO {
	Connection con = Database.getConnection();
	
	
	
	
	
	
	//ķ���� ��ȸ
	public CampVO read(String code) {
		CampVO vo = new CampVO();
		try {
			String sql= "select*from tbl_camp where code = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, code);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				vo.setCode(rs.getString("code"));
				vo.setCname(rs.getString("cname"));
				vo.setAddress(rs.getString("address"));

			}

		}catch(Exception e) {
			System.out.println("ķ������ȸ" +e.toString());
		}		
		return vo;
	}

// ķ������ list
	public ArrayList<CampVO> list (){
		ArrayList<CampVO> array = new ArrayList<CampVO>();
		try {
			String sql= "select*from tbl_camp";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CampVO vo =new CampVO();
				vo.setCode(rs.getString("code"));
				vo.setCname(rs.getString("cname"));
				vo.setAddress(rs.getString("address"));
				array.add(vo);
			}

		}catch(Exception e) {
			System.out.println("ķ������" +e.toString());
		}
		return array;
	}

	
	
}
