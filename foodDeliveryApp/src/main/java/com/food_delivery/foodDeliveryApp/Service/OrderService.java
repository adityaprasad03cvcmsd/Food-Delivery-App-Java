package com.food_delivery.foodDeliveryApp.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food_delivery.foodDeliveryApp.Mapper.Orders_Mapper;
import com.food_delivery.foodDeliveryApp.Mapper.Payment_records_Mapper;
import com.food_delivery.foodDeliveryApp.Model.food_categories;
//import com.food_delivery.foodDeliveryApp.Model.orders;
import com.food_delivery.foodDeliveryApp.Model.payment_records;
//import com.food_delivery.foodDeliveryApp.Model.users;

@Service
public class OrderService {
	private String user_id;
	private List<food_categories> foodList;
	private float price_paid;
	private String coupoun;

	@Autowired
	private Orders_Mapper order;

	@Autowired
	private Payment_records_Mapper payment;

	public OrderService() {

	}

	public OrderService(String user_id, List<food_categories> foodList) {
		super();
		this.user_id = user_id;
		this.foodList = foodList;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public List<food_categories> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<food_categories> foodList) {
		this.foodList = foodList;
	}

	public float getPrice_paid() {
		return price_paid;
	}

	public void setPrice_paid(float price_paid) {
		this.price_paid = price_paid;
	}

	public String getCoupoun() {
		return coupoun;
	}

	public void setCoupoun(String coupoun) {
		this.coupoun = coupoun;
	}

	public void OrderProcessing(OrderService obj) {
		UUID uuid = UUID.randomUUID();

		float sum = order.addOrder(uuid.toString(), obj);

		UUID uuidPayment = UUID.randomUUID();
		payment_records pay = new payment_records();

		pay.setPayment_id(uuidPayment.toString());
		pay.setOrder_id(uuid.toString());
		pay.setUser_id(obj.getUser_id());
		pay.setTotal_price(sum);
		pay.setPrice_paid(obj.getPrice_paid());
		pay.setDiscount(sum - obj.getPrice_paid());
		pay.setCoupoun(obj.getCoupoun());

		payment.addPayment(pay);
	}
}
