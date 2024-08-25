package com.giri.micro1.Loyalty.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.giri.micro1.Loyalty.model.AdminProduct;
import jakarta.persistence.EntityManager;

@Repository
public class AdminProductDaoImpl implements AdminProductDao {
	
	@Autowired
	private EntityManager entity;

	@Override
	public String addProduct(AdminProduct product) {
		String msg="";
		try {
		entity.persist(product);
		return msg="Inserted Success";
		}catch(Exception e) {
			return msg="Inserted failure";
		}

	}

	@Override
	public AdminProduct findProductById(Long productId) {
		Query<AdminProduct> qrery = (Query<AdminProduct>) entity.createQuery("from AdminProduct where productId=:id");
		qrery.setParameter("id", productId);
		return qrery.getSingleResult();
	}

	@Override
	public String updateProduct(AdminProduct product) {
		String msg="";
		try {
			entity.merge(product);
			return msg="updation successfull";
		}catch(Exception e) {
			return msg="updation failure";
		}
	}

	@Override
	public String deleteProduct(Long productId) {
		String msg="";
		AdminProduct prod = entity.find(AdminProduct.class, productId);
		try {
			entity.remove(prod);
			return msg="deletion success";
		}catch(Exception e) {
			return msg="deletion failure";
		}
	}

	@Override
	public List<AdminProduct> listAllProduct() {
		List<AdminProduct> UserList =  entity.createQuery("from AdminProduct").getResultList();
		return UserList;
	}

}
