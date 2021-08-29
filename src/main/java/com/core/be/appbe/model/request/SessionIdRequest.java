package com.core.be.appbe.model.request;

import com.core.be.appbe.common.base.BaseRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessionIdRequest extends BaseRequest {

    @JsonProperty("sessionId")
    private String sessionId;
}
