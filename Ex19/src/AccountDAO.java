import java.util.*;
import java.sql.*;


public class AccountDAO {
	Connection con = Database.getConnection();
	
	public ArrayList<AccountVO> list(){
		ArrayList<AccountVO> array = new ArrayList<AccountVO>();
		try {
			String sql="select*from tbl_Account";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				AccountVO vo =new AccountVO();
				vo.setAno("ano");
				vo.setAname("aname");
//				vo.setBalance(Integer.parseInt("balance"));
				vo.setOdate("odate");
			}
			
			
		}catch(Exception e) {
			System.out.println("°èÁÂ ¸ñ·Ï" + e.toString());
		}
				
		
		
		return array;
		
	}
	
	
	

}
