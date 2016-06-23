package entity.shop;

import java.util.HashSet;
import java.util.Set;

public class Seller {
	private Long id;// 主键
	private String name;// 名称
	private String tel;// 电话
	private String address;// 地址
	private String website;// 网站
	private Integer star;// 星级
	private String business;// 经营范围
	private Set<Commodity> commodities = new HashSet<Commodity>();

	public Seller() {

	}

	public Seller(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	public Set<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(Set<Commodity> commodities) {
		this.commodities = commodities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public Seller(Long id, String name, String tel, String address,
			String website, Integer star, String business) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.website = website;
		this.star = star;
		this.business = business;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", tel=" + tel
				+ ", address=" + address + ", website=" + website + ", star="
				+ star + ", business=" + business + "]";
	}
	

}
