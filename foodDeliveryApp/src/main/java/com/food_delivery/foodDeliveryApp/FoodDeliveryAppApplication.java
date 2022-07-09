package com.food_delivery.foodDeliveryApp;

//import org.apache.ibatis.type.MappedTypes;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.food_delivery.foodDeliveryApp.Model.food_categories;
//import com.food_delivery.foodDeliveryApp.Model.orders;
//import com.food_delivery.foodDeliveryApp.Model.payment_records;
//import com.food_delivery.foodDeliveryApp.Model.users;

//@MappedTypes({ users.class, orders.class, food_categories.class, payment_records.class })
//@MapperScan("com.food_delivery.foodDeliveryApp.Mapper")
@SpringBootApplication
public class FoodDeliveryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryAppApplication.class, args);
	}

}
