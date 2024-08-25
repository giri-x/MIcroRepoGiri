package com.giri.micro1.Loyalty.dao;

import java.util.Optional;

import com.giri.micro1.Loyalty.model.Admin;



public interface AdminDao {
	
    public void addAdmin(Admin admin);
	
	public Optional<Admin> findByemail(String email);

	public Admin adminLogin(String email, String password);

}
