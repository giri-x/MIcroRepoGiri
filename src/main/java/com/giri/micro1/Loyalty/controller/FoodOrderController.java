package com.giri.micro1.Loyalty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giri.micro1.Loyalty.model.FoodItemOrder;
import com.giri.micro1.Loyalty.service.FoodOrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/FoodOrder")
public class FoodOrderController {
	
	@Autowired
	FoodOrderService service;
	
	@PostMapping("/insertFoodOrder")
	public ResponseEntity<String> insertorder(@RequestBody FoodItemOrder order) {
		try{
			service.insertOrder(order);
			return ResponseEntity.ok("order inserted successfully");
		}catch(Exception e){
			return ResponseEntity.badRequest().body("Insertion Failure");
		}
		
	}
	
	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable("productId")Long orderId){
		try {
			service.deleteOrder(orderId);
			return ResponseEntity.ok("Deletion Success");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Deletion Failure");
		}
	}
	
	@GetMapping("/findOrderById/{orderId}")
	public FoodItemOrder findByFoodsOrder(@PathVariable("orderId")Long orderId) {
		return service.findOrderById(orderId);
	}
	
	@GetMapping("/findAllOrder")
	public List<FoodItemOrder> findAllOrders() {
		return service.findAllOrder();
	}
//	
//	  @PostMapping
//	    public ResponseEntity<String> createFoodItemOrder(@RequestBody FoodItemOrder foodItemOrder) {
//	        service.createFoodItemOrder(foodItemOrder);
//	        return ResponseEntity.ok("Food item order placed successfully.");
//	    }
//	 
//	    @GetMapping("/{id}")
//	    public ResponseEntity<FoodItemOrder> getFoodItemOrderById(@PathVariable Long id) {
//	        FoodItemOrder order = foodItemOrderService.getFoodItemOrderById(id);
//	        if (order != null) {
//	            return ResponseEntity.ok(order);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
//	 
//	    @GetMapping
//	    public ResponseEntity<List<FoodItemOrder>> getAllFoodItemOrders() {
//	        List<FoodItemOrder> orders = foodItemOrderService.getAllFoodItemOrders();
//	        return ResponseEntity.ok(orders);
//	    }

	
	

}
