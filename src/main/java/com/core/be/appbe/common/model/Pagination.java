package com.core.be.appbe.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pagination implements Serializable {

    private Integer pageSize;
    private Integer currentPage;
    private Integer totalPages;
    private Long totalRecords;
    private Boolean isFirstPage;
    private Boolean isLastPage;
}
