package pojo;

public class Marks {
	
	private String examNo;
	private String stuNo;
	private int writtenExam;
	private int labExam;
	private Student student;
	

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getExamNo() {
		return examNo;
	}
	public void setExamNo(String examNo) {
		this.examNo = examNo;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public int getWrittenExam() {
		return writtenExam;
	}
	public void setWrittenExam(int writtenExam) {
		this.writtenExam = writtenExam;
	}
	public int getLabExam() {
		return labExam;
	}
	public void setLabExam(int labExam) {
		this.labExam = labExam;
	}


}
