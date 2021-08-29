package com.core.be.appbe.service.product;

import com.core.be.appbe.common.exception.GlobalErrorException;
import com.core.be.appbe.common.service.BaseService;
import com.core.be.appbe.common.util.Constants;
import com.core.be.appbe.model.request.ProductRequest;
import com.core.be.appbe.model.response.ValidResponse;
import com.core.be.appbe.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class PutUpdateProductService implements BaseService<ProductRequest, ValidResponse> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ValidResponse execute(ProductRequest request) {
        log.info("update product : {}", request);
        productRepository.findById(request.getId())
                .ifPresentOrElse(product -> {
                    product.setName(request.getProductName());
                    product.setPrice(new BigDecimal(request.getProductPrice()));
                    product.setExplanation(request.getProductExplanation());
                    productRepository.save(product);
                }, () -> {
                    log.error("sorry product with id {} not found in database ",request.getId());
                    throw new GlobalErrorException(Constants.MSG_NOTFOUND);
                });

        return ValidResponse.builder()
                .response(true)
                .build();
    }
}
