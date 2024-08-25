package com.giri.micro1.Loyalty.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.giri.micro1.Loyalty.model.FoodItemOrder;

import jakarta.persistence.EntityManager;

@Repository
public class FoodOrderDaoImpl implements FoodOrderDao {
	
	@Autowired
	private EntityManager entity;

	@Override
	public String addOrder(FoodItemOrder order) {
		String msg="";
		try {
		entity.persist(order);
		return msg="Inserted Success";
		}catch(Exception e) {
			return msg="Inserted failure";
		}
	}

	@Override
	public FoodItemOrder findOrderById(Long orderId) {
		Query<FoodItemOrder> qrery = (Query<FoodItemOrder>) entity.createQuery("from FoodItemOrder where orderId=:id");
		qrery.setParameter("id", orderId);
		return qrery.getSingleResult();
	}

	@Override
	public String updateOrder(FoodItemOrder order) {
		String msg="";
		try {
			entity.merge(order);
			return msg="updation successfull";
		}catch(Exception e) {
			return msg="updation failure";
		}
	}

	@Override
	public String deleteOrder(Long productId) {
		String msg="";
		FoodItemOrder order = entity.find(FoodItemOrder.class, productId);
		try {
			entity.remove(order);
			return msg="deletion success";
		}catch(Exception e) {
			return msg="deletion failure";
		}
	}

	@Override
	public List<FoodItemOrder> listAllOrder() {
		List<FoodItemOrder> orderList =  entity.createQuery("from FromItemOrder").getResultList();
		return orderList;	}
	
//	private static class FoodItemOrderRowMapper implements RowMapper<FoodItemOrder> {
//        @Override
//        public FoodItemOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
//            FoodItemOrder order = new FoodItemOrder();
//            order.setOrderId(rs.getLong("orderId"));
//            // Set other fields from the ResultSet
//            order.setUser(new User(rs.getLong("userId"))); // You might need to fetch User details separately
//            order.setAdminProduct(new AdminProduct(rs.getLong("productId"))); // You might need to fetch Product details separately
//            order.setOrderDate(rs.getString("order_date"));
//            order.setUserName(rs.getString("userName"));
//            order.setBuildingName(rs.getString("buildingName"));
//            order.setColonyName(rs.getString("colonyName"));
//            order.setCityName(rs.getString("cityName"));
//            order.setStateName(rs.getString("stateName"));
//            order.setContactNumber(rs.getLong("contactNumber"));
//            order.setEmailId(rs.getLong("emailId"));
//            order.setCardNum(rs.getLong("cardNum"));
//            order.setExp(rs.getInt("exp"));
//            order.setCvv(rs.getInt("cvv"));
//            return order;
//        }
//    }

}
