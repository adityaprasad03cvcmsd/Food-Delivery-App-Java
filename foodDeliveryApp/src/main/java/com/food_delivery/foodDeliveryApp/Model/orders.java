package com.food_delivery.foodDeliveryApp.Model;

import java.util.List;

//import java.util.List;

public class orders {
	private String order_id;
	private List<food_categories> food_id;
	private users user_id;

	public orders() {

	}

	public orders(String order_id, List<food_categories> food_id, users user_id) {
		super();
		this.order_id = order_id;
		this.food_id = food_id;
		this.user_id = user_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public List<food_categories> getFood_id() {
		return food_id;
	}

	public void setFood_id(List<food_categories> food_id) {
		this.food_id = food_id;
	}

	public users getUser_id() {
		return user_id;
	}

	public void setUser_id(users user_id) {
		this.user_id = user_id;
	}
	
	

}
