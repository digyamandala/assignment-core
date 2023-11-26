package com.govtech.assignmentcore.service;

import com.govtech.assignmentcore.service.model.GetProductReviewServiceResponse;
import com.govtech.assignmentcore.service.model.InsertProductReviewServiceRequest;

import java.util.List;

public interface ProductReviewService {

  List<GetProductReviewServiceResponse> getProductReviewByProductId(long productId);

  boolean insert(InsertProductReviewServiceRequest request);
}
