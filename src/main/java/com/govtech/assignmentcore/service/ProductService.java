package com.govtech.assignmentcore.service;

import com.govtech.assignmentcore.common.Page;
import com.govtech.assignmentcore.service.model.GetListProductServiceRequest;
import com.govtech.assignmentcore.service.model.GetProductServiceResponse;
import com.govtech.assignmentcore.service.model.InsertProductServiceRequest;
import com.govtech.assignmentcore.service.model.UpdateProductServiceRequest;

public interface ProductService {

  GetProductServiceResponse getProductById(long id);

  Page<GetProductServiceResponse> getProducts(GetListProductServiceRequest request);

  boolean insert(InsertProductServiceRequest request);

  boolean update(UpdateProductServiceRequest request);
}
