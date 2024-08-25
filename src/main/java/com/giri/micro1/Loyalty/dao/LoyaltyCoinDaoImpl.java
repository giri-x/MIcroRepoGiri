package com.giri.micro1.Loyalty.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giri.micro1.Loyalty.model.LoyaltyCoins;

import jakarta.persistence.EntityManager;


@Repository
public class LoyaltyCoinDaoImpl implements LoyaltyCoinDao {
	
	@Autowired
	private EntityManager entity;

	@Override
	public String updateCoin(LoyaltyCoins coin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCoin(Long coinId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoyaltyCoins> listAllCoin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCoin(LoyaltyCoins coin) {
		// TODO Auto-generated method stub

	}

}
