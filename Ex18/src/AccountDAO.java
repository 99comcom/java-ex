import java.util.*;
import java.text.*;
import java.sql.*;


public class AccountDAO {
	Connection con = Database.getConnection();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public void update(AccountVO vo) {
	
		try {
			String sql="update tbl_account set balance = ? where ano =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getBalance());
			ps.setString(2, vo.getAno());
			ps.execute();
			
		}catch(Exception e) {
			System.out.println("입출금 수정" + e.toString());
		}
		
	}


	
	public void insert(AccountVO vo) {
		try {
			String sql = "insert into tbl_account (ano,aname,balance) values (?,?,?)";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1,vo.getAno());
			ps.setString(2,vo.getAname());
			ps.setInt(3,vo.getBalance());
//			ps.setString(4, vo.getOdate());
			ps.execute();
			
			
		}catch(Exception e) {
			System.out.println("등록" + e.toString());
		}
	}
	
	
	
	
	
	public String newMaxNo() {
		String newNo = "";
		try {
			String sql = "select max(ano) mno from tbl_account";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				newNo=rs.getString("mno");
			}
		}catch(Exception e) {
			System.out.println("Max 번호 " + e.toString());
		}
		
		return newNo;
	}
	
	public AccountVO read (String ano) {
		AccountVO vo = new AccountVO();
		try {
			String sql="select*from tbl_account where ano = ? ";
		    PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,ano);
			ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						vo.setAno(rs.getString("ano"));
						vo.setAname(rs.getString("aname"));
						vo.setBalance(rs.getInt("balance"));
						String udate = sdf.format(rs.getDate("odate"));
						vo.setOdate(udate);
					}
		}catch(Exception e) {
			System.out.println("특정 계좌 조회" + e.toString());
		}
		
		
		
		return vo;
	}
	
	
	public ArrayList<AccountVO> list(){
		ArrayList<AccountVO> array = new ArrayList<AccountVO>();
		try {
			String sql="select*from tbl_account";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				AccountVO vo =new AccountVO();
				vo.setAno(rs.getString("ano"));
				vo.setAname(rs.getString("aname"));
				vo.setBalance(rs.getInt("balance"));
				String udate = sdf.format(rs.getDate("odate"));
				vo.setOdate(udate);
				array.add(vo);
			}
			
			
		}catch(Exception e) {
			System.out.println("계좌 목록" + e.toString());
		}
				
		
		
		return array;
		
	}
	
	
	

}
