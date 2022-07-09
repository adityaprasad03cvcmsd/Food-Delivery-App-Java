package com.food_delivery.foodDeliveryApp.Mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.food_delivery.foodDeliveryApp.Model.food_categories;
import com.food_delivery.foodDeliveryApp.Model.orders;
import com.food_delivery.foodDeliveryApp.Service.OrderService;
import com.food_delivery.foodDeliveryApp.Utils.foodDeliveryAppUtils;

//@Mapper
//public interface Orders_Mapper {
//	
//	@Select("SELECT * FROM orders")
//	public List<orders> getAll();
//	
//	@Insert("INSERT INTO orders VALUES(#{order_id}, #{food.food_id}, #{user.user_id})")
//	public void addOrder(orders obj);
//}

@Repository
public class Orders_Mapper {

	public List<orders> getAll() {
		SqlSession session = foodDeliveryAppUtils.getSqlSessionFactory().openSession();

		List<orders> orderList = session.selectList("getAllOrders");

		session.commit();
		session.close();
		return orderList;
	}

	public List<orders> getOrder(orders obj) {
		SqlSession session = foodDeliveryAppUtils.getSqlSessionFactory().openSession();

		List<orders> order = session.selectList("getOrder", obj);
		session.commit();
		session.close();
		return order;
	}

	public float addOrder(String order_id, OrderService req) {
		SqlSession session = foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		float sum = 0;
		
		for (food_categories i : req.getFoodList()) {
			
			HashMap<String,String> obj= new HashMap<>();
			obj.put("order_id", order_id);
			obj.put("user_id", req.getUser_id());
			obj.put("food_id",i.getFood_id());
			
			sum += i.getPrice();

			session.insert("addOrder", obj);
		}

		session.commit();
		session.close();
		return sum;
	}

	public void deleteOrder(String id) {
		SqlSession session = foodDeliveryAppUtils.getSqlSessionFactory().openSession();

		orders obj = new orders();
		obj.setOrder_id(id);

		session.delete("deleteOrder", obj);
		session.commit();
		session.close();

	}

}