package com.giri.micro1.Loyalty.dao;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.giri.micro1.Loyalty.model.AdminProduct;
import com.giri.micro1.Loyalty.model.Offer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class OfferDaoImpl implements OfferDao {
	
	@Autowired
	private EntityManager entity;

//	@Override
//	public String addOffer(Offer offer) {
//		String msg="";
//		try {
//		entity.persist(offer);
//		return msg="Inserted Success";
//		}catch(Exception e) {
//			return msg="Inserted failure";
//		}
//	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Integer> getOfferDetailsIdlist() {
//		Query q = entity.createQuery("SELECT c.packageId FROM PackageDetails c");
//		return q.getResultList();
//	}

//	@Override
//	public String updateOffer(Offer offer) {
//		String msg="";
//		try {
//			entity.merge(offer);
//			return msg="updation successfull";
//		}catch(Exception e) {
//			return msg="updation failure";
//		}
//	}

//	@Override
//	public boolean deleteOffer(Long offerId) {
//		String msg="";
//		Offer offer = entity.find(Offer.class, offerId);
//		try {
//			entity.remove(offer);
//			return msg="deletion success";
//		}catch(Exception e) {
//			return msg="deletion failure";
//		}
//	}

//	@Override
//	public List<Offer> listAllOffer() {
//		List<Offer> UserList =  entity.createQuery("from Offer").getResultList();
//		return UserList;
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Offer> getOfferDetails() {
//		return entity.createQuery("from Offer").getResultList();
//
//	}
//
//	@Override
//	public Offer find(long offerId) {
//		return entity.find(Offer.class, offerId);
//
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Integer> getOfferDetailsIdlist() {
//		Query q = entity.createQuery("SELECT c.offerId FROM Offer c");
//		return q.getResultList();
//	}
//
//	

	

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Offer> getDestination(String destinationPlace) {
//		Query query = entityMan.createQuery(" from PackageDetails p WHERE p.destinationPlace = :destinationPlace");
//		query.setParameter("destinationPlace", destinationPlace);
//		return query.getResultList();
//
//	}

//	@Override
//	public boolean deleteOffer(Long offerId) {
//		Query query = entity.createQuery("DELETE Offer p WHERE p.offerId = :offerId");
//		query.setParameter("offerId", offerId);
//		query.executeUpdate();
//		return true;
//	}

	@Override
	public Offer addOffer(Offer offerentity, MultipartFile image) throws IOException {
		try {

			Offer offerdet = new Offer();
			offerdet.setOfferId(offerentity.getOfferId());
			offerdet.setOfferName(offerentity.getOfferName());
			offerdet.setCategory(offerentity.getCategory());
			offerdet.setDescription(offerentity.getDescription());
			offerdet.setPoints(offerentity.getPoints());
			offerdet.setOfferimage(image.getBytes());
			entity.persist(offerdet);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//
//	@Override
//	public Offer updateOffer1(Offer offerentity, MultipartFile image) {
//		try {
//
//			Offer offerdet = new Offer();
//			offerdet.setOfferId(offerentity.getOfferId());
//			offerdet.setOfferName(offerentity.getOfferName());
//			offerdet.setCategory(offerentity.getCategory());
//			offerdet.setDescription(offerentity.getDescription());
//			offerdet.setPoints(offerentity.getPoints());
//			offerentity.setOfferimage(image.getBytes());
//			entity.merge(offerdet);
//
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public List<Offer> getCategory(String category) {
//		Query query = entity.createQuery(" from Offer p WHERE p.category = :category");
//		query.setParameter("category", category);
//		return query.getResultList();
//
//	}
//
//	@Override
//	public Offer findOfferById(Long offerId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Offer> getOfferDetails() {
		return entity.createQuery("from Offer").getResultList();
	}

}
