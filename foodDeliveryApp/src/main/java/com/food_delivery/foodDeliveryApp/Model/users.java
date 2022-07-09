package com.food_delivery.foodDeliveryApp.Model;

public class users {
	private String user_id;
	private String full_name;
	private String mobile_number;
	private String email;
	private String password;

	public users() {

	}

	public users(String user_id, String full_name, String mobile_number, String email, String password) {
		super();
		this.user_id = user_id;
		this.full_name = full_name;
		this.mobile_number = mobile_number;
		this.email = email;
		this.password = password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
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

}
