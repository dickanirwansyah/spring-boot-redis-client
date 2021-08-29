package com.core.be.appbe.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest extends FindByIdRequest {

    private String username;
    private String password;
    private String status;
    private String role;

}
