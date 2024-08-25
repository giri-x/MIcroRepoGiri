package com.giri.micro1.Loyalty.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.giri.micro1.Loyalty.dao.OfferDao;
import com.giri.micro1.Loyalty.model.Offer;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {
	
	@Autowired
	OfferDao dao;

//	@Override
//	public boolean insertOffer(Offer offer) {
//		this.dao.addOffer(offer);
//		   return true;
//	}

//	@Override
//	public boolean updateOffer(Offer offer) {
//		dao.updateOffer(offer);
//		return true;
//	}
//
//	@Override
//	public List<Offer> findAllOffer() {
//		return this.dao.listAllOffer();
//	}
//
//	@Override
//	public boolean deleteOffer(Long offerId) {
//		dao.deleteOffer(offerId);
//		return true;
//	}
//
//	@Override
//	public Offer findOfferById(Long offerId) {
//		return dao.findOfferById(offerId);
//	}
//	
//	@Override
//	public List<Offer> getOfferDetails() {
//		return dao.getOfferDetails();
//	}
// 
//	@Override
//	public Offer find(long offerId) {
//		return dao.find(offerId);
//	}
// 
//	@Override
//	public List<Integer> getOfferDetailsIdlist() {
//		return dao.getOfferDetailsIdlist();
//	}
// 
	
//	public Offer regOffer1(Offer offerentity, MultipartFile image) throws IOException {
//		return dao.regOffer1(offerentity, image);
//	}
 
	
//	public Offer updateOffer1(Offer offerentity, MultipartFile image) throws IOException {
//		return dao.updateOffer1(offerentity, image);
//	}
 
//	@Override
//	public boolean deleteOffer(Long offerId) {
//		return dao.deleteOffer(offerId);
//	}
 
//	public List<Offer> getCategory(String category) {
// 
//		return dao.getCategory(category);
//	}

////	@Override
//	public boolean deleteOffer(Long OfferId) {
//		return dao.deleteOffer(offerId);
//	}

	@Override
	public Offer regOffer(Offer offerentity, MultipartFile image)throws IOException {
		return dao.addOffer(offerentity,image);
	}

	@Override
	public List<Offer> getOfferDetails() {
		return dao.getOfferDetails();
	}

//	@Override
//	public Offer updateProject(Offer offerentity, MultipartFile image) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}


