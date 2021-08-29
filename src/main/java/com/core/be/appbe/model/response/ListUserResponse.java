package com.core.be.appbe.model.response;

import com.core.be.appbe.common.base.BasePaginationResponse;
import lombok.Data;

import java.util.List;

@Data
public class ListUserResponse extends BasePaginationResponse {

    private List<UserResponse> content;
}
