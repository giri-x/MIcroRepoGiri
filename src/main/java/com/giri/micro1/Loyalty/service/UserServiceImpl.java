package com.giri.micro1.Loyalty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.micro1.Loyalty.dao.UserDao;
import com.giri.micro1.Loyalty.model.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;

	@Override
	public boolean addUser(User user) {
		dao.addUser(user);
		return true;
	}

	@Override
	public Optional<User> findbyemail(String email) {
		return this.dao.findbyemail(email);
	}

	@Override
	public Optional<User> UserLogin(String email, String password) {
		return dao.findbyemail(email);
	}

	@Override
	public List<User> findAllUser() {
		return this.dao.listAllUser();
	}
	
	  @Override
	    public void updateRewardCoins(Long userId, Double rewardCoins) {
	        dao.updateRewardCoins(userId, rewardCoins);
	    }
	  
	   @Override
	    public void updateTotalAmount(Long userId, Double totalAmount) {
	        dao.updateTotalAmount(userId, totalAmount);
	    }
	   
//	   @Override
//	    public Double getRewardCoins(String email) {
//	        // Assuming you have a User entity with a rewardCoins field
//	        User user = dao.findById(email).orElse(null);
//	        if (user != null) {
//	            return user.getRewardCoins();
//	        } else {
//	            return null;
//	        }
//	    }
	   

//	   public Double getRewardCoins(String email) {
//	        User user = dao.findById(email).orElse(null);
//	        if (user != null) {
//	            return user.getRewardCoins();
//	        } else {
//	            return null;
//	        }
//	    }
	   
//	    @Override
//	    public Optional<User> findById(Long userId) {
//	        return dao.findById(userId);
//	    }
	   
	   @Override
	    public Double getRewardCoins(String email) {
	        return dao.getRewardCoins(email);
	    }

	@Override
	public User custLogin(String email, String password) {
		return dao.custLogin(email, password);
	
	}
}
