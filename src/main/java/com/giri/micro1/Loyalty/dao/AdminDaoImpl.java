package com.giri.micro1.Loyalty.dao;

import java.util.Optional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.giri.micro1.Loyalty.model.Admin;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
@Transactional
@Service
public class AdminDaoImpl implements AdminDao {
	
	private EntityManager entityManager;
	
	public AdminDaoImpl() {
		super();
	}
	
    @Autowired
	public AdminDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	public void addAdmin(Admin admin) {
		 try {
	        	entityManager.persist(admin);
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public Optional<Admin> findByemail(String email) {
		return entityManager.createQuery("SELECT a FROM Admin a WHERE a.email = :email", Admin.class)
	              .setParameter("email", email)
	              .getResultStream()
	              .findFirst();
	}

	@Override
	public Admin adminLogin(String email, String password) {
		Query q = (Query) entityManager.createQuery("from Admin log where log.email =?1 and log.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return (Admin) q.getSingleResult();
	}

}
