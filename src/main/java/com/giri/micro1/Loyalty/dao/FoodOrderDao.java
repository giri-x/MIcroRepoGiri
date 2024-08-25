package com.giri.micro1.Loyalty.dao;

import java.util.List;
import com.giri.micro1.Loyalty.model.FoodItemOrder;

public interface FoodOrderDao {
	
	public String addOrder(FoodItemOrder order);
	public FoodItemOrder findOrderById(Long orderId);
	public String updateOrder(FoodItemOrder order);
	public String deleteOrder(Long productId);
	public List<FoodItemOrder> listAllOrder();

}
