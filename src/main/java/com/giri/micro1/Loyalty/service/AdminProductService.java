package com.giri.micro1.Loyalty.service;

import java.util.List;

import com.giri.micro1.Loyalty.model.AdminProduct;


public interface AdminProductService {
	
	public boolean insertProduct(AdminProduct product);
	
	public boolean updateProduct(AdminProduct product);
	public List<AdminProduct> findAllProduct();
	
	boolean deleteProduct(Long productId);
	public AdminProduct findProductyById(Long productId);

}
