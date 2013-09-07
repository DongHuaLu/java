package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="grade")
public class Grade {
	private Course course;
	private int Grade;
	private int id;
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="cid")
	public Course getCourse() {
		return course;
	}
	public int getGrade() {
		return Grade;
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name="sid")
	public Student getStudent() {
		return student;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
