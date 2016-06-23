package entity;

import java.util.HashSet;
import java.util.Set;

public class Project {
	private int proid;
	private String proname;
	private Set<Employee> employees = new HashSet<Employee>();

	public Project() {
	}

	public Project(int proid, String proname) {
		super();
		this.proid = proid;
		this.proname = proname;
	}

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
