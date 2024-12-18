package com.dailycodework.universalpetcare.model.product;

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
@PrimaryKeyJoinColumn(name = "pet_for_sale_id")
public class PetForSale extends Product{
    private  Long id;
    @Column(name = "full_name", nullable = false)
    private String fullName;

    private String color;

    @Column(name = "breed", nullable = false)
    private String breed; // Giống loài

    @Column(name = "age", nullable = false)
    private Integer age; // Tuổi

    @Column(name = "health_status")
    private String healthStatus; // Tình trạng sức khỏe
}
