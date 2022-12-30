package ex16;

public class StudentVO extends DeptVO{
	private String sno; //학번
	private String sname; //이름
	private String dcode; //학과 코드
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDcode() {
		return dcode;
	}
	public void setDcode(String dcode) {
		this.dcode = dcode;
	}
	
	@Override
	public String toString() {
		return "StudentVO [sno=" + sno + ", sname=" + sname + ", dcode=" + dcode + ", getDname()=" + getDname() + "]";
	}
}
