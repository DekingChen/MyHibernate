package entity;


public class Student {
	private int sid;
	private String sname;
	private String sex;
	//private Set<Course> courses = new HashSet<Course>();
	private Class classes;
	public Student(){}
	public Student( String sname, String sex) {
		super();
		this.sname = sname;
		this.sex = sex;
	}
	
	public Class getClasses() {
		return classes;
	}
	public void setClasses(Class classes) {
		this.classes = classes;
	}
	/*public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}*/
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sex=" + sex
				+ "]";
	}
	
}
