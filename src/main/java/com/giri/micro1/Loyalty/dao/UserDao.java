package com.giri.micro1.Loyalty.dao;

import java.util.List;
import java.util.Optional;

import com.giri.micro1.Loyalty.model.User;

public interface UserDao {
	public void addUser(User user);

	public Optional<User> findbyemail(String email);

	public User userLogin(String email, String password);

	public List<User> listAllUser();

	void updateRewardCoins(Long userId, Double rewardCoins);

	void updateTotalAmount(Long userId, Double totalAmount);

//	Optional<User> findById(String email);

	Double getRewardCoins(String email);

	public Optional<User> findById(String email);

	public User custLogin(String email, String password);

}
