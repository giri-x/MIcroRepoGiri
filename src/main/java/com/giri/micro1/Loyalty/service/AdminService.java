package com.giri.micro1.Loyalty.service;

import java.util.Optional;

import com.giri.micro1.Loyalty.model.Admin;


public interface AdminService {
	
	public boolean addAdmin(Admin admin);

	public Optional<Admin> findByemail(String email);

	public Optional<Admin> adminLogin(String email, String password);

}
