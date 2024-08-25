package com.giri.micro1.Loyalty.service;

import java.util.List;

import com.giri.micro1.Loyalty.model.FoodItemOrder;
import com.giri.micro1.Loyalty.model.LoyaltyCoins;

public interface LoyaltyCoinService {
	
	public boolean insertCoin(LoyaltyCoins coin);
	public boolean updateCoin(LoyaltyCoins coin);
	public List<LoyaltyCoins> findAllCoins();	
	boolean deleteCoins(Long coinId);

}
