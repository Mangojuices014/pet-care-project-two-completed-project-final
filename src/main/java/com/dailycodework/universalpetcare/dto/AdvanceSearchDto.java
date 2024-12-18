package com.dailycodework.universalpetcare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AdvanceSearchDto {
    private int pageIndex;
    private int pageSize;
    private String name;
    private String sku;
    private Integer display;
    private String category;

    // order
    private Integer last_date;
    private Integer status;

    public AdvanceSearchDto(int pageIndex, int pageSize, Integer status) {
        super();
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.status = status;
    }
}
