package com.giri.micro1.Loyalty.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.giri.micro1.Loyalty.model.AdminProduct;
import com.giri.micro1.Loyalty.model.Offer;
import com.giri.micro1.Loyalty.service.OfferService;

@RestController
@CrossOrigin("*")
@RequestMapping("/Offer")
public class OfferController {
	
	@Autowired
	OfferService service;

	@PostMapping("/doOfferDetailsInsert")
	public Offer regPack(@RequestParam("offerName") String offerName,
			@RequestParam("category") String category, @RequestParam("description") String description,
			@RequestParam("points") Integer points, @RequestParam("offerimage") MultipartFile image)
			throws IOException {

		Offer offerentity = new Offer();
		offerentity.setOfferName(offerName);
		offerentity.setCategory(category);
		offerentity.setDescription(description);
		offerentity.setPoints(points);

		offerentity.setOfferimage(image.getBytes());

		return service.regOffer(offerentity, image);

	}
	
	@GetMapping("/getAllOfferDetailsList")
	public List<Offer> getOfferDetails() {
		return service.getOfferDetails();
	}

	

}
