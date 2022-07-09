package com.food_delivery.foodDeliveryApp.Model;

public class payment_records {
	private String payment_id;
	private String order_id;
	private String user_id;
	private float total_price;
	private String coupoun;
	private float discount;
	private float price_paid;

	public payment_records() {

	}

	public payment_records(String payment_id, String order_id, String user_id, float total_price, String coupoun,
			float discount, float price_paid) {
		super();
		this.payment_id = payment_id;
		this.order_id = order_id;
		this.user_id = user_id;
		this.total_price = total_price;
		this.coupoun = coupoun;
		this.discount = discount;
		this.price_paid = price_paid;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public String getCoupoun() {
		return coupoun;
	}

	public void setCoupoun(String coupoun) {
		this.coupoun = coupoun;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getPrice_paid() {
		return price_paid;
	}

	public void setPrice_paid(float price_paid) {
		this.price_paid = price_paid;
	}

}
