
public class StudentVO { //VO�� ������Ҷ� ��� ĸ��ȭ���Ѽ� ������ ����
	
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
		System.out.printf("�й�:%d\t\t�̸�:%s\t�ּ�:%s\n",no,name,address);
		
		
	}
	
	
	

}
