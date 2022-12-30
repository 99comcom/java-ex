
public class StatementVO {
	
	
	private String ano;
	private String sdate;
	private String ttype;
	private int amount;
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "StatementVO [ano=" + ano + ", sdate=" + sdate + ", ttype=" + ttype + ", amount=" + amount + "]";
	}
	
	
	
	
	

}
