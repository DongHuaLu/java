package domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Student {
	private Set<Course> courses = new HashSet<Course>();
	private Set<Grade> grades = new HashSet<Grade>();
	@OneToMany(mappedBy="student")
	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	private int id;
	private String name;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "grade", joinColumns = { @JoinColumn(name = "sid") }, inverseJoinColumns = { @JoinColumn(name = "cid") })
	public Set<Course> getCourses() {
		return courses;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
