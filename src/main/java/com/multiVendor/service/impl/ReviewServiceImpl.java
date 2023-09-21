package com.multiVendor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.multiVendor.entity.Reviews;
import com.multiVendor.repository.ReviewRepository;
import com.multiVendor.service.ReviewService;
import com.multiVendor.view.ReviewView;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	@Override
	public void save(Reviews model) {
		reviewRepository.save(model);
	}

	@Override
	public Reviews findById(ReviewView view) {
		Reviews review = reviewRepository.findById(view.getId()).get();
		return review;
	}

	@Override
	public void update(Reviews model) {
		reviewRepository.update(model.getId(), model.getRating(), model.getReview(), model.getUpdatedAt());
	}

}
