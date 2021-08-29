package com.core.be.appbe.common.base;

import com.core.be.appbe.common.model.Pagination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasePaginationResponse extends BaseResponse{

    private Pagination pagination;
}
