
public class ProductVO {

	private int no;
	private String name;
	private int price;
	private int qnt;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
	public void print() {
		System.out.println("no=" + no + ", name=" + name + ", price=" + price + ", qnt=" + qnt + "]"); 
	}
	
	
}
