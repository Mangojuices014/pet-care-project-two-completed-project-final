package com.dailycodework.universalpetcare.dto;

import com.dailycodework.universalpetcare.enums.Size;
import com.dailycodework.universalpetcare.enums.Type;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.*;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Base64;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto extends AbstractDTO<ProductDto> {
    private Type type;
    private String name;
    private String sku;
    private String slug;
    private String description;
    private Long price;
    private Integer display;
    private String category;
    private byte[] photo;

    //pet
    private String fullName;
    private String colorPet;
    private String breedColor;
    private Integer age; // Tuổi
    private String healthStatus;

    //food
    private Double weight;
    private String nutritionFacts;
    private LocalDate expiry;

    //Medicine
    private LocalDate expirationDate;
    private String typeMedicine;
    private String usageInstruction;

    //CareTools
    private String typeCareTools;
    private String materialCareTool;
    private Size sizeCareTool;

    //Clothing
    private Size sizeClothing; // Kích cỡ (XS, S, M, L, XL)
    private String materialClothing; // Chất liệu (Cotton, Polyester, Wool,...)
    private String targetSpecies; // Loài mục tiêu (Dog, Cat, Rabbit,...)
    private String colorClothing; // Màu sắc
    private String style; // Phong cách (Casual, Fancy, Winter,...)
    private String season; // Mùa phù hợp (Summer, Winter, All Seasons)
    private String gender; // Giới tính của Pet (Male, Female, Unisex)
    
}
