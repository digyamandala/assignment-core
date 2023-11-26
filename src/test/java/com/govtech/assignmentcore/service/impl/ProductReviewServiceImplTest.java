package com.govtech.assignmentcore.service.impl;

import com.govtech.assignmentcore.accessor.ProductReviewAccessor;
import com.govtech.assignmentcore.entity.ProductReview;
import com.govtech.assignmentcore.service.TimeService;
import com.govtech.assignmentcore.service.model.GetProductReviewServiceResponse;
import com.govtech.assignmentcore.service.model.InsertProductReviewServiceRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ProductReviewServiceImplTest {

  public static final int PRODUCT_ID = 1;

  @Mock
  private ProductReviewAccessor productReviewAccessor;

  @InjectMocks
  private ProductReviewServiceImpl service;

  @Mock
  private TimeService timeService;

  @Test
  void getProductReviewByProductId_empty() {
    BDDMockito.when(productReviewAccessor.getByProductId(PRODUCT_ID))
        .thenReturn(Collections.emptyList());

    List<GetProductReviewServiceResponse> response = service.getProductReviewByProductId(PRODUCT_ID);

    Assertions.assertThat(response)
        .isNotNull()
        .isEmpty();

    BDDMockito.verify(productReviewAccessor)
        .getByProductId(PRODUCT_ID);
  }

  @Test
  void getProductReviewByProductId_notEmpty() {
    BDDMockito.when(productReviewAccessor.getByProductId(PRODUCT_ID))
        .thenReturn(Collections.singletonList(new ProductReview("", 1, PRODUCT_ID, 1)));

    List<GetProductReviewServiceResponse> response = service.getProductReviewByProductId(PRODUCT_ID);

    Assertions.assertThat(response)
        .isNotNull()
        .isNotEmpty();
    BDDMockito.verify(productReviewAccessor)
        .getByProductId(PRODUCT_ID);
  }

  @Test
  void insert() {
    InsertProductReviewServiceRequest serviceRequest = new InsertProductReviewServiceRequest("", PRODUCT_ID, 1);

    BDDMockito.when(timeService.now())
        .thenReturn(1L);

    BDDMockito.given(productReviewAccessor.insert(any()))
        .willReturn(true);

    service.insert(serviceRequest);

    BDDMockito.verify(timeService)
        .now();
    BDDMockito.verify(productReviewAccessor)
        .insert(any());
  }

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
    Mockito.verifyNoMoreInteractions(productReviewAccessor, timeService);
  }
}