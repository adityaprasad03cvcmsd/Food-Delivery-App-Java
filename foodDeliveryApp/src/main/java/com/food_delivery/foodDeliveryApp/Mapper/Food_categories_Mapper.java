package com.food_delivery.foodDeliveryApp.Mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.food_delivery.foodDeliveryApp.Model.food_categories;
import com.food_delivery.foodDeliveryApp.Utils.foodDeliveryAppUtils;

//@Mapper
//public interface Food_categories_Mapper {
//
//	@Select("SELECT * FROM food_categories")
//	List<food_categories> findAll();
//
//	@Select("SELECT * FROM food_categories WHERE food_id=#{id}")
//	public List<food_categories> findFood(int id);
//
//	@Insert("INSERT INTO food_categories values(#{food_id}, #{category}, #{cat}, #{image}, #{name}, #{price}, #{s_desc}, #{description})")
//	public void addFood(food_categories obj);
//
//	@Update("UPDATE food_categories SET price=#{price} WHERE food_id=#{id}")
//	public void updateFoodPrice(int id, food_categories obj);
//
//	@Update("UPDATE food_categories SET category=#{category}, cat=#{cat}, image=#{image}, name=#{name}, price=#{price}, s_desc=#{desc}, description=#{description} WHERE food_id=#{id}")
//	public void updateFood(int id, food_categories obj);
//
//	@Delete("DELETE FROM food_categories where food_id=#{id}")
//	public void deleteFood(int id);
//}

@Repository
public class Food_categories_Mapper {

	public List<food_categories> findAll() {
		SqlSession session = foodDeliveryAppUtils.getSqlSessionFactory().openSession();

		List<food_categories> foods = session.selectList("getAll");

		session.commit();
		session.close();
		return foods;
	}

	public List<food_categories> findFood(String id) {
		SqlSession session=foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		
		food_categories obj=new food_categories();
		obj.setFood_id(id);
		
		List<food_categories> food= session.selectList("getFood",obj);
		
		session.commit();
		session.close();
		return food;
	}

	public void addFood(food_categories obj) {
		SqlSession session=foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		session.insert("addFood", obj);
		session.commit();
		session.close();
	}

	public void updateFoodPrice(String id, food_categories obj) {
		SqlSession session=foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		
		obj.setFood_id(id);
		session.update("updateFoodPrice", obj);
		session.commit();
		session.close();
	}

	public void updateFood(String id, food_categories obj) {
		SqlSession session=foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		
		obj.setFood_id(id);
		session.update("updateFood", obj);
		session.commit();
		session.close();
	}

	public void deleteFood(String id) {
		SqlSession session=foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		
		food_categories obj=new food_categories();
		obj.setFood_id(id);
		
		session.delete("deleteFood", obj);
		session.commit();
		session.close();
	}
	
	
	
}