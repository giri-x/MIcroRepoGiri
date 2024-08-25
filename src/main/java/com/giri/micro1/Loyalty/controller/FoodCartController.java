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

import com.giri.micro1.Loyalty.model.FoodItemCart;
import com.giri.micro1.Loyalty.service.FoodCartService;

@RestController
@CrossOrigin("*")
@RequestMapping("/foodCart")
public class FoodCartController {
	
	@Autowired
	FoodCartService service;
	
//	@PostMapping("/addFoodCart")
//	public ResponseEntity<String> insertCart(@RequestBody FoodItemCart cart) {
//
//		System.out.println(service.validateCart(cart));
//		if (service.validateCart(cart)) {
//
//			return ResponseEntity.badRequest().body("item already added");
//
//		} else {
//			service.insertCart(cart);
//			return ResponseEntity.ok("added");
//
//		}
//
//	}
	
	  @PostMapping("/addFoodCart")
	    public ResponseEntity<String> insertCart(@RequestBody FoodItemCart cart) {
	        try {
	            // Validate if the item is already in the cart
	            if (service.validateCart(cart)) {
	                return ResponseEntity.badRequest().body("Item already added");
	            } else {
	                // Add new item to the cart
	                service.insertCart(cart);
	                return ResponseEntity.ok("Item added successfully");
	            }
	        } catch (Exception e) {
	            // Handle exceptions and return a 500 status code
	            return ResponseEntity.status(500).body("An error occurred while adding the item");
	        }
	    }

	@GetMapping("/findAllCart")
	public List<FoodItemCart> findAllCart() {
		return service.findAllCart();
	}
	
	@DeleteMapping("/deleteCart/{cartId}")
	public ResponseEntity<String> deleteCart(@PathVariable("cartId") Long cartId) {
		try {
			service.deleteCart(cartId);
			return ResponseEntity.ok("Deletion Success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Deletion Failure");
		}
	}
	

}
