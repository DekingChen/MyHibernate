package entity;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private int cid;
	private String cname;
	private Set<Student> students = new HashSet<Student>();
	public Course(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Course(){}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
