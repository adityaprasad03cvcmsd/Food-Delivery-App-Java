package com.food_delivery.foodDeliveryApp.Mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.food_delivery.foodDeliveryApp.Model.users;
import com.food_delivery.foodDeliveryApp.Utils.foodDeliveryAppUtils;


//@Mapper
//public interface Users_Mapper {
//	
//	@Select("SELECT * FROM users")
//	public List<users> findAll();
//	
//	@Select("SELECT * FROM users WHERE user_id=#{id}")
//	public List<users> findUser(String id);
//	
//	@Insert("INSERT INTO users(user_id, full_name, mobile_number, email, password) VALUES(#{user_id}, #{full_name}, #{mobile_number}, #{email}, #{password})")
//	public void addUser(users obj);
//	
//	@Update("UPDATE users SET password=#{password} WHERE user_id=#{id}")
//	public void updateUserPassword(String id, users obj);
//	
//	@Update("UPDATE users SET email=#{email} WHERE user_id=#{id}")
//	public void updateUserEmail(String id, users obj);
//	
//	@Select("SELECT password FROM users WHERE mobile_number=#{mobile_number}")
//	public String findMobile(users obj);
//	
//	@Delete("DELETE FROM users where user_id=#{id}")
//	public void deleteUser(String id);
//}

@Repository
public class Users_Mapper {
	public List<users> findAll() {
		SqlSession session = foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		List<users> userList = session.selectList("getAllUsers");
		session.commit();
		session.close();
		return userList;
	}

	public List<users> findUser(String id) {
		SqlSession session = foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		
		users obj= new users();
		obj.setUser_id(id);
		
		List<users> user = session.selectList("getUser",obj);
		session.commit();
		session.close();
		return user;
	}

	public void addUser(users obj) {
		SqlSession session=foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		session.insert("addUser", obj);
		session.commit();
		session.close();
	}

	public String findMobile(users obj) {
		SqlSession session=foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		users user= session.selectOne("findMobile",obj.getMobile_number());
		session.commit();
		session.close();
		return user.getPassword();
	}

	public void updateUserPassword(users obj) {
		SqlSession session=foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		session.update("updateUserPassword", obj);
		session.commit();
		session.close();
	}

	public void updateUserEmail(users obj) {
		SqlSession session=foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		session.update("updateUserEmail", obj);
		session.commit();
		session.close();
	}

	public void deleteUser(String id) {
		SqlSession session=foodDeliveryAppUtils.getSqlSessionFactory().openSession();
		
		users user=new users();
		user.setUser_id(id);
		
		session.delete("deleteUser", user);
	}
	
	

}