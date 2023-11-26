package com.govtech.assignmentcore.accessor.impl;

import com.govtech.assignmentcore.accessor.ProductAccessor;
import com.govtech.assignmentcore.accessor.ProductReviewAccessor;
import com.govtech.assignmentcore.accessor.mapper.ProductReviewMapper;
import com.govtech.assignmentcore.entity.ProductReview;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductReviewAccessorImpl implements ProductReviewAccessor {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  private final ProductAccessor productAccessor;

  private final ProductReviewMapper productReviewMapper;

  public ProductReviewAccessorImpl(NamedParameterJdbcTemplate jdbcTemplate, ProductAccessor productAccessor) {
    this.jdbcTemplate = jdbcTemplate;
    this.productAccessor = productAccessor;
    this.productReviewMapper = new ProductReviewMapper();
  }

  @Override
  public List<ProductReview> getByProductId(long productId) {
    String sql = "SELECT * FROM govtech_procurement_products.product_reviews pr WHERE pr.product_id = :product_id";
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource("product_id", productId);
    return jdbcTemplate.queryForStream(sql, sqlParameterSource, productReviewMapper)
        .collect(Collectors.toList());
  }

  @Override
  public boolean insert(ProductReview productReview) {
    productAccessor.getProductById(productReview.getProductId());
    String sql =
        "BEGIN; INSERT INTO govtech_procurement_products.product_reviews(product_id, rating, comment, created_date, last_modified_date) VALUES(:product_id, :rating, :comment, :created_date, :last_modified_date);" +
            "UPDATE govtech_procurement_products.products SET review_count = review_count + 1, average_rating = ((average_rating * review_count) + :rating) / (review_count + 1)" +
            "WHERE id = :product_id;" + "COMMIT;";
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource("product_id",
        productReview.getProductId()).addValue("rating", productReview.getRating())
        .addValue("comment", productReview.getComment())
        .addValue("created_date", productReview.getCreatedDate())
        .addValue("last_modified_date", productReview.getLastModifiedDate());
    jdbcTemplate.update(sql, sqlParameterSource);
    return true;
  }
}
