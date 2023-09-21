package com.multiVendor.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.multiVendor.commonUtils.ActiveInActive;

@Entity
@Table(name = "business_reviews")
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "created_date", nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime created_date;

	@Column(name = "updated_date", nullable = false, updatable = false)
	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Column(name = "ACTIVATION_STATUS")
	private Integer activationStatusID;

	@Column(name = "review", nullable = false, length = 100)
	private String review;

	@Column(name = "rating", nullable = true, length = 5)
	private Integer rating;

	public Reviews() {
		super();
	}

	public Reviews(Integer id, LocalDateTime created_date, LocalDateTime updatedAt, Integer activationStatusID,
			String review,
			Integer rating) {
		super();
		this.id = id;
		this.created_date = created_date;
		this.updatedAt = updatedAt;
		this.activationStatusID = activationStatusID;
		this.review = review;
		this.rating = rating;
	}

	public ActiveInActive getActivationStatus() {
		return ActiveInActive.fromId(getActivationStatusID());
	}

	public void setActivationStatus(ActiveInActive activeInActive) {
		this.activationStatusID = activeInActive.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDateTime currentTime) {
		this.created_date = currentTime;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getActivationStatusID() {
		return activationStatusID;
	}

	public void setActivationStatusID(Integer activationStatusID) {
		this.activationStatusID = activationStatusID;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
