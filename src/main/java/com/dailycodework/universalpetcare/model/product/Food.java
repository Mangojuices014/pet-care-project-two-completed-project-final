package com.dailycodework.universalpetcare.model.product;

import com.dailycodework.universalpetcare.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "food_id")
public class Food extends Product {
    private  Long id;
    @Column(name = "created_date")
    private String createdDate = new Timestamp(new Date().getTime()).toString();

    @Column(name = "updated_date")
    private String updatedDate = new Timestamp(new Date().getTime()).toString();
    @Column(name = "weight", nullable = false)
    private Double weight; // Khối lượng

    @Column(name = "nutrition_facts")
    private String nutritionFacts; // Thông tin dinh dưỡng

    @Column(name = "expiry", nullable = false)
    private LocalDate expiry; // Hạn sử dung
}