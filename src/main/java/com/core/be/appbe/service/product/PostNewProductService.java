package com.core.be.appbe.service.product;

import com.core.be.appbe.common.service.BaseService;
import com.core.be.appbe.model.entity.Product;
import com.core.be.appbe.model.request.ProductRequest;
import com.core.be.appbe.model.response.ValidResponse;
import com.core.be.appbe.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class PostNewProductService implements BaseService<ProductRequest, ValidResponse> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ValidResponse execute(ProductRequest request) {
        log.info("product request : {}", request);
        return ValidResponse.builder()
                .response(productRepository.save(Product
                        .builder()
                        .name(request.getProductName())
                        .explanation(request.getProductExplanation())
                        .price(new BigDecimal(request.getProductPrice()))
                        .build()))
                .build();
    }
}
