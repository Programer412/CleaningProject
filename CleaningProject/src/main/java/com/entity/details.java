package com.entity;

public class details {
	private int id;
	private String name;
	private String email;
	private int houseno;
	private String state;
	private String city;
	private int zipcode;
	private String filename;
	private int userid;
	private String Category;
	private int price;
	private String deliver;
	
	
	
	public String getDeliver() {
		return deliver;
	}

	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public details() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
	this.id= id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "details [id=" + id + ", name=" + name + ", email=" + email + ", houseno=" + houseno + ", state=" + state
				+ ", city=" + city + ", zipcode=" + zipcode + ", filename=" + filename + ", userid=" + userid
				+ ", Category=" + Category + ", price=" + price + ", deliver=" + deliver + "]";
	}







	
	

}
