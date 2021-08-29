package com.core.be.appbe.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;



public class TransactionRequest extends SessionIdRequest {

    @JsonProperty("productId")
    private Long productId;

    @JsonProperty("userId")
    private Long userId;

}
