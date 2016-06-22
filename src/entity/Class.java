package entity;

import java.util.HashSet;
import java.util.Set;

public class Class {
	private int cid;
	private String cname;
	private String cdesc;
	private Set<Student> students = new HashSet<Student>();

	public Class() {
	}

	public Class( String cname, String cdesc) {
		this.cname = cname;
		this.cdesc = cdesc;
	}

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

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Class [cid=" + cid + ", cname=" + cname + ", cdesc=" + cdesc
				+ "]";
	}

}
