package com.govtech.assignmentcore.accessor;

import com.govtech.assignmentcore.entity.ProductReview;

import java.util.List;

public interface ProductReviewAccessor {

  List<ProductReview> getByProductId(long productId);

  boolean insert(ProductReview productReview);
}
