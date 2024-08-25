package com.giri.micro1.Loyalty.service;

import java.util.List;
import com.giri.micro1.Loyalty.model.FoodItemCart;

public interface FoodCartService {
	
//	public boolean validateCart(FoodItemCart details);
//
//	public boolean updateSeeds(FoodItemCart details);
//
//	boolean deleteCart(Long cartId);
//
//	FoodItemCart findCartById(Long cartId);
//
//	List<FoodItemCart> findAllCart();
//	
//	public void insertCart(FoodItemCart cart);

	 boolean validateCart(FoodItemCart details);
	    boolean updateCart(FoodItemCart details);
	    boolean deleteCart(Long cartId);
	    FoodItemCart findCartById(Long cartId);
	    List<FoodItemCart> findAllCart();
	    void insertCart(FoodItemCart cart);
}
