import java.sql.*;
import java.util.*;
public class TypeDAO {
	Connection con = Database.getConnection();
	
	public ArrayList<TypeVO> list (String code){
		ArrayList<TypeVO> array = new ArrayList<TypeVO>();
		try {
		String sql = "select *from  view_type where code=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, code);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			TypeVO vo = new TypeVO();

			vo.setCode(rs.getString("code"));
			vo.setTcode(rs.getString("tcode"));
			vo.setTname(rs.getString("tname"));
			vo.setQnt(rs.getInt("qnt"));
			array.add(vo);	
		}
		}catch(Exception e) {
			System.out.println("유형 목록 " + e.toString());
		}
		
		return array;		
	}
}
