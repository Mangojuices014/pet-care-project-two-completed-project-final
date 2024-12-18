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
@PrimaryKeyJoinColumn(name = "medicine_id")
public class Medicine extends Product{
    private  Long id;
    @Column(name = "expiration_date")
    private LocalDate expirationDate; // Ngày hết hạn

    @Column(name = "type_medicine")
    private String typeMedicine;

    @Column(name = "usage_instruction")
    private String usageInstruction; // Hướng dẫn sử dụng


}
