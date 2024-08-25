package com.giri.micro1.Loyalty.service;

import java.util.List;

import com.giri.micro1.Loyalty.model.FoodItemOrder;



public interface FoodOrderService {
	
	public boolean insertOrder(FoodItemOrder order);
	public boolean updateOrder(FoodItemOrder order);
	public List<FoodItemOrder> findAllOrder();	
	boolean deleteOrder(Long orderId);
	FoodItemOrder findOrderById(Long orderId);
	
	//private void sendOrderConfirmationEmail(FoodItemOrder foodItemOrder);

}
