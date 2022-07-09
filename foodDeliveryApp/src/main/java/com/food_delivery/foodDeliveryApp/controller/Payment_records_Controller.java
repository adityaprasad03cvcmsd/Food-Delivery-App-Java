package com.food_delivery.foodDeliveryApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food_delivery.foodDeliveryApp.Mapper.Payment_records_Mapper;
import com.food_delivery.foodDeliveryApp.Model.payment_records;

@RestController
@EnableAutoConfiguration
@RequestMapping("/payment")
public class Payment_records_Controller {
	
	@Autowired
	private Payment_records_Mapper payment;
	
	@GetMapping("")
	List<payment_records> getAll(){
		return payment.getAllPayment();
	}
	
	@GetMapping("/user/{id}")
	List<payment_records> getPaymentUser(@PathVariable String id){
		return payment.getPaymentOfUser(id);
	}
	
	@GetMapping("/{id}")
	List<payment_records> getPayment(@PathVariable String id){
		return payment.getPayment(id);
	}
	
	@GetMapping("/order/{id}")
	List<payment_records> getPaymentOfOrder(@PathVariable String id){
		return payment.getPaymentByOrder(id);
	}
}
