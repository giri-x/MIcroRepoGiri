package com.giri.micro1.Loyalty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LoyaltyCoins_table" )
public class LoyaltyCoins {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private double coinId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

}
