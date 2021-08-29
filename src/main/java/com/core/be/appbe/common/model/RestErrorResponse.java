package com.core.be.appbe.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestErrorResponse {

    private Integer status;
    private String message;
    private Date timestamp;
}
