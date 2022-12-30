import java.util.*;
import java.text.*;
import java.sql.*;


public class StatementDAO {
	Connection con =Database.getConnection();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	
	
	
	
	public StatementVO read(String ano) {
		StatementVO vo = new StatementVO();
		try {
			String sql = "select*from tbl_statement where ano = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ano);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				vo.setAno(rs.getString("ano"));
				String udate = sdf.format(rs.getDate("sdate"));
				vo.setSdate(udate);
				vo.setTtype(rs.getString("ttype" ));
				vo.setAmount(Integer.parseInt(rs.getString("amount")));
				
			}
					
		}catch(Exception e) {
			System.out.println("입출금 조회" + e.toString());
		}
		
		return vo;
	}
	
	
	public void insert(StatementVO vo) {
		
		try {
			String sql = "insert into tbl_statement (ano,ttype,amount) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,vo.getAno());
			ps.setString(2, vo.getTtype());
			ps.setInt(3, vo.getAmount());
			ps.execute();
			
		}catch(Exception e) {
			System.out.println("입출금" +e.toString());
		}
	}
	
	
	


	public ArrayList<StatementVO> list(String ano){
		ArrayList<StatementVO> array =new ArrayList<StatementVO>();
		try {
			String sql = "select *from tbl_statement where ano = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ano);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StatementVO vo = new StatementVO();
				vo.setAno(rs.getString("ano"));
				vo.setTtype(rs.getString("ttype"));
				vo.setAmount(rs.getInt("amount"));
				String udate = sdf.format(rs.getDate("sdate"));
				vo.setSdate(udate);
				array.add(vo);
				
			}
					
			
		}catch(Exception e ) {
			System.out.println("입출금 목록" +  e.toString());
		}
		
		return array;
	}
	
	
	
	

}
