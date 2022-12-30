
public class CampVO {
	private int code;
	private String name;
	private String address;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public void print() {
		System.out.println("번호 = " + code + "\t 이름 = " + name + "\t 주소 + " + address + "\n");
	}
	public void printing() {
		System.out.print(code + "\t " + name + "\t\t " + address+ "\n");
	}
	
	
	
	
}
