package com.core.be.appbe.service.product;

import com.core.be.appbe.common.exception.GlobalErrorException;
import com.core.be.appbe.common.service.BaseService;
import com.core.be.appbe.common.util.Constants;
import com.core.be.appbe.model.request.FindByIdRequest;
import com.core.be.appbe.model.response.ValidResponse;
import com.core.be.appbe.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteProductService implements BaseService<FindByIdRequest, ValidResponse> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ValidResponse execute(FindByIdRequest request) {
        log.info("request delete : {}", request);
        productRepository.findById(request.getId()).ifPresentOrElse(product -> {
            product.setIsDelete(Constants.DELETED);
            productRepository.save(product);
        }, () -> {
            throw new GlobalErrorException(Constants.MSG_NOTFOUND);
        });

        return ValidResponse.builder()
                .response(true)
                .build();
    }
}
