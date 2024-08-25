package com.giri.micro1.Loyalty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.micro1.Loyalty.dao.FoodCartDao;
import com.giri.micro1.Loyalty.dao.FoodCartDaoImpl;
import com.giri.micro1.Loyalty.model.FoodItemCart;

import jakarta.transaction.Transactional;
//
//@Service
//@Transactional
//public class FoodCartServiceImpl implements FoodCartService {
//	
//	@Autowired
//	FoodCartDaoImpl dao;
//
//	@Override
//	public boolean validateCart(FoodItemCart details) {
//		return dao.validateCart(details);
//	}
//
//	@Override
//	public boolean updateSeeds(FoodItemCart details) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean deleteCart(Long cartId) {
//		dao.deleteOrder(cartId);
//		return true;
//	}
//
//	@Override
//	public FoodItemCart findCartById(Long cartId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<FoodItemCart> findAllCart() {
//		return this.dao.listAllCart();
//	}
//
//	@Override
//	public void insertCart(FoodItemCart cart) {
//		dao.insertCart(cart);
//		
//	}
//	
//	
//
//}

@Service
@Transactional
public class FoodCartServiceImpl implements FoodCartService {
    
    @Autowired
    private FoodCartDao dao;

    @Override
    public boolean validateCart(FoodItemCart details) {
        return dao.validateCart(details);
    }

    @Override
    public boolean updateCart(FoodItemCart details) {
        String result = dao.updateCart(details);
        return "Update Success".equals(result);
    }

    @Override
    public boolean deleteCart(Long cartId) {
        String result = dao.deleteOrder(cartId);
        return "Deletion Success".equals(result);
    }

    @Override
    public FoodItemCart findCartById(Long cartId) {
        return dao.findCartById(cartId);
    }

    @Override
    public List<FoodItemCart> findAllCart() {
        return dao.listAllCart();
    }

    @Override
    public void insertCart(FoodItemCart cart) {
        dao.insertCart(cart);
    }
}
