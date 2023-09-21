package com.multiVendor.service;

import com.multiVendor.entity.Reviews;
import com.multiVendor.view.ReviewView;

public interface ReviewService {

	void save(Reviews model);

	Reviews findById(ReviewView view);

	void update(Reviews model);
}
