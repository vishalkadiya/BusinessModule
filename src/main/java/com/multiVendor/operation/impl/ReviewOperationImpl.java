package com.multiVendor.operation.impl;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.multiVendor.commonUtils.ActiveInActive;
import com.multiVendor.commonUtils.OperationName;
import com.multiVendor.commonUtils.ResponseCode;
import com.multiVendor.entity.Reviews;
import com.multiVendor.exception.InvalidDataException;
import com.multiVendor.operation.ReviewOperation;
import com.multiVendor.service.ReviewService;
import com.multiVendor.view.ReviewView;

@Component
public class ReviewOperationImpl implements ReviewOperation {

	@Autowired
	ReviewService reviewService;

	public ReviewService getService() {
		return reviewService;
	}

	private static final Logger log = LogManager.getLogger(BusinessOperationImpl.class);

	private Reviews toModel(Reviews model, ReviewView view) throws Exception {
		if (!view.getReview().isEmpty()) {
			model.setReview(view.getReview());
		}
		if (!view.getRating().equals(null)) {
			if (view.getRating() > 5 || view.getRating() <= 0) {
				log.error("Rating, should be in 1 to 5");
				throw new Exception("Rating, should be in 1 to 5");
			}
			model.setRating(view.getRating());
		}
		return model;
	}

	private ReviewView fromModel(Reviews model) {
		ReviewView view = new ReviewView();
		view.setId(model.getId());
		view.setRating(model.getRating());
		view.setReview(model.getReview());
		return view;
	}

	@Override
	public ResponseEntity<Object> doSaveOperation(ReviewView view) throws Exception {

		Reviews model = new Reviews();
		try {
			beforeSave(model, view);
			model = toModel(model, view);
			getService().save(model);
			return ResponseEntity.ok(fromModel(model));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.SAVE + " "
					+ com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " saveReview");
		}
	}

	private void beforeSave(Reviews model, ReviewView view) {
		LocalDateTime currentTime = LocalDateTime.now();
		model.setCreated_date(currentTime);
		model.setUpdatedAt(currentTime);
		model.setActivationStatus(ActiveInActive.ACTIVE);
	}

	@Override
	public ResponseEntity<Object> doUpdateOperation(ReviewView view) throws Exception {
		Reviews model = new Reviews();
		try {
			model = loadModel(view);
			if (model == null) {
				log.error("Review not found");
				throw new InvalidDataException(ResponseCode.NO_DATA_FOUND.getCode(), this.getClass().getName(),
						OperationName.SEARCH_TABLE);
			}
			beforeUpdate(model, view);
			model = toModel(model, view);
			getService().update(model);
			return ResponseEntity.ok(fromModel(model));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.SAVE + " "
					+ com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " saveReview");
		}
	}

	private Reviews loadModel(ReviewView view) {

		return getService().findById(view);
	}

	private void beforeUpdate(Reviews model, ReviewView view) {
		LocalDateTime currentTime = LocalDateTime.now();
		model.setUpdatedAt(currentTime);
		model.setActivationStatus(ActiveInActive.ACTIVE);
	}

	@Override
	public ResponseEntity<Object> deleteOpeartion(ReviewView view) throws Exception {
		Reviews model = new Reviews();
		try {
			model = loadModel(view);
			if (model == null) {
				log.error("Review not found");
				throw new InvalidDataException(ResponseCode.NO_DATA_FOUND.getCode(), this.getClass().getName(),
						OperationName.SEARCH_TABLE);
			}
			model.setActivationStatus(ActiveInActive.INACTIVE);
			getService().save(model);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Review is successfully deleted");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			log.info(this.getClass().getSimpleName() + " " + OperationName.DELETE + " "
					+ com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " deleteCompany");
		}
	}

}
