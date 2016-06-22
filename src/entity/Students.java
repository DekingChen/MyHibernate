/**
 * 
 */
package entity;

import java.sql.Blob;
import java.util.Date;

/**
 * @author Administrator
 * 
 */
public class Students {
	private int sid;
	private String sname;
	private String sex;
	private String address;
	private Date birthday;
	private Blob picture;

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public Students() {
	}

	public Students(int sid, String sname, String sex, String address,
			Date birthday) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.address = address;
		this.birthday = birthday;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", sex=" + sex
				+ ", address=" + address + ", birthday=" + birthday + "]";
	}

}
