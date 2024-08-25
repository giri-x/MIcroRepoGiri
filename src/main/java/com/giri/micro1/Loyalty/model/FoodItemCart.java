package com.giri.micro1.Loyalty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FoodCart_tbl")
public class FoodItemCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CartId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private AdminProduct adminProduct;
	
	private int totalPrice;
	
	private double cartprice;
	private double points;
	
	private int quantity;

	public FoodItemCart() {
		super();
		
	}

	public FoodItemCart(int cartId, User user, AdminProduct adminProduct, int totalPrice, double cartprice,
			double points, int quantity) {
		super();
		CartId = cartId;
		this.user = user;
		this.adminProduct = adminProduct;
		this.totalPrice = totalPrice;
		this.cartprice = cartprice;
		this.points = points;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "FoodItemCart [CartId=" + CartId + ", user=" + user + ", adminProduct=" + adminProduct + ", totalPrice="
				+ totalPrice + ", cartprice=" + cartprice + ", points=" + points + ", quantity=" + quantity + "]";
	}

	public int getCartId() {
		return CartId;
	}

	public void setCartId(int cartId) {
		CartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AdminProduct getAdminProduct() {
		return adminProduct;
	}

	public void setAdminProduct(AdminProduct adminProduct) {
		this.adminProduct = adminProduct;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getCartprice() {
		return cartprice;
	}

	public void setCartprice(double cartprice) {
		this.cartprice = cartprice;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
