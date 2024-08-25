package com.giri.micro1.Loyalty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.micro1.Loyalty.dao.AdminDao;
import com.giri.micro1.Loyalty.model.Admin;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao dao;

	@Override
	public boolean addAdmin(Admin admin) {
		dao.addAdmin(admin);
		return true;
	}

	@Override
	public Optional<Admin> findByemail(String email) {
		return this.dao.findByemail(email);
	}

	@Override
	public Optional<Admin> adminLogin(String email, String password) {
		return dao.findByemail(email);
	}

}
