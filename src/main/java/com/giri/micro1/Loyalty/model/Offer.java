package com.giri.micro1.Loyalty.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Offers")
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long offerId;
	
	@Lob
	@Column(name = "image",length=1000000)
	private byte[] offerimage;
	
	private String category;
	
	private String offerName;
	
	private String description;
	
	private int points;

	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offer(Long offerId, byte[] offerimage, String category, String offerName, String description, int points) {
		super();
		this.offerId = offerId;
		this.offerimage = offerimage;
		this.category = category;
		this.offerName = offerName;
		this.description = description;
		this.points = points;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public byte[] getOfferimage() {
		return offerimage;
	}

	public void setOfferimage(byte[] offerimage) {
		this.offerimage = offerimage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	
	
}
