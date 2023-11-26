package com.govtech.assignmentcore.service.impl;

import com.govtech.assignmentcore.accessor.ProductAccessor;
import com.govtech.assignmentcore.common.Page;
import com.govtech.assignmentcore.common.PagingRequest;
import com.govtech.assignmentcore.common.PagingRequestAccessor;
import com.govtech.assignmentcore.common.ProductFilterVo;
import com.govtech.assignmentcore.entity.Product;
import com.govtech.assignmentcore.entity.ProductImage;
import com.govtech.assignmentcore.service.ProductService;
import com.govtech.assignmentcore.service.TimeService;
import com.govtech.assignmentcore.service.model.GetListProductServiceRequest;
import com.govtech.assignmentcore.service.model.GetProductServiceResponse;
import com.govtech.assignmentcore.service.model.InsertProductServiceRequest;
import com.govtech.assignmentcore.service.model.ProductImageServiceResponse;
import com.govtech.assignmentcore.service.model.UpdateProductServiceRequest;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductAccessor productAccessor;

  private final TimeService timeService;

  public ProductServiceImpl(ProductAccessor productAccessor, TimeService timeService) {
    this.productAccessor = productAccessor;
    this.timeService = timeService;
  }

  @Override
  public GetProductServiceResponse getProductById(long id) {
    Product product = productAccessor.getProductById(id);
    if (Objects.isNull(product)) {
      throw new ValidationException("No Data Found!");
    }
    return toGetProductServiceResponse(product);
  }

  @Override
  public Page<GetProductServiceResponse> getProducts(GetListProductServiceRequest request) {
    Page<Product> productPage = productAccessor.getProducts(
        new ProductFilterVo(request.getCategory(), toPagingRequestAccessor(request.getPagingRequest()),
            request.getSku(), request.getTitle()));
    return new Page<>(productPage.getItemPerPage(), productPage.getItems()
        .stream()
        .map(this::toGetProductServiceResponse)
        .collect(Collectors.toList()), productPage.getPage(), productPage.getTotal());
  }

  @Override
  public boolean insert(InsertProductServiceRequest request) {
    long now = timeService.now();
    Product product = new Product();
    product.setSku(request.getSku());
    product.setCategory(request.getCategory());
    product.setDescription(request.getDescription());
    product.setPrice(request.getPrice());
    product.setWeight(request.getWeight());
    product.setTitle(request.getTitle());
    product.setImages(toProductImages(request));
    product.setAverageRating(0.0);
    product.setReviewCount(0);
    product.setCreatedDate(now);
    product.setLastModifiedDate(now);
    productAccessor.insert(product);
    return true;
  }

  @Override
  public boolean update(UpdateProductServiceRequest request) {
    productAccessor.update(request.getId(), request.getSku(), request.getCategory(), request.getTitle(),
        request.getDescription());
    return true;
  }

  private GetProductServiceResponse toGetProductServiceResponse(Product product) {
    GetProductServiceResponse serviceResponse = new GetProductServiceResponse();
    serviceResponse.setId(product.getId());
    serviceResponse.setTitle(product.getTitle());
    serviceResponse.setDescription(product.getTitle());
    serviceResponse.setWeight(product.getWeight());
    serviceResponse.setCategory(product.getCategory());
    serviceResponse.setReviewCount(product.getReviewCount());
    serviceResponse.setAverageRating(product.getAverageRating());
    serviceResponse.setCreatedDate(product.getCreatedDate());
    serviceResponse.setLastModifiedDate(product.getLastModifiedDate());
    serviceResponse.setImages(product.getImages()
        .stream()
        .map(productImage -> new ProductImageServiceResponse(productImage.getDescription(), productImage.isThumbnail(),
            productImage.getUrl()))
        .collect(Collectors.toList()));
    return serviceResponse;
  }

  private PagingRequestAccessor toPagingRequestAccessor(PagingRequest pagingRequest) {
    PagingRequestAccessor pagingRequestAccessor = new PagingRequestAccessor();
    pagingRequestAccessor.setItemPerPage(pagingRequest.getItemPerPage());
    pagingRequestAccessor.setSortBy(pagingRequest.getSortBy());
    pagingRequestAccessor.setOffset(pagingRequest.getItemPerPage() * (pagingRequest.getPage() - 1));
    return pagingRequestAccessor;
  }

  private List<ProductImage> toProductImages(InsertProductServiceRequest request) {
    return request.getImages()
        .stream()
        .map(pi -> new ProductImage(pi.getDescription(), pi.isThumbnail(), pi.getUrl()))
        .collect(Collectors.toList());
  }
}
