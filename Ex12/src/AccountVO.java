import java.text.DecimalFormat;

public class AccountVO {
	private int no;
	private String name;
	private int balance;
	DecimalFormat df =new DecimalFormat("#,###원");
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void print() {
		System.out.printf("번호:%d\t\t 이름:%s",no,name);
		System.out.println("\t 잔액:" + df.format(balance));
	}

}
