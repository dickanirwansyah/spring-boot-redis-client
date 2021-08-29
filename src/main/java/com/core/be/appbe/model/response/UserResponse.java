package com.core.be.appbe.model.response;

import com.core.be.appbe.common.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse extends BaseResponse {

    private Long id;
    private String username;
    private String status;
    private String role;
}
