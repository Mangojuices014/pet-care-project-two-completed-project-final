package com.dailycodework.universalpetcare.model.product;

import com.dailycodework.universalpetcare.enums.Size;
import com.dailycodework.universalpetcare.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "clothing_id")
public class Clothing extends Product {

    private  Long id;

    @Column(name = "size", nullable = false)
    @Enumerated(EnumType.STRING)
    private Size size; // Kích cỡ (XS, S, M, L, XL)

    @Column(name = "material", nullable = false)
    private String material; // Chất liệu (Cotton, Polyester, Wool,...)

    @Column(name = "color")
    private String color; // Màu sắc

    @Column(name = "target_species")
    private String targetSpecies; // Loại động vật mục tiêu (Pet type like Dog, Cat, etc.)

    @Column(name = "style")
    private String style; // Phong cách (Casual, Fancy, Winter,...)

    @Column(name = "season")
    private String season; // Mùa phù hợp (Summer, Winter, All Seasons)

    @Column(name = "gender")
    private String gender; // Giới tính của Pet (Male, Female, Unisex)
}
