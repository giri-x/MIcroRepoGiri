package com.giri.micro1.Loyalty.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.giri.micro1.Loyalty.model.AdminProduct;
import com.giri.micro1.Loyalty.model.Offer;

public interface OfferDao {
//	public String addOffer(Offer offer);
//	public Offer findOfferById(Long offerId);
//	public String updateOffer(Offer offer);
//	public boolean deleteOffer(Long offerId);
//	public List<Offer> listAllOffer();
//	
//	public List<Offer> getOfferDetails();
//	public Offer find(long offerId);
//	public List<Integer> getOfferDetailsIdlist();
//	public Offer updateOffer1(Offer offerentity, MultipartFile image);
//	public List<Offer> getCategory(String category);
	public Offer addOffer(Offer offerentity, MultipartFile image) throws IOException;

	public List<Offer> getOfferDetails();

}
