import java.sql.*;
import java.util.*;
public class FacilityDAO {
	Connection con = Database.getConnection();
	public void insert(FacilityVO vo) {
		try {
			String sql = "insert into tbl_camp_facility values(?,?) ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCode());
			ps.setString(2, vo.getFcode());
			ps.execute();
			
		}catch(Exception e) {
			System.out.println("new code" + e.toString());
		}
	
		
	}
	
	//Ư�� ķ���忡 Ư�� �ü��� ��ȸ
	public FacilityVO read(String code, String fcode) {
		FacilityVO vo = new FacilityVO();

		String sql = "select *from  view_facility where code= ? and fcode=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, code);
			ps.setString(2, fcode);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				vo.setCode(rs.getString("code"));
				vo.setFcode(rs.getString("fcode"));
				vo.setFname(rs.getString("fname"));
			}
		}catch(Exception e) {
			System.out.println("�ü��� ���" + e.toString());
		}
		return vo;
	}
	
	public boolean delete(String fcode) {
		boolean success=false;
		try {
			String sql = "delete from tbl_facility where fcode = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fcode);
			ps.execute();
			success=true;
		}catch(Exception e) {
			
//			System.out.println("new code" + e.toString());
		}
		
		return success;
	}
	
	
	
	public FacilityVO read(String fcode) {
		FacilityVO vo = new FacilityVO();
		try {
			String sql = "select *from  tbl_facility where fcode= ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fcode);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				vo.setFcode(rs.getString("fcode"));
				vo.setFname(rs.getString("fname"));
			}
		}catch(Exception e) {
			System.out.println("��ȸ" + e.toString());
		}

		return vo;
	}
	
	
	
	public void insert(String fcode, String fname) {
		try {
			String sql = "insert into tbl_facility values(?,?) ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fcode);
			ps.setString(2, fname);
			ps.execute();
			
		}catch(Exception e) {
			System.out.println("new code" + e.toString());
		}
	
	}
	
	
	  //new Code ����������
	public String getNewCode() {
		String newCode="";
		try {
			String sql="select max(fcode) mcode from tbl_facility";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				String maxCode=rs.getString("mcode");
				int code=Integer.parseInt(maxCode.substring(1)) + 10;
				newCode = "f" + code;
			}
		}catch(Exception e) {
			System.out.println("new code:" + e.toString());
		}
		return newCode;
	}
	


	
	//��ü �ü��� ���
	public ArrayList<FacilityVO> list () {
		ArrayList<FacilityVO> array = new ArrayList<FacilityVO>();

		try {
			String sql = "select *from  tbl_facility ";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FacilityVO vo = new FacilityVO();
				vo.setFcode(rs.getString("fcode"));
				vo.setFname(rs.getString("fname"));
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("���ü��� ���" + e.toString());
		}

		return array;
	}
	
	//Ư�� �ü��� ���
	public ArrayList<FacilityVO> list (String code) {
		ArrayList<FacilityVO> array = new ArrayList<FacilityVO>();
	
		String sql = "select *from  view_facility where code= ?";
		try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, code);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			FacilityVO vo = new FacilityVO();

			vo.setCode(rs.getString("code"));
			vo.setFcode(rs.getString("fcode"));
			vo.setFname(rs.getString("fname"));
			array.add(vo);
			
		}
		
		
		
		}catch(Exception e) {
			System.out.println("�ü��� ���" + e.toString());
		}
		
		
		
		
		
		return array;
	}

	
	
	
	
}