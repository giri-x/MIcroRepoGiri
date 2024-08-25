package com.giri.micro1.Loyalty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.micro1.Loyalty.dao.AdminProductDao;
import com.giri.micro1.Loyalty.model.AdminProduct;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class AdminProductServiceImpl implements AdminProductService {
	
	@Autowired
	AdminProductDao dao;

	@Override
	public boolean insertProduct(AdminProduct product) {
		this.dao.addProduct(product);
		   return true;
	}

	@Override
	public boolean updateProduct(AdminProduct product) {
		dao.updateProduct(product);
		return true;
	}

	@Override
	public List<AdminProduct> findAllProduct() {
		return this.dao.listAllProduct();
	}

	@Override
	public boolean deleteProduct(Long productId) {
		dao.deleteProduct(productId);
		return true;
	}

	@Override
	public AdminProduct findProductyById(Long productId) {
		return dao.findProductById(productId);
	}

}
