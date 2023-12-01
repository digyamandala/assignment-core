package com.govtech.assignmentcore.web.controller;

import com.govtech.assignmentcore.common.Page;
import com.govtech.assignmentcore.service.ProductReviewService;
import com.govtech.assignmentcore.service.ProductService;
import com.govtech.assignmentcore.service.model.GetListProductServiceRequest;
import com.govtech.assignmentcore.service.model.GetProductReviewServiceResponse;
import com.govtech.assignmentcore.service.model.GetProductServiceResponse;
import com.govtech.assignmentcore.service.model.InsertProductReviewServiceRequest;
import com.govtech.assignmentcore.service.model.InsertProductServiceRequest;
import com.govtech.assignmentcore.service.model.ProductImageServiceRequest;
import com.govtech.assignmentcore.service.model.UpdateProductServiceRequest;
import com.govtech.assignmentcore.web.model.GetProductReviewWebResponse;
import com.govtech.assignmentcore.web.model.GetProductWebResponse;
import com.govtech.assignmentcore.web.model.InsertProductReviewWebRequest;
import com.govtech.assignmentcore.web.model.InsertProductWebRequest;
import com.govtech.assignmentcore.web.model.ProductImageWebResponse;
import com.govtech.assignmentcore.web.model.SearchProductWebRequest;
import com.govtech.assignmentcore.web.model.UpdateProductWebRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

  private final ProductReviewService productReviewService;

  private final ProductService productService;

  public ProductController(ProductReviewService productReviewService, ProductService productService) {
    this.productReviewService = productReviewService;
    this.productService = productService;
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<GetProductWebResponse> getProductById(@PathVariable Long id) {
    GetProductServiceResponse serviceResponse = productService.getProductById(id);
    GetProductWebResponse webResponse = toGetProductServiceResponse(serviceResponse);
    return ResponseEntity.ok(webResponse);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> getProductById(@RequestBody InsertProductWebRequest request) {
    InsertProductServiceRequest serviceRequest = new InsertProductServiceRequest();
    serviceRequest.setCategory(request.getCategory());
    serviceRequest.setSku(request.getSku());
    serviceRequest.setDescription(request.getDescription());
    serviceRequest.setTitle(request.getTitle());
    serviceRequest.setWeight(request.getWeight());
    serviceRequest.setPrice(request.getPrice());
    serviceRequest.setImages(request.getImages()
        .stream()
        .map(imageWebReq -> new ProductImageServiceRequest(imageWebReq.getDescription(), imageWebReq.isThumbnail(),
            imageWebReq.getUrl()))
        .collect(Collectors.toList()));
    return ResponseEntity.ok(productService.insert(serviceRequest));
  }

  @GetMapping(path = "/{id}/reviews")
  public ResponseEntity<List<GetProductReviewWebResponse>> getProductReviewByProductId(@PathVariable Long id) {
    List<GetProductReviewServiceResponse> serviceResponse = productReviewService.getProductReviewByProductId(id);
    List<GetProductReviewWebResponse> webResponse = serviceResponse.stream()
        .map(
            r -> new GetProductReviewWebResponse(r.getComment(), r.getCreatedDate(), r.getId(), r.getLastModifiedDate(),
                r.getProductId(), r.getRating()))
        .collect(Collectors.toList());
    return ResponseEntity.ok(webResponse);
  }

  @PostMapping(path = "/search")
  public ResponseEntity<Page<GetProductWebResponse>> getProducts(@RequestBody SearchProductWebRequest request) {
    GetListProductServiceRequest serviceRequest = new GetListProductServiceRequest();
    if (CollectionUtils.isEmpty(request.getPagingRequest().getSortBy())) {
      request.getPagingRequest().setDefaultSortBy();
    }
    serviceRequest.setPagingRequest(request.getPagingRequest());
    serviceRequest.setSku(request.getFilter()
        .getSku());
    serviceRequest.setCategory(request.getFilter()
        .getCategory());
    serviceRequest.setTitle(request.getFilter()
        .getTitle());
    Page<GetProductServiceResponse> serviceResponse = productService.getProducts(serviceRequest);
    List<GetProductWebResponse> items = serviceResponse.getItems()
        .stream()
        .map(this::toGetProductServiceResponse)
        .collect(Collectors.toList());
    return ResponseEntity.ok(new Page<>(request.getPagingRequest()
        .getItemPerPage(), items, request.getPagingRequest()
        .getPage(), serviceResponse.getTotal()));
  }

  @PostMapping(path = "/{id}/reviews")
  public ResponseEntity<Boolean> insertReview(@PathVariable Long id,
      @RequestBody InsertProductReviewWebRequest request) {
    InsertProductReviewServiceRequest serviceRequest = new InsertProductReviewServiceRequest(request.getComment(), id,
        request.getRating());
    boolean serviceResponse = productReviewService.insert(serviceRequest);
    return ResponseEntity.ok(serviceResponse);
  }

  @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> updateProduct(@PathVariable Long id, @RequestBody UpdateProductWebRequest request) {
    UpdateProductServiceRequest serviceRequest = new UpdateProductServiceRequest();
    serviceRequest.setCategory(request.getCategory());
    serviceRequest.setSku(request.getSku());
    serviceRequest.setDescription(request.getDescription());
    serviceRequest.setTitle(request.getTitle());
    serviceRequest.setId(id);
    return ResponseEntity.ok(productService.update(serviceRequest));
  }

  private GetProductWebResponse toGetProductServiceResponse(GetProductServiceResponse serviceResponse) {
    GetProductWebResponse webResponse = new GetProductWebResponse();
    webResponse.setId(serviceResponse.getId());
    webResponse.setCategory(serviceResponse.getCategory());
    webResponse.setDescription(serviceResponse.getDescription());
    webResponse.setSku(serviceResponse.getSku());
    webResponse.setPrice(serviceResponse.getPrice());
    webResponse.setWeight(serviceResponse.getWeight());
    webResponse.setAverageRating(serviceResponse.getAverageRating());
    webResponse.setReviewCount(serviceResponse.getReviewCount());
    webResponse.setCreatedDate(serviceResponse.getCreatedDate());
    webResponse.setLastModifiedDate(serviceResponse.getLastModifiedDate());
    webResponse.setImages(serviceResponse.getImages()
        .stream()
        .map(i -> new ProductImageWebResponse(i.getDescription(), i.isThumbnail(), i.getUrl()))
        .collect(Collectors.toList()));
    return webResponse;
  }
}
