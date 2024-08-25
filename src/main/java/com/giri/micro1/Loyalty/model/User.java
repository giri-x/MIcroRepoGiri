package com.giri.micro1.Loyalty.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_tbl")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String userName;
	
	@Column(unique = true)
	private String email;
	
	private String phoneNo;
	
	private String password;
	
	private Double rewardCoins;
	
	private Double totalAmount;
	
	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public User(Long userId, String userName, String email, String phoneNo, String password, Double rewardCoins,
			Double totalAmount, List<UserProduct> userProduct) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
		this.rewardCoins = rewardCoins;
		this.totalAmount = totalAmount;
		this.userProduct = userProduct;
	}

	@OneToMany(mappedBy = "user")
	private List<UserProduct>userProduct;

	public Double getRewardCoins() {
		return rewardCoins;
	}

	public void setRewardCoins(Double rewardCoins) {
		this.rewardCoins = rewardCoins;
	}

	public User(Long userId, String userName, String email, String phoneNo, String password, Double rewardCoins,
			List<UserProduct> userProduct) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
		this.rewardCoins = rewardCoins;
		this.userProduct = userProduct;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String userName, String email, String phoneNo, String password,
			List<UserProduct> userProduct) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
		this.userProduct = userProduct;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserProduct> getUserProduct() {
		return userProduct;
	}

	public void setUserProduct(List<UserProduct> userProduct) {
		this.userProduct = userProduct;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", password=" + password + ", rewardCoins=" + rewardCoins + ", userProduct=" + userProduct + "]";
	}
	
	
	

}
