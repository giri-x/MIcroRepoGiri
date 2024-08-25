package com.giri.micro1.Loyalty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.giri.micro1.Loyalty.dao.FoodOrderDao;
import com.giri.micro1.Loyalty.model.FoodItemOrder;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FoodOrderServiceImpl implements FoodOrderService {
	
	@Autowired
	FoodOrderDao dao;
	
//	  @Autowired
//	  private JavaMailSender mailSender;

	@Override
	public boolean insertOrder(FoodItemOrder order) {
		this.dao.addOrder(order);
		   return true;
	}

	@Override
	public boolean updateOrder(FoodItemOrder order) {
		dao.updateOrder(order);
		return true;
	}

	@Override
	public List<FoodItemOrder> findAllOrder() {
		return this.dao.listAllOrder();	}

	@Override
	public boolean deleteOrder(Long orderId) {
		dao.deleteOrder(orderId);
		return true;
	}

	@Override
	public FoodItemOrder findOrderById(Long orderId) {
		return dao.findOrderById(orderId);
	}
	
//	private void sendOrderConfirmationEmail(FoodItemOrder foodItemOrder) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(String.valueOf(foodItemOrder.getEmailId())); // Ensure the email ID is in proper format
//        message.setSubject("Food Order Confirmation");
//        message.setText("Your food order has been placed successfully.\nOrder Details:\n" +
//                        "Order ID: " + foodItemOrder.getOrderId() + "\n" +
//                        "Product ID: " + foodItemOrder.getAdminProduct().getProductId() + "\n" +
//                        "Order Date: " + foodItemOrder.getOrderDate() + "\n" +
//                        "User Name: " + foodItemOrder.getUserName() + "\n" +
//                        "Address: " + foodItemOrder.getBuildingName() + ", " + foodItemOrder.getColonyName() + ", " + foodItemOrder.getCityName() + ", " + foodItemOrder.getStateName() + "\n" +
//                        "Contact: " + foodItemOrder.getContactNumber() + "\n" +
//                        "Card Number: " + foodItemOrder.getCardNum() + "\n" +
//                        "Expiry: " + foodItemOrder.getExp() + "\n" +
//                        "CVV: " + foodItemOrder.getCvv());
//        mailSender.send(message);
//    }

}
