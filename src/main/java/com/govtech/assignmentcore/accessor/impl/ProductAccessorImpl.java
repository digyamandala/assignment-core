package com.govtech.assignmentcore.accessor.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.govtech.assignmentcore.accessor.ProductAccessor;
import com.govtech.assignmentcore.accessor.mapper.ProductMapper;
import com.govtech.assignmentcore.common.Page;
import com.govtech.assignmentcore.common.ProductFilterVo;
import com.govtech.assignmentcore.common.SortProperty;
import com.govtech.assignmentcore.common.StoredFunctionName;
import com.govtech.assignmentcore.entity.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductAccessorImpl implements ProductAccessor {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  private final ObjectMapper objectMapper;

  private final ProductMapper productMapper;

  public ProductAccessorImpl(NamedParameterJdbcTemplate jdbcTemplate, ObjectMapper objectMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.objectMapper = objectMapper;
    this.productMapper = new ProductMapper(objectMapper);
  }

  @Override
  public Product getProductById(long id) {
    SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
    return jdbcTemplate.queryForObject("SELECT p.* FROM govtech_procurement_products.products p WHERE p.id = :id",
        param, productMapper);
  }

  @Override
  public Product getProductBySku(String sku) {
    SqlParameterSource param = new MapSqlParameterSource().addValue("sku", sku);
    return Optional.of(
            jdbcTemplate.queryForStream("SELECT p.* FROM govtech_procurement_products.products p WHERE p.sku = :sku", param,
                    productMapper)
                .collect(Collectors.toList()))
        .filter(products -> !CollectionUtils.isEmpty(products))
        .map(products -> products.get(0))
        .orElse(null);
  }

  @Override
  public Page<Product> getProducts(ProductFilterVo productFilterVo) {
    String sql = "SELECT * FROM govtech_procurement_products.products p WHERE (sku = " + getString(
        productFilterVo.getSku()) + " OR " + getString(productFilterVo.getSku()) + " IS NULL) AND " + "(title = " +
        getString(productFilterVo.getTitle()) + " OR " + getString(productFilterVo.getTitle()) +
        " IS NULL) AND (category = " + getString(productFilterVo.getCategory()) + " OR " + getString(
        productFilterVo.getCategory()) + " IS NULL) ";
    String orderBy = constructSortBy(productFilterVo);
    String limit = " LIMIT " + productFilterVo.getPagingRequest()
        .getItemPerPage();
    String offset = " OFFSET " + productFilterVo.getPagingRequest()
        .getOffset();

    String query = StringUtils.join(sql, orderBy, limit, offset);
    SqlParameterSource param = new MapSqlParameterSource();
    List<Product> products = jdbcTemplate.queryForStream(query, param, productMapper)
        .collect(Collectors.toList());

    String sqlCount = "SELECT COUNT(*) FROM govtech_procurement_products.products p WHERE (sku = " + getString(
        productFilterVo.getSku()) + " OR " + getString(productFilterVo.getSku()) + " IS NULL) AND " + "(title = " +
        getString(productFilterVo.getTitle()) + " OR " + getString(productFilterVo.getTitle()) +
        " IS NULL) AND (category = " + getString(productFilterVo.getCategory()) + " OR " + getString(
        productFilterVo.getCategory()) + " IS NULL) ";
    Long count = jdbcTemplate.queryForObject(sqlCount, param, Long.class);

    return new Page<>(productFilterVo.getPagingRequest()
        .getItemPerPage(), products, (productFilterVo.getPagingRequest()
        .getOffset() + productFilterVo.getPagingRequest()
        .getItemPerPage()) / productFilterVo.getPagingRequest()
        .getItemPerPage(), count);
  }

  @Override
  public Product insert(Product product) {
    Product check = getProductBySku(product.getSku());
    if (check != null) {
      throw new DuplicateKeyException("Duplicate SKU value!");
    }
    String sql =
        "      INSERT INTO govtech_procurement_products.products(\n" + "          sku,\n" + "          category,\n" +
            "          price,\n" + "          title,\n" + "          weight,\n" + "          description,\n" +
            "          images,\n" + "          average_rating,\n" + "          review_count,\n" +
            "          created_date,\n" + "          last_modified_date\n" + "      )\n" + "      VALUES(\n" +
            "          :sku,\n" + "          :category,\n" + "          :price,\n" + "          :title,\n" +
            "          :weight,\n" + "          :description,\n" + "          :images,\n" +
            "          :average_rating,\n" + "          :review_count,\n" + "          :created_date,\n" +
            "          :last_modified_date\n" + "      );";

    String images;
    try {
      images = objectMapper.writeValueAsString(product.getImages());
    } catch (JsonProcessingException e) {
      images = "{}";
    }
    SqlParameterSource param = new MapSqlParameterSource().addValue("sku", product.getSku())
        .addValue("title", product.getTitle())
        .addValue("description", product.getDescription())
        .addValue("category", product.getCategory())
        .addValue("price", product.getPrice())
        .addValue("weight", product.getWeight())
        .addValue("created_date", product.getCreatedDate())
        .addValue("last_modified_date", product.getLastModifiedDate())
        .addValue("review_count", product.getReviewCount())
        .addValue("average_rating", product.getAverageRating())
        .addValue("images", images, Types.OTHER);

    jdbcTemplate.update(sql, param);
    return getProductBySku(product.getSku());
  }

  @Override
  public Product update(long id, String sku, String category, String title, String description) {
    Product check = getProductBySku(sku);
    if (check != null) {
      throw new DuplicateKeyException("Duplicate SKU value!");
    }
    SqlParameterSource param = new MapSqlParameterSource().addValue("id", id)
        .addValue("sku", sku)
        .addValue("category", category)
        .addValue("title", title)
        .addValue("description", description)
        .addValue("id", id);

    String sql = "      UPDATE govtech_procurement_products.products\n" + "      SET\n" + "        sku = :sku,\n" +
        "        title = :title,\n" + "        category = :category,\n" + "        description = :description\n" +
        "      WHERE id = :id;";
    jdbcTemplate.update(sql, param);
    return getProductById(id);
  }

  private String constructSortBy(ProductFilterVo productFilterVo) {
    StringBuilder sb = new StringBuilder("ORDER BY ");
    List<SortProperty> sortProperties = productFilterVo.getPagingRequest()
        .getSortBy();
    if (sortProperties != null) {
      for (int i = 0; i < sortProperties.size(); i++) {
        sb.append(sortProperties.get(i)
                .getField())
            .append(" ")
            .append(sortProperties.get(i)
                .getOrder());
        if (i == sortProperties.size() - 1) {
          sb.append(" ");
        } else {
          sb.append(",");
        }
      }
      return sb.toString();
    }
    return "";
  }

  private String getString(String val) {
    return val == null ? null : '\'' + val + '\'';
  }
}
