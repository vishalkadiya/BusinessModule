package com.multiVendor.operation;

import org.springframework.http.ResponseEntity;

import com.multiVendor.view.ReviewView;

public interface ReviewOperation {

    ResponseEntity<Object> doSaveOperation(ReviewView view) throws Exception;

    ResponseEntity<Object> doUpdateOperation(ReviewView view) throws Exception;

    ResponseEntity<Object> deleteOpeartion(ReviewView view) throws Exception;

}
