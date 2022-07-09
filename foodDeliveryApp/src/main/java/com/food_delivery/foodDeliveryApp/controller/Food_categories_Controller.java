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
import org.springframework.web.bind.annotation.RestController;

import com.food_delivery.foodDeliveryApp.Mapper.Food_categories_Mapper;
import com.food_delivery.foodDeliveryApp.Model.food_categories;

@RestController
@EnableAutoConfiguration

public class Food_categories_Controller {
	private Food_categories_Mapper food;

	public Food_categories_Controller(Food_categories_Mapper food) {
		this.food = food;
	}

	@GetMapping("/")
	List<food_categories> getAll() {
		return food.findAll();
	}

	@GetMapping("/{id}")
	List<food_categories> getFood(@PathVariable String id) {
		return food.findFood(id);
	}
	
	@PostMapping("/")
	List<food_categories> addFood(@RequestBody food_categories obj){
		UUID uuid=UUID.randomUUID();
		obj.setFood_id(uuid.toString());
		
		food.addFood(obj);
		return food.findFood(obj.getFood_id());
	}
	
	@PutMapping("/{id}")
	List<food_categories> updateFoodPrice(@PathVariable String id,@RequestBody food_categories obj){
		food.updateFoodPrice(id, obj);
		return food.findFood(id);
	}
	
	@PutMapping("/updatefood/{id}")
	List<food_categories> updateFood(@PathVariable String id, @RequestBody food_categories obj){
		food.updateFood(id, obj);
		return food.findFood(id);
	}
	
	@DeleteMapping("/{id}")
	String DeleteFood(@PathVariable String id) {
		food.deleteFood(id);
		return "Food DEleted";
	}
}
