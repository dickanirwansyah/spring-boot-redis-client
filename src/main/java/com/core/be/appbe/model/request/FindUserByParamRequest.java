package com.core.be.appbe.model.request;

import com.core.be.appbe.common.base.BasePaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindUserByParamRequest extends BasePaginationRequest {

    private String username;
    private String status;
    private String role;
}
