package com.food_delivery.foodDeliveryApp.Mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.food_delivery.foodDeliveryApp.Model.payment_records;
import com.food_delivery.foodDeliveryApp.Utils.foodDeliveryAppUtils;

@Repository
public class Payment_records_Mapper {

	public List<payment_records> getAllPayment() {
		SqlSession session = foodDeliveryAppUtils.getSqlSessionFactory().openSession();

		List<payment_records> pay = session.selectList("getAllPayment");
		session.commit();
		session.close();
		return pay;
	}

	public List<payment_records> getPaymentOfUser(String id) {
		HashMap<String, String> user = new HashMap<>();
		user.put("user_id", id);

		SqlSession session = foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		List<payment_records> payment = session.selectList("getPaymentOfUser", user);
		session.commit();
		session.close();
		return payment;
	}

	public List<payment_records> getPayment(String id) {
		HashMap<String, String> payment = new HashMap<>();
		payment.put("payment_id", id);

		SqlSession session = foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		List<payment_records> pay = session.selectList("getPayment", payment);
		session.commit();
		session.close();
		return pay;
	}

	public List<payment_records> getPaymentByOrder(String id) {
		HashMap<String, String> order = new HashMap<>();
		order.put("order_id", id);

		SqlSession session = foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		List<payment_records> pay = session.selectList("getPaymentOfOrder", order);
		session.commit();
		session.close();
		return pay;
	}
	
	public void addPayment(payment_records obj) {
		SqlSession session=foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		session.insert("addPayment", obj);
		session.commit();
		session.close();
	}
}
