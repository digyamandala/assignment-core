package com.govtech.assignmentcore.service.impl;

import com.govtech.assignmentcore.accessor.ProductReviewAccessor;
import com.govtech.assignmentcore.entity.ProductReview;
import com.govtech.assignmentcore.service.ProductReviewService;
import com.govtech.assignmentcore.service.TimeService;
import com.govtech.assignmentcore.service.model.GetProductReviewServiceResponse;
import com.govtech.assignmentcore.service.model.InsertProductReviewServiceRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

  private final ProductReviewAccessor productReviewAccessor;

  private final TimeService timeService;

  public ProductReviewServiceImpl(ProductReviewAccessor productReviewAccessor, TimeService timeService) {
    this.productReviewAccessor = productReviewAccessor;
    this.timeService = timeService;
  }

  @Override
  public List<GetProductReviewServiceResponse> getProductReviewByProductId(long productId) {
    return Optional.ofNullable(productReviewAccessor.getByProductId(productId))
        .orElseGet(Collections::emptyList)
        .stream()
        .map(productReview -> new GetProductReviewServiceResponse(productReview.getComment(),
            productReview.getCreatedDate(), productReview.getId(), productReview.getLastModifiedDate(),
            productReview.getProductId(), productReview.getRating()))
        .collect(Collectors.toList());
  }

  @Override
  public boolean insert(InsertProductReviewServiceRequest request) {
    long now = timeService.now();
    ProductReview productReview = new ProductReview();
    productReview.setProductId(request.getProductId());
    productReview.setComment(request.getComment());
    productReview.setRating(request.getRating());
    productReview.setCreatedDate(now);
    productReview.setLastModifiedDate(now);
    productReviewAccessor.insert(productReview);
    return true;
  }
}
