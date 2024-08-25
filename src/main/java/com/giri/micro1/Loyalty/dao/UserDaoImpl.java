package com.giri.micro1.Loyalty.dao;

import java.util.List;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.giri.micro1.Loyalty.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
@Service
public class UserDaoImpl implements UserDao {

	private EntityManager entityManager;

	public UserDaoImpl() {
		super();

	}

	@Autowired
	public UserDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void addUser(User user) {

		try {
			entityManager.persist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Optional<User> findbyemail(String email) {

		return entityManager.createQuery("SELECT a FROM User a WHERE a.email = :email", User.class)
				.setParameter("email", email).getResultStream().findFirst();
	}

	@Override
	public User userLogin(String email, String password) {
		Query q = (Query) entityManager.createQuery("from Customer log where log.email =?1 and log.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return (User) q.getSingleResult();
	}

	@Override
	public List<User> listAllUser() {
		List<User> userList = entityManager.createQuery("from User").getResultList();
		return userList;
	}

	@Override
	@Transactional
	public void updateRewardCoins(Long userId, Double rewardCoins) {
		User user = entityManager.find(User.class, userId);
		if (user != null) {
			user.setRewardCoins(rewardCoins);
			entityManager.merge(user);
		}
	}

	// Existing methods

	@Override
	public void updateTotalAmount(Long userId, Double totalAmount) {
		User user = entityManager.find(User.class, userId);
		if (user != null) {
			user.setTotalAmount(totalAmount);
			entityManager.merge(user);
		}
	}

//	@Override
//	public Optional<User> findById(Long userId) {
//		User user = entityManager.find(User.class, userId);
//		return Optional.ofNullable(user);
//	}

//	@Override
//	public Double getRewardCoins(String email) {
//		User user = entityManager.find(User.class, email);
//		return (user != null) ? user.getRewardCoins() : null;
//	}

//	@Override
//	public Optional<User> findById(String email) {
//		User user = entityManager.find(User.class, email);
//	return Optional.ofNullable(user);
//	}
	
//	 public Optional<User> findById(String email) {
//	        User user = entityManager.find(User.class, email);
//	        return Optional.ofNullable(user);
//	    }
	
	 @Override
	    public Double getRewardCoins(String email) {
	        User user = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
	                                 .setParameter("email", email)
	                                 .getSingleResult();
	        return (user != null) ? user.getRewardCoins() : null;
	    }

	@Override
	public Optional<User> findById(String email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public User custLogin(String email, String password) {
		Query query1 = entityManager.createQuery("from User u where u.email =?1 and u.password=?2");
		query1.setParameter(1, email);
		query1.setParameter(2, password);
 
		return (User) query1.getSingleResult();
 
	}

}
