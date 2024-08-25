package com.giri.micro1.Loyalty.dao;

import java.util.List;

import com.giri.micro1.Loyalty.model.FoodItemCart;

public interface FoodCartDao {
//	public boolean validateCart(FoodItemCart cart);
//	public FoodItemCart findCartById(Long cartId);
//	public String updateCart(FoodItemCart cart);
//	public String deleteOrder(Long cartId);
//	public List<FoodItemCart> listAllCart();
//	public void insertCart(FoodItemCart cart);
	
	  boolean validateCart(FoodItemCart cart);
	    FoodItemCart findCartById(Long cartId);
	    String updateCart(FoodItemCart cart);
	    String deleteOrder(Long cartId);
	    List<FoodItemCart> listAllCart();
	    void insertCart(FoodItemCart cart);
	

}
