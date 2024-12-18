package com.dailycodework.universalpetcare.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchDto {
    private int pageIndex;
    private int pageSize;
    private String keyword;
    private String sortBy; // name, price
    private String sortValue; // asc, desc
    private String tag; // tim theo tag
    private String brand; // tim theo thuong hieu
    private String price;
    private String category;
    private String subcategory;
    private Long productId;
    public SearchDto(int pageIndex, int pageSize, Long productId) {
        super();
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.productId = productId;
    }

    public SearchDto(int pageIndex, int pageSize, String keyword) {
        super();
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.keyword = keyword;
    }

    public SearchDto(int pageIndex, int pageSize, String keyword, String category, String subcategory) {
        super();
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.category = category;
        this.subcategory = subcategory;
    }
}
