package com.core.be.appbe.common.service;

import com.core.be.appbe.common.base.BaseRequest;
import com.core.be.appbe.common.base.BaseResponse;

public interface BaseService <REQUEST extends BaseRequest, RESPONSE extends BaseResponse>{

    RESPONSE execute(REQUEST request);
}
