import java.util.*;

public interface AccountDAO {
	public ArrayList <AccountVO> list();
	public void insert(AccountVO vo);
	public AccountVO read (int no);
	public void update(AccountVO vo);
	public void delete(int no);
	
}
