package com.core.be.appbe.common.base;

import lombok.*;

@Getter
@Setter
@ToString
public class BasePaginationRequest extends BaseRequest {

    private Integer pageSize;
    private Integer pageNumber;
    private String sortBy;
    private String sortType;
}
