package com.dailycodework.universalpetcare.dto;

import com.dailycodework.universalpetcare.model.category.Category;
import com.dailycodework.universalpetcare.model.product.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class ProductListDto extends AbstractDTO<ProductListDto>{
    private String createdDate;
    private String name;
    private String slug;
    private Long price;
    private String mainImage;
    private CategoryDtoNew category;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Integer display;
    public ProductListDto() {
        // TODO Auto-generated constructor stub
    }

}
