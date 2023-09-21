package com.multiVendor.controller.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiVendor.commonUtils.OperationName;
import com.multiVendor.controller.ReviewController;
import com.multiVendor.operation.ReviewOperation;
import com.multiVendor.validation.DataType;
import com.multiVendor.validation.InputField;
import com.multiVendor.validation.StaticFormValidator;
import com.multiVendor.view.ReviewView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/business/review")
public class ReviewControllerImpl implements ReviewController {

    @Autowired
    ReviewOperation reviewOperation;

    private static final Logger log = LogManager.getLogger(ReviewControllerImpl.class);

    public ReviewOperation getOperation() {
        return reviewOperation;
    }

    private void isValidSaveData(ReviewView view) {

        Map<String, String> errorProperties = new HashMap<>();
        commonValidation(view, errorProperties);

    }

    private void commonValidation(ReviewView view, Map<String, String> errorProperties) {

        StaticFormValidator.VALIDATE_STRING_WITHOUT_REGEX
                .isValid(new InputField("review", view.getReview(),
                        DataType.STRING, 0, 100, null, errorProperties));

    }

    @Override
    public ResponseEntity<Object> save(@RequestBody ReviewView view) throws Exception {
        try {
            isValidSaveData(view);
            return getOperation().doSaveOperation(view);
        } finally {
            log.info(this.getClass().getSimpleName() + " " + OperationName.SAVE + " "
                    + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " saveReview");
        }
    }

    @Override
    public ResponseEntity<Object> update(@RequestBody ReviewView view) throws Exception {
        try {
            isValidSaveData(view);
            return getOperation().doUpdateOperation(view);
        } finally {
            log.info(this.getClass().getSimpleName() + " " + OperationName.UPDATE + " "
                    + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " updateReview");
        }
    }

    @Override
    public ResponseEntity<Object> delete(@RequestBody ReviewView view) throws Exception {
        try {
            return getOperation().deleteOpeartion(view);
        } finally {
            log.info(this.getClass().getSimpleName() + " " + OperationName.DELETE + " "
                    + com.multiVendor.commonUtils.LogMessage.REQUEST_COMPLETED + " deleteReview");
        }
    }

}
