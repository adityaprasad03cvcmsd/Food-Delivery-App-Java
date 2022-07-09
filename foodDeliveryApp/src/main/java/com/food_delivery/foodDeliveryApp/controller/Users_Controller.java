package com.food_delivery.foodDeliveryApp.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food_delivery.foodDeliveryApp.Mapper.Users_Mapper;
import com.food_delivery.foodDeliveryApp.Model.users;

@RestController
@EnableAutoConfiguration
@RequestMapping("/users")
public class Users_Controller {
	private Users_Mapper user;

	public Users_Controller(Users_Mapper user) {
		this.user = user;
	}

	@GetMapping("")
	List<users> getallUsers() {
		return user.findAll();
	}

	@GetMapping("/{id}")
	List<users> getUser(@PathVariable String id) {
		return user.findUser(id);
	}

	@PostMapping("/signup")
	List<users> addUser(@RequestBody users obj) {
		UUID uuid = UUID.randomUUID();

		obj.setUser_id(uuid.toString());

		String newPassword = UUID.nameUUIDFromBytes(String.valueOf(obj.getPassword()).getBytes()).toString();
		obj.setPassword(newPassword);

		user.addUser(obj);

		return user.findUser(uuid.toString());
	}

	@PostMapping("/login")
	String Login(@RequestBody users obj) {
		String checkPassword = user.findMobile(obj);
		String newPassword = UUID.nameUUIDFromBytes(String.valueOf(obj.getPassword()).getBytes()).toString();

		if (newPassword.equals(checkPassword)) {
			return "Login Successfull";
		} else
			return "Invalid User Credentials";
	}

	@PutMapping("/updatepassword/{id}")
	List<users> updatePassword(@PathVariable String id, @RequestBody users obj) {
		obj.setUser_id(id);
		String newPassword = UUID.nameUUIDFromBytes(String.valueOf(obj.getPassword()).getBytes()).toString();
		obj.setPassword(newPassword);
		
		user.updateUserPassword(obj);

		return user.findUser(id);
	}

	@PutMapping("/updateemail/{id}")
	List<users> updateEmail(@PathVariable String id, @RequestBody users obj) {
		obj.setUser_id(id);
		user.updateUserEmail(obj);

		return user.findUser(id);
	}

	@DeleteMapping("/{id}")
	String DeleteUser(@PathVariable String id) {
		user.deleteUser(id);
		return "user deleted";
	}
}
