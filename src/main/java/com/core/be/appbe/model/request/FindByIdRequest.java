package com.core.be.appbe.model.request;

import com.core.be.appbe.common.base.BaseRequest;
import lombok.Data;

@Data
public class FindByIdRequest extends BaseRequest {

    private Long id;

}
