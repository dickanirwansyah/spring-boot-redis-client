package com.core.be.appbe.model.response;

import com.core.be.appbe.common.base.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse extends BaseResponse {

    @JsonProperty("transactionId")
    private Long transactionId;

    @JsonProperty("productId")
    private Long productId;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("purchaseDate")
    private LocalDateTime purchaseDate;

}
