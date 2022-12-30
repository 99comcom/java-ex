import java.text.DecimalFormat;
public class TradeVO {

	private int no;
	private String date;
	private String type;
	private int amount;
	DecimalFormat df =new DecimalFormat("#,###원");
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {

		return "계좌번호:" + no + "\t 입출금일:" + date + "\t 구분:" + type + "\t 입/출금액:" + df.format(amount);
	}
	
	public void print() {
		
		System.out.println(date + "\t " + type + "\t " + df.format(amount));
	}
	
	
	
}
