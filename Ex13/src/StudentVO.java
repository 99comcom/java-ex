
public class StudentVO { //VO는 입출력할때 사용 캡슐화시켜서 데이터 관리
	
	private int no ; 
	private String name;
	private String address;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void print() {
		System.out.printf("학번:%d\t\t이름:%s\t주소:%s\n",no,name,address);
		
		
	}
	
	
	

}
