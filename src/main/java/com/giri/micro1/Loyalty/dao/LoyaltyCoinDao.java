package com.giri.micro1.Loyalty.dao;

import java.util.List;

import com.giri.micro1.Loyalty.model.FoodItemCart;
import com.giri.micro1.Loyalty.model.LoyaltyCoins;

public interface LoyaltyCoinDao {
	
	public String updateCoin(LoyaltyCoins coin);
	public String deleteCoin(Long coinId);
	public List<LoyaltyCoins> listAllCoin();
	public void insertCoin(LoyaltyCoins coin);

}
