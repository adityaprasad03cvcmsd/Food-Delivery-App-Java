package com.food_delivery.foodDeliveryApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food_delivery.foodDeliveryApp.Mapper.Orders_Mapper;
import com.food_delivery.foodDeliveryApp.Model.orders;
import com.food_delivery.foodDeliveryApp.Service.OrderService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/order")
public class Orders_Controller {
	@Autowired
	private Orders_Mapper order;

//	public Orders_Controller(Orders_Mapper order) {
//		this.order = order;
//	}

	@Autowired
	private OrderService orderInProgress;

	@GetMapping("")
	List<orders> getAllOrder() {
		return order.getAll();
	}

	@GetMapping("/{id}")
	List<orders> getOrder(@PathVariable String id) {
		orders obj = new orders();
		obj.setOrder_id(id);
		return order.getOrder(obj);
	}

	@PostMapping("")
	String addOrder(@RequestBody OrderService obj) {
		orderInProgress.OrderProcessing(obj);
		return "Order Accepted";
	}

	@DeleteMapping("/{id}")
	String deleteOrder(@PathVariable String id) {
		order.deleteOrder(id);
		return "Order Deleted";
	}
}
