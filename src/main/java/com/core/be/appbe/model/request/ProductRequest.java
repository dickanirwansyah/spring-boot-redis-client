package com.core.be.appbe.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest extends FindByIdRequest {

    private String productName;
    private String productPrice;
    private String productExplanation;

}
