package com.entity;

public class regist {
private int id;
	private String name;
	private String email;
	private String password;
	private String cpassword;
	
	public regist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	@Override
	public String toString() {
		return "regist [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpassword="
				+ cpassword + "]";
	}
	
	
	
}