package com.core.be.appbe.common.service;

import com.core.be.appbe.common.base.BasePaginationRequest;
import com.core.be.appbe.common.base.BasePaginationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BasePageableService<REQUEST extends BasePaginationRequest,
        RESPONSE extends BasePaginationResponse> implements BaseService<REQUEST, RESPONSE> {

    @Value("${pageable.page.size}")
    private Integer pageSize;

    @Value("${pageable.page.number}")
    private Integer pageNumber;

    @Value("${pageable.page.sortBy}")
    private String sortBy;

    @Value("${pageable.page.sortType}")
    private String sortType;
}
