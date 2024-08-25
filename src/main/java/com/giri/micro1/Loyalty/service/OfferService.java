package com.giri.micro1.Loyalty.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.giri.micro1.Loyalty.model.AdminProduct;
import com.giri.micro1.Loyalty.model.Offer;


public interface OfferService {
	
//public boolean insertOffer(Offer offer);
	
//	public boolean updateOffer(Offer offer);
//	public List<Offer> findAllOffer();
//	
//	public Offer findOfferById(Long offerId);
//
//	
//	public Offer find(long offerId);
//	public List<Offer> getOfferDetails();
//	public List<Integer> getOfferDetailsIdlist();
//	public boolean deleteOffer(Long offerId);
	public Offer regOffer (Offer offerentity, MultipartFile image) throws IOException;
//	public Offer updateProject(Offer offerentity, MultipartFile image);

	public List<Offer> getOfferDetails();

}
