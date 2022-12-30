package ex16;

public class ScoreVO extends TypeVO{
	private String sno; //학번
	private String tcode; //시험유형
	private int grade;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getTcode() {
		return tcode;
	}
	public void setTcode(String tcode) {
		this.tcode = tcode;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "ScoreVO [sno=" + sno + ", tcode=" + tcode + ", grade=" + grade + ", getTname()=" + getTname()
				+ ", getTdate()=" + getTdate() + "]";
	}
}
