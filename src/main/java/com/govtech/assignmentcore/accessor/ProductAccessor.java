package com.govtech.assignmentcore.accessor;

import com.govtech.assignmentcore.common.Page;
import com.govtech.assignmentcore.common.ProductFilterVo;
import com.govtech.assignmentcore.entity.Product;

public interface ProductAccessor {

  Product getProductById(long id);

  Product getProductBySku(String sku);

  Page<Product> getProducts(ProductFilterVo productFilterVo);

  Product insert(Product product);

  Product update(long id, String sku, String category, String title, String description);
}
