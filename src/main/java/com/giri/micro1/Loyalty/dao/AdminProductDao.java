package com.giri.micro1.Loyalty.dao;

import java.util.List;


import com.giri.micro1.Loyalty.model.AdminProduct;



public interface AdminProductDao {
	
	public String addProduct(AdminProduct product);
	public AdminProduct findProductById(Long productId);
	public String updateProduct(AdminProduct product);
	public String deleteProduct(Long productId);
	public List<AdminProduct> listAllProduct();

}
