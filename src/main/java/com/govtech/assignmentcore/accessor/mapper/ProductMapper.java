package com.govtech.assignmentcore.accessor.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.govtech.assignmentcore.entity.Product;
import com.govtech.assignmentcore.entity.ProductImage;
import org.postgresql.util.PGobject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductMapper implements RowMapper<Product> {

  private final ObjectMapper objectMapper;

  public ProductMapper(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override
  public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

    Product product = new Product();
    product.setId(rs.getLong("id"));
    product.setSku(rs.getString("sku"));
    product.setTitle(rs.getString("title"));
    product.setCategory(rs.getString("category"));
    product.setDescription(rs.getString("description"));
    product.setPrice(rs.getDouble("price"));
    product.setWeight(rs.getDouble("weight"));
    product.setCreatedDate(rs.getLong("created_date"));
    product.setLastModifiedDate(rs.getLong("last_modified_date"));
    product.setReviewCount(rs.getLong("review_count"));
    product.setAverageRating(rs.getDouble("average_rating"));
    PGobject pGobject = (PGobject) rs.getObject("images");
    try {
      product.setImages(objectMapper.readValue(pGobject.getValue(), new TypeReference<List<ProductImage>>() {}));
    } catch (JsonProcessingException e) {

    }
    return product;
  }
}
