package com.dailycodework.universalpetcare.dto;

import com.dailycodework.universalpetcare.model.category.Category;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class CategoryDtoNew {
    private Long id;
    private String name;
    private String code;
    private Integer display;
    private String createdDate;

    public CategoryDtoNew() {
        // TODO Auto-generated constructor stub
    }

    public CategoryDtoNew(Category entity) {
        super();
        this.id = entity.getId();
        this.name = entity.getName();
        this.code = entity.getCode();
        this.display = entity.getDisplay();
        try {
            this.createdDate = new SimpleDateFormat("dd/MM/yyyy").format(
                    new Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(entity.getCreatedDate()).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
