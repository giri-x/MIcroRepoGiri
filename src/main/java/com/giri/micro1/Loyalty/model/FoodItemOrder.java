package com.giri.micro1.Loyalty.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FoodOrder_table")
public class FoodItemOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private AdminProduct adminProduct;
	
	@Column(name = "order_date")
	private String orderDate;
	
	private String userName;
	private String buildingName;
	private String colonyName;
	private String cityName;
	private String stateName;
	private Long contactNumber;
	private Long emailId;
	
	public Long getEmailId() {
		return emailId;
	}
	public void setEmailId(Long emailId) {
		this.emailId = emailId;
	}
	public FoodItemOrder(Long orderId, User user, AdminProduct adminProduct, String orderDate, String userName,
			String buildingName, String colonyName, String cityName, String stateName, Long contactNumber, Long emailId,
			Long cardNum, int exp, int cvv) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.adminProduct = adminProduct;
		this.orderDate = orderDate;
		this.userName = userName;
		this.buildingName = buildingName;
		this.colonyName = colonyName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.cardNum = cardNum;
		this.exp = exp;
		this.cvv = cvv;
	}
	private Long cardNum;
	private int exp;
	private int cvv;
	public FoodItemOrder() {
		super();
		
	}
	public FoodItemOrder(Long orderId, User user, AdminProduct adminProduct, String orderDate, String userName,
			String buildingName, String colonyName, String cityName, String stateName, Long contactNumber, Long cardNum,
			int exp, int cvv) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.adminProduct = adminProduct;
		this.orderDate = orderDate;
		this.userName = userName;
		this.buildingName = buildingName;
		this.colonyName = colonyName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.contactNumber = contactNumber;
		this.cardNum = cardNum;
		this.exp = exp;
		this.cvv = cvv;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getColonyName() {
		return colonyName;
	}
	public void setColonyName(String colonyName) {
		this.colonyName = colonyName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Long getCardNum() {
		return cardNum;
	}
	public void setCardNum(Long cardNum) {
		this.cardNum = cardNum;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "FoodItemOrder [orderId=" + orderId + ", user=" + user + ", adminProduct=" + adminProduct
				+ ", orderDate=" + orderDate + ", userName=" + userName + ", buildingName=" + buildingName
				+ ", colonyName=" + colonyName + ", cityName=" + cityName + ", stateName=" + stateName
				+ ", contactNumber=" + contactNumber + ", cardNum=" + cardNum + ", exp=" + exp + ", cvv=" + cvv + "]";
	}
	
	
	
	
	
	

}
