package com.govtech.assignmentcore.accessor.mapper;

import com.govtech.assignmentcore.entity.ProductReview;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductReviewMapper implements RowMapper<ProductReview> {

  public ProductReviewMapper() {
  }

  @Override
  public ProductReview mapRow(ResultSet rs, int rowNum) throws SQLException {

    ProductReview productReview = new ProductReview();
    productReview.setId(rs.getLong("id"));
    productReview.setProductId(rs.getLong("product_id"));
    productReview.setComment(rs.getString("comment"));
    productReview.setRating(rs.getDouble("rating"));
    productReview.setCreatedDate(rs.getLong("created_date"));
    productReview.setLastModifiedDate(rs.getLong("last_modified_date"));

    return productReview;
  }
}
