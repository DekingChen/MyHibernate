package entity;

import java.util.Date;

public class User {
	private int uid;
	private String uname;
	private String sex;
	private Address address;
	private Date birthday;

	public User() {
	}

	public User(int uid, String uname, String sex, Date birthday) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.sex = sex;
		this.birthday = birthday;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
