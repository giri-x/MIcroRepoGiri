package com.giri.micro1.Loyalty.service;

import java.util.List;
import java.util.Optional;
import com.giri.micro1.Loyalty.model.User;

public interface UserService {
	
	public boolean addUser(User user);

	public Optional<User> findbyemail(String email);

	public Optional<User> UserLogin(String email, String password);
	
	List<User> findAllUser();
	
	 void updateRewardCoins(Long userId, Double rewardCoins);
	 
	 void updateTotalAmount(Long userId, Double totalAmount);
	 
	 Double getRewardCoins(String email);


	public User custLogin(String email, String password);
	 
//	 Optional<User> findById(Long userId);

}
